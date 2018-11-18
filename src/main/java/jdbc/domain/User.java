package jdbc.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "user")
public class User {

    @Id
    private Integer id;
    private String userName;
    private String password;
    private Integer age;
    private Double salary;
    private Date dob;

    public User() {
    }

    public User(Integer id, String userName, String password, Integer age, Double salary, Date dob) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.salary = salary;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dob=" + dob +
                '}';
    }
}
