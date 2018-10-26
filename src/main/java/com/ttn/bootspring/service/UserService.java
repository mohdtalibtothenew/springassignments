package com.ttn.bootspring.service;

import com.ttn.bootspring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    User user;
    public User getUser(){

       user.getName();
       user.getPassward();

        return user;
    }
}
