package com.gradle.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class Restaurant {

   private HotDrink hotDrink;

//    public Restaurant(HotDrink hotDrink) {
//        this.hotDrink = hotDrink;
//    }



    public HotDrink getHotDrink() {
        return hotDrink;
    }
    //@Required
   // @Autowired
    public void setHotDrink(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }


    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");
        Database database = applicationContext.getBean("database",Database.class);
        System.out.println(database);




        Restaurant tea = applicationContext.getBean("teaRestaurant", Restaurant.class);
       // Restaurant expresstea = applicationContext.getBean("expressTeaRestaurant", Restaurant.class);
        Restaurant tea1 = applicationContext.getBean("teaRestaurant", Restaurant.class);
      //  System.out.println(tea.hotDrink.prepareHotDrink());
        //System.out.println(expresstea.hotDrink.prepareHotDrink());

        Complex complex = applicationContext.getBean("complexBean",Complex.class);
        System.out.println(complex);
        //for Scop test
        System.out.println(tea==tea1);

    }
}
