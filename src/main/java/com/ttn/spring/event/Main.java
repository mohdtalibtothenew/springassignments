package com.ttn.spring.event;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//Question Get the bean of the type Database from Spring config.
        Database database = context.getBean("database", Database.class);
// Question Print the values of the instance variables.
       System.out.println(database);
// Question Invoke context events start(), stop() and close().
        // context.start();
        //context.stop();
        //context.close();
        CustomEventPublisher customEventPublisher = (CustomEventPublisher)context.getBean("customEventPublisher", CustomEventPublisher.class);
        customEventPublisher.display();

    }
}
