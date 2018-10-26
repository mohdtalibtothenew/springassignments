package com.ttn.bootspring;

import com.ttn.bootspring.entity.Student;
import com.ttn.bootspring.repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Iterator;
//Question Bootstrap Data for Student Domain
@Component
public class StudentBootstrap {
    @Autowired
    StudentRepositories studentRepositories;

    @EventListener(ApplicationStartedEvent.class)
    public void init(){
        Iterator<Student> studentIterator = studentRepositories.findAll().iterator();
        if(!studentIterator.hasNext()){
            for(int i=1;i<=10;i++){
                Student student = new Student("Student","Delhi");
                studentRepositories.save(student);
                System.out.println("Student "+i+" Added");
            }
        }
        System.out.println("Your Application Is Up And Runing");

    }


}
