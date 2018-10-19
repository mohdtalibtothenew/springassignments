package com.ttn.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
// Question Create listeners for spring events.
@Component
public class SpringEventListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("Event recieved" +event.getTimestamp());
    }
}
