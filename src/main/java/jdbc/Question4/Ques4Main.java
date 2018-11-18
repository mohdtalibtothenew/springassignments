package jdbc.Question4;

import jdbc.Dao.CustomerDAO;
import jdbc.domain.Address;
import jdbc.domain.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ques4Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-config.xml");
        CustomerDAO dao = (CustomerDAO) ctx.getBean("customerDAO");

        /*Using Platform Transaction*/
        UserServicePlatformTransaction platformTransaction = (UserServicePlatformTransaction) ctx.getBean(UserServicePlatformTransaction.class);
        platformTransaction.doInTransaction(dao, createDummyCustomer());


        /*Transaction Template*/
        UserService userService=ctx.getBean(UserService.class);
        userService.inTransactionWithReturn(dao,createDummyCustomer());
        userService.inTransactionWithoutReturn(dao,createDummyCustomer());
    }

    private static Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setId(2);
        customer.setName("Talib");
        Address address = new Address();
        address.setId(222);
        address.setAddress("address2");
        address.setCountry("India");
        customer.setAddress(address);
        return customer;
    }
}
