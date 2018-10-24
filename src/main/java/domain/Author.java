package domain;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="First_Name")
    private String firstName;
    @Column(name = "Last_Name")
   // @Transient
    private String lastName;
    @Column(name = "Age")
    private Integer age;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Embedded
    Address address;

    @ElementCollection
    List<String> subjectList = new ArrayList<>();

    //@OneToOne
    //@JoinColumn(name = "Book_join_Column")
    //private Book book;


    /*@OneToMany//(mappedBy = "author")
    @JoinTable(joinColumns = @JoinColumn(name="Author_id")
            ,inverseJoinColumns = @JoinColumn(name = "Book_id"))*/
    //@OneToMany(cascade = CascadeType.ALL)
    @ManyToMany(targetEntity = Book.class)
    List<Book> bookList = new ArrayList<>();



    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Author() {
    }
    public Author(String firstName, String lastName, Integer age, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dob = dob;
    }
    public List<String> getSubjectList() {
        return subjectList;
    }
    public void setSubjectList(List<String> subjectList) {
        this.subjectList = subjectList;
    }



    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

   /* public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }*/

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
