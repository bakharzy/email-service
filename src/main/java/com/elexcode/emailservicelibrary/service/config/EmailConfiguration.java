/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elexcode.emailservicelibrary.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author mohi
 */
//@Configuration
//@PropertySource("classpath:com/elexcode/emailservicelibrary/service/emailCredentials.properties")
//@ComponentScan(basePackages = "com.elexcode.emailservicelibrary.service")
public class EmailConfiguration {

    @Value("${google.host}")
    private String host;
    
    @Value("${google.port}")
    private int port;
    
    @Value("${google.username}")
    private String username;
    
    @Value("${google.password}")
    private String password;

    public String getHost() {
        return host;
    }
    
    public int getPort(){
        return port;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}