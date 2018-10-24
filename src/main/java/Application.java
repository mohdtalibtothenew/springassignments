import domain.Address;
import domain.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        Author author = new Author();
        author.setFirstName("Bob");
        author.setLastName("Maley");
        author.setAge(60);
        author.setDob(new Date(1923-9-30));
        Address address =new Address();
        address.setStreetNumber("C-2");
        address.setLocation("delhi");
        address.setState("Delhi");
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }
}
