package com.example.blog_api.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
    //@Bean is used to indicate that a method within a @Configuration class will produce a bean managed by the Spring
    //container. This allows to define and configure beans using Java code instead of XML configuration.
    //@EnableWebSecurity annotation enables the Spring Security configuration for your application.
    //@Configuration annotation indicates that a class defines one or more @Bean methods and can be processed by the Spring
    //container to generate Spring beans



}
