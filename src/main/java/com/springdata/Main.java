package com.springdata;

import com.springdata.entity.Person;
import com.springdata.repositories.PersonJPARepository;
import com.springdata.repositories.PersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdata.configuration.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);
        PersonRepository personRepository = context.getBean(PersonRepository.class);
        //Perform all the methods inside CrudRepository for Person Class.
        for(int i = 0;i<10;i++) {
            Person person = new Person();
            person.setFirstName("PersonFirst"+i);
            person.setLastName("PersonLast"+i);
            person.setSalary(100000);
            person.setAge(23+i);
            personRepository.save(person);
        }
        //System.out.println(personRepository.findOne(1));
        //System.out.println(personRepository.count());

        //Question For class Person find person declare methods in repository to find person by firstname, lastname and Id.
        /*System.out.println(personRepository.findByFirstName("PersonFirst0"));
        System.out.println(personRepository.findByLastName("PersonLast2"));
        System.out.println(personRepository.findById(2));*/
        //Question Use @Query to fetch firstname of the Person whose age is 25.
        List<Person> personList = personRepository.findAllByAge(25);
        System.out.println(personList);
        //Question Use @Query to fetch firstname and lastname of the Person whose age is 25.
        List<String> personList1 = personRepository.findByAge(25);
        for(Object person:personList1){
        System.out.println("First name and Last name"+person.toString());}
        // Question Use @Query to fetch firstname and lastname of the Person whose age is 25.
        List <Person> personList2 =personRepository.perrsonInfoByAge(25);
        System.out.println(personList2);
        //Question Count Person where name is "Peter" using @Query.
        List<Person> personList3 = personRepository.countByFirstName("PersonFirst0");
        System.out.println(personList3);
        //Question Implement following methods for Person repository: count, distinct, or, and, between, LessThan
        // GreaterThan, Like, Not, In, IgnoreCase
        /*List<Person> personList4 = personRepository.findDistinctByAge(24);
        List<Person> personList5 = personRepository.findByFirstNameOrAge("PersonFirst2" ,26);
        List<Person> personList6 = personRepository.findByFirstNameAndId("PersonFirst2",26);
        List<Person> personList7 = personRepository.findByAgeBetween(23,27);
        List<Person> personList8 = personRepository.findByAgeLessThan(27);
        List<Person> personList9 = personRepository.findByAgeGreaterThanEqual(26);
        List<Person> personList10 = personRepository.findByFirstNameLike("PersonFirst3");
        List<Person> personList11 = personRepository.findByFirstNameNot("PersonFirst0");
        List<Person> personList12 = personRepository.findByAgeIn(Arrays.asList(23,24,25));
        System.out.println(personList4);
        System.out.println(personList5);
        System.out.println(personList6);
        System.out.println(personList7);
        System.out.println(personList8);
        System.out.println(personList9);
        System.out.println(personList10);
        System.out.println(personList11);
        System.out.println(personList12);*/




        //Question Use JPA Criteria API for following operations for person :equals, gt, lt, and, or between
        PersonJPARepository personJPARepository = context.getBean(PersonJPARepository.class);
        Specification<Person> personSpecification = new Specification<Person>() {
        @Override
        public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            Path path = root.get("id");
            Path path1 = root.get("firstName");
            Path path2 = root.get("age");
//            equals
//            Predicate predicate = cb.equal(path,1);
//            lt
//            Predicate predicate = cb.lt(path,5);
//            and
//            Predicate predicate =cb.and(cb.equal(path,2),cb.equal(path1,"PersonFirst1"));
//            or
//            Predicate predicate =cb.or(cb.equal(path,2),cb.equal(path1,"PersonFirst1"));
            Predicate predicate = cb.between(path,5,7);
            return  predicate;
        }
    };

        System.out.println(personJPARepository.findAll(personSpecification));
//        Question Get the persons greater than age 25 and sort them in descending order according to id by method query.
        List<Person> personList13 = personRepository.findByAgeGreaterThanOrderByIdDesc(25);
        System.out.println(personList13);
//        Question Do  the question above using the Sort class.
        List<Person> list = personRepository.findAll(new Sort("age").and(
                new Sort(Sort.Direction.ASC,"firstName")));

//        Apply Pagination on Person entities.
        Page<Person> personPage= personRepository.findAll(new PageRequest(0,5,new Sort(Sort.Direction.DESC,"id")));
        List<Person> personList14=personPage.getContent();
        System.out.println(personList14);





    }
}
