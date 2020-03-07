/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 *
 * @author ssoch
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
/*
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManager) throws Exception {
        authenticationManager
                .inMemoryAuthentication()
                .withUser("seba").password("admin123").roles("USER")
                .and()
                .withUser("admin").password("admin123").roles("USER", "ADMIN");
    }
*/

/*
    private String queryUserName = "SELECT username, password, enabled FROM user_auth WHERE username=?";
    private String queryAuth = "SELECT username, 'ROLE_USER' FROM user_auth where username=?";
    
    @Autowired
    DataSource dataSource;
    
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManager) throws Exception {
        authenticationManager
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(queryUserName)
                .authoritiesByUsernameQuery(queryAuth);
    }
*/
    @Autowired
    FlashCardUserDetailsService flashCardUserDetailsService;
        
    @Autowired
    PasswordEncoder passwordEncoder;
    
//    @Override
//    protected void configure(AuthenticationManagerBuilder authenticationManager) throws Exception {
//        authenticationManager
//                .userDetailsService(flashCardUserDetailsService)
//                .passwordEncoder(new StandardPasswordEncoder("53Kr3t"));
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManager) throws Exception {
        authenticationManager
                .userDetailsService(flashCardUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/logic/mainwindow")
                .logoutUrl("/logic/logout")
                .and()
                .authorizeRequests()
                .antMatchers("/logic/manageflashcards").hasRole("ADMIN")
                .antMatchers("/logic/lesson").hasAnyRole("USER", "ADMIN")
                .anyRequest().permitAll();
    }

    @Bean
    protected PasswordEncoder passwordEncoder () {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder("53Kr3t");
        return encoder;
    }
}
