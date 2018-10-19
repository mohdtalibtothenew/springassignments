package com.ttn.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("AOPConfig.xml");
        Database database =(Database) context.getBean("database",Database.class);
        System.out.println(database.connect());
    }
}
