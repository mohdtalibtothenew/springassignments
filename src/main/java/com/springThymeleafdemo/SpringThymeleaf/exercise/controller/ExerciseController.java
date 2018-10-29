package com.springThymeleafdemo.SpringThymeleaf.exercise.controller;

import com.springThymeleafdemo.SpringThymeleaf.exercise.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class ExerciseController {

    @Autowired
    private Employee employee;

    @GetMapping("/question1")
    public String alertThrowing() {
        return "layouts/exercise";
    }

    @GetMapping("/register")
    public String employeeRegister(Employee employee) {
        return "layouts/register";
    }

    /*
     Create a dynamic HTML page and render an Employee table
     with emp object return from the controller */
    @PostMapping("/employeesubmit")
    public String getEmployeedetails(@ModelAttribute("employee") Employee employee) {

        System.out.println("-----------------------");
        System.out.println(employee);
        System.out.println("-----------------------");
        //employee.setAdmin(true);

        return "layouts/employee";
    }

    /*Adding Loader*/
    @GetMapping("/loader")
    public String register(Employee employee) {
        return "layouts/loader";
    }

    //TODO:Make a web page to show server time using ajax call.
    @GetMapping("/serverTime")
    public String showServerTime() {
        return "layouts/serverTime";
    }

    @GetMapping("/currentTime")
    @ResponseBody
    public String currentTime() {
        return LocalDateTime.now().toString();
    }
}
