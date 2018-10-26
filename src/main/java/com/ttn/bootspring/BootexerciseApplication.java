package com.ttn.bootspring;

import com.ttn.bootspring.entity.Database;
import com.ttn.bootspring.entity.Student;
import com.ttn.bootspring.entity.User;
import com.ttn.bootspring.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BootexerciseApplication {
	private static final Logger logger =  LoggerFactory.getLogger(SpringBootApplication.class);
	public static void main(String[] args) {
//	Question	Apply Logging whereever you feel is necessity
		logger.info("This is logger message");
		SpringApplication.run(BootexerciseApplication.class, args);
	}

//Question	Create Bean User containing two field username and password with Spring Context File
//Question	Create a Bean Database with two fields port and name and Access its values using application.properties
	@Bean
	public StudentService studentService(){
		StudentService studentService = new StudentService();
		return studentService;
	}
    @Bean
	public Student student(){
		Student student = new Student();
		return student;
	}
	@Bean
	public User user(){
		User user = new User();
		user.setPassward(1234);
		user.setName("Talib");
		return user;

	}

    @Bean
	public Database database(){
		Database database = new Database();
		/*database.setName("MySQL");
		database.setPort(8080);*/
		return database;
	}


}
