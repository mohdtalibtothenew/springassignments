package com.springThymeleafdemo.SpringThymeleaf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringThymeleafApplication.class, args);


	}
	@EventListener(ApplicationStartedEvent.class)
	void message(){
		System.out.println("Application is up and running ");
	}
}
