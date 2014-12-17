/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.squarecode.training.config;

import java.util.Properties;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Author   : @dynastymasra
 * User     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
@Configuration
@PropertySource(value = "classpath:mysql.properties")
@ComponentScan({"com.squarecode.training.controller", "com.squarecode.training.repository"})
@EnableTransactionManagement
public class ApplicationContextConfig {

    @Resource
    private Environment environment;

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setMaxActive(80);
        dataSource.setMaxIdle(20);
        dataSource.setMaxWait(40000);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());

        return jdbcTemplate;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.squarecode.training.domain");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "false");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.cache.use_query_cache", "false");
        properties.setProperty("hibernate.cache.use_second_level_cache", "false");
        factoryBean.setJpaProperties(properties);

        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(emf);
        return jpaTransactionManager;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }
}
