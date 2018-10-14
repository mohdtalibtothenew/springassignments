package com.gradle.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component

public class Main1 {
    @Qualifier("tea")
     private HotDrink hotDrink;

    public HotDrink getHotDrink() {
        return hotDrink;
    }
    //@Autowired

    public void setHotDrink(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    public Main1(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config1.xml");
      Main1 tea1 = applicationContext.getBean(Main1.class);
      System.out.println(tea1.hotDrink.prepareHotDrink());
      //  Tea tea =applicationContext.getBean(Tea.class);

//        System.out.println(tea.prepareHotDrink()); //uncomment to see @Controller and @Service





    }
}
