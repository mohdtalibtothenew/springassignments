package com.ttn.spring.event.aspect;


import com.ttn.spring.event.Database;
import org.aspectj.lang.annotation.*;
/*Question Try all AOP wild expressions which we discussed, on the Database class which we created..
        Apply Before, After, AfterReturning, AfterThrowing and Around Advice for the methods of the database class.*/
@Aspect
public class MyAspect {
    @Before("execution(String connect())")
    void beforeAdvice() {
        System.out.println("Running before advice");
    }
    @After("execution(String connect())")
    void afterAdvice() {
        System.out.println("Running after advice");
    }
    @AfterReturning("execution(String connect())")
    void afterReturning() {
        System.out.println("Running AfterReturning advice");
    }
    @AfterThrowing("execution(String connect())")
    void afterThrowing() {
        System.out.println("Running after throwing advice");
    }
    /*@Around("execution(String connect())")
    void aroundAdvice() {
        System.out.println("running Around");
    }*/

}
