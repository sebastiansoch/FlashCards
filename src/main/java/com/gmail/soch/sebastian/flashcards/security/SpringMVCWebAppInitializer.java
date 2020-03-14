/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards.security;

import com.gmail.soch.sebastian.flashcards.configuration.LoginApplicationConfigThymeleaf;
import com.gmail.soch.sebastian.flashcards.configuration.LoginApplicationConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author ssoch
 */
public class SpringMVCWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
//        return new Class[] {LoginApplicationConfig.class};
        return new Class[] {LoginApplicationConfigThymeleaf.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/logic/*"};
    }
    
}
