package com.ttn.bootspring.controller;

import com.ttn.bootspring.entity.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {
//Question Create a Bean Database with two fields port and name and Access its values using application.properties
    @Autowired
    Database database;
    @Value("${database.port}")
    Integer port;
    @Value("${database.name}")
    String databaseName;

    @GetMapping("/port")
    public Integer getPort(){
        return port;
    }
    @GetMapping("/databaseName")
    public String getDatabaseName(){
        return databaseName;
    }
}
