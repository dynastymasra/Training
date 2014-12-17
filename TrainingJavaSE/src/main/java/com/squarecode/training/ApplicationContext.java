/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.squarecode.training;

import com.squarecode.training.config.ApplicationContextConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author   : @dynastymasra
 * User     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public class ApplicationContext {

    public AnnotationConfigApplicationContext annotationConfigApplicationContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationContextConfig.class);
        applicationContext.refresh();

        return applicationContext;
    }
}
