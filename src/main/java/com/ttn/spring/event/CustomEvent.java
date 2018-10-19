package com.ttn.spring.event;

import org.springframework.context.ApplicationEvent;
// Question Create a CustomEvent which should get published when you invoke connect method of database bean.
public class CustomEvent extends ApplicationEvent {

    CustomEvent(Object object){
        super(object);

    }
    String connect(){
       return  (new Database()).connect();
    }
}
