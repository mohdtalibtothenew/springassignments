package jdbc;

import jdbc.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Application {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application-config.xml");
        SpringJdbc springJdbc=applicationContext.getBean(SpringJdbc.class);
        springJdbc.preparedStatement();

        //CustomJDBCTemplate customJDBCTemplate=applicationContext.getBean(CustomJDBCTemplate.class);
        CustomJDBCTemplate customJDBCTemplate=(CustomJDBCTemplate) applicationContext.getBean("customJDBCTemplate");
        System.out.print("Number of users are:");
        customJDBCTemplate.countUser();
        System.out.println("UserName is:"+customJDBCTemplate.getUserName());


        User user=new User(6,"abc","xus",22,23445.44,new Date());
//        User user=applicationContext.getBean(User.class);
//        customJDBCTemplate.addUser(user);
        System.out.print("Using Query For map");
        customJDBCTemplate.queryForMapDemo();

        System.out.println("Using Query For List");
        customJDBCTemplate.queryForListDemo();

        System.out.println("Using rowmapper");
        System.out.println(customJDBCTemplate.getUser());


        NamedParameterDemo namedParameterDemo=applicationContext.getBean(NamedParameterDemo.class);
        System.out.println(namedParameterDemo.namedParameterJdbcTemplateDemo());

        HibernateExemple hibernateExemple=applicationContext.getBean(HibernateExemple.class);
        System.out.println("Using Session Factory");
        hibernateExemple.sessionFactoryDemo();


    }

}
