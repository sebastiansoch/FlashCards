/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ssoch
 */
@Configuration
public class ConfigurationJPA {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/EnglishFlashCards");
        dataSource.setUsername("postgres");
        dataSource.setPassword("wKnpim100razy");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setPackagesToScan(new String[]{"com.gmail.soch.sebastian.flashcards.entity"});
        Properties props = new Properties();
        props.setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");
        sfb.setHibernateProperties(props);
        return sfb;
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("com.gmail.soch.sebastian_FlashCards_war_1.0-SNAPSHOTPU");
        return emfb;
    }

}
