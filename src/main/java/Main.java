import domain.Address;
import domain.Author;
import domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        Author author = new Author();
        author.setFirstName("Benjamin");
        author.setLastName("Muschko");
        author.setAge(60);
        author.setDob(new Date(1923-9-30));

        author.setSubjectList(Arrays.asList("Tourism","SST","Geography"));

        Address address =new Address();
        address.setStreetNumber("C-2");
        address.setLocation("delhi");
        address.setState("Delhi");
        author.setAddress(address);

        Book book1 =new Book();
       // book.setBookName("Gradle in Action");
        book1.setBookName("Gradle in Action");
        Book book2 = new Book();
        book2.setBookName("Groovy");
        //book1.setAuthor(author);
        //book2.setAuthor(author);
        author.setBookList(Arrays.asList(book1,book2));
       /*author.getBookList().add(book1);
       author.getBookList().add(book2);*/

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(book1);
        session.save(book2);
        session.save(author);
        session.getTransaction().commit();
        session.close();
       // sessionFactory.close();

       /* session.beginTransaction();
        Author author1=session.get(Author.class,1);
       // author1.getAge();
        session.getTransaction().commit();
       // session.close();
        System.out.println(author1.getFirstName());*/




        

    }
}
