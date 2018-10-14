package com.gradle.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    Database database() {
        Database database = new Database();
        return database;
    }
    @Bean
    Tea tea(){
        Tea tea = new Tea();
        return tea;
    }
}