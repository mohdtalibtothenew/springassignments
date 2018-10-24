
import domain.Author;
import domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Date;


public class ManyToMany {
    public static void main(String[] args) {
        Author author1 = new Author();
        author1.setFirstName("Benjamin");
        author1.setLastName("Muschko");
        author1.setAge(62);

        author1.setDob(new Date(1923-9-30));
        Author author2 = new Author();
        author2.setFirstName("Benjamin");
        author2.setLastName("Muschko");
        author2.setAge(62);
        author2.setDob(new Date(1923-9-30));


        Book book1 =new Book();

        book1.setBookName("Gradle in Action");
        Book book2 = new Book();
        book2.setBookName("Groovy");
       // book1.setAuthor(author1);
        //book2.setAuthor(author1);
        author1.setBookList(Arrays.asList(book1,book2));
        author2.getBookList();
        book1.setAuthors(Arrays.asList(author1,author2));
       /*author.getBookList().add(book1);
       author.getBookList().add(book2);*/

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(book1);
        session.save(book2);
        session.save(author1);
        session.save(author2);
        session.getTransaction().commit();
        session.close();






    }
}
