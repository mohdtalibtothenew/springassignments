package com.ttn.bootspring.controller;

import com.ttn.bootspring.entity.User;
import com.ttn.bootspring.service.StudentService;
import com.ttn.bootspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping ("/user")
    public User fetchUser(){
        return userService.getUser();

    }
    Integer port;
}
