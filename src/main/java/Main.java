import entity.Circle;
import entity.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ShapeService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Circle circle =  context.getBean("circle", Circle.class);
        Triangle triangle = context.getBean("triangle", Triangle.class);
        ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
        System.out.println(shapeService.getCircle().getName());
        circle.setName("Circle1");
        System.out.println(triangle.getName());


    }
}
