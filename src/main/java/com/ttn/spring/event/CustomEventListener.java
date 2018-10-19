package com.ttn.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {

        System.out.println( event.connect());
    }
}
