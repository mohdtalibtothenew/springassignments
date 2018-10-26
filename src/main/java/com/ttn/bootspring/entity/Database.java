package com.ttn.bootspring.entity;

import org.springframework.beans.factory.annotation.Value;

public class Database {
    @Value("${database.port}")
    private int port;
    @Value("${database.name}")
    private String name;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
