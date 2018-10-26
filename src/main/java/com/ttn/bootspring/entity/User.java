package com.ttn.bootspring.entity;

public class User {
    private  Integer password;
    private String name;

    public User(){

    }

    public User(Integer password, String name) {
        this.password = password;
        this.name = name;
    }

    public Integer getPassward() {
        return password;
    }

    public void setPassward(Integer passward) {
        this.password = passward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
