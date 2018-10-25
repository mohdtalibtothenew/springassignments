package com.springdata.repositories;

import com.springdata.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Set;

public interface PersonRepository extends CrudRepository<Person , Integer> {
    //Perform all the methods inside CrudRepository for Person Class.
    @Override
    Person  save(Person entity);
    @Override
    Person findOne(Integer integer);


    @Override
    long count();
    //Question For class Person find person declare methods in repository to find person by firstname, lastname and Id.
    Person findByFirstName(String firstName);
    Person findByLastName(String lastName);
    Person findById(Integer integer);
    //Question Use @Query to fetch firstname of the Person whose age is 25.
    @Query("select firstName from Person where age=:age")
    List<Person> findAllByAge(@Param("age") Integer age);
    //Question Use @Query to fetch firstname and lastname of the Person whose age is 25.
    @Query("select firstName, lastName from  Person where age=:age")
    List<String> findByAge(@Param("age") Integer age);
    //Use @Query to fetch firstname and lastname of the Person whose age is 25.
    @Query("select p from Person p where age =:age")
    List<Person> perrsonInfoByAge(@Param("age") Integer age);
    //Question Count Person where name is "Peter" using @Query.
    @Query("select count(*) from Person where firstName=:firstName")
    List<Person> countByFirstName(@Param("firstName") String firstName);

   //Question Implement following methods for Person repository: count, distinct, or, and, between, LessThan
    // GreaterThan, Like, Not, In, IgnoreCase
    List<Person> findDistinctByAge(Integer age);
    List<Person> findByFirstNameOrAge(String firstName ,Integer age);
    List<Person> findByFirstNameAndId(String firstName ,Integer id);
    List<Person> findByAgeBetween(Integer min, Integer max);
    List<Person> findByAgeLessThan(Integer age);
    List<Person> findByAgeGreaterThanEqual(Integer age);
    List<Person> findByFirstNameLike(String firstName);
    List<Person> findByFirstNameNot(String name);
    List<Person> findByAgeIn(List<Integer> ageList);

    //Question Get the persons greater than age 25 and sort them in descending order according to id by method query.
    List<Person> findByAgeGreaterThanOrderByIdDesc(Integer age);
    List<Person> findAll(Sort sort);
//    Apply Pagination on Person entities.
    Page<Person> findAll(Pageable pageable);










    /*@Query("SELECT id FROM Person WHERE firstName=?")
    List<String>findAllByFirstName(*//*@Param("firstName")*//* String firstName);
    @Query(value = "SELECT firstName,lastName FROM Person WHERE lastName=:lastName")
    List<String> findAllByLastName(@Param("lastName") String lasttName);*/


}
