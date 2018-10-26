package com.ttn.bootspring.controller;

import com.ttn.bootspring.BootexerciseApplication;
import com.ttn.bootspring.entity.Student;
import com.ttn.bootspring.repositories.StudentRepositories;
import com.ttn.bootspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepositories studentRepositories;

    @GetMapping("/student")
    public List<Student> getStudent(){
        return (List<Student>) studentRepositories.findAll();
    }

}
