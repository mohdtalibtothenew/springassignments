package jdbc.Question5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Q5Main {

        public static void main(String[] args) throws InterruptedException {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-config.xml");
            EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
            employeeService.insertCustomer();
            System.out.println("Finished");

        }

}
