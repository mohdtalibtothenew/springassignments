package com.springdata.repositories;

import com.springdata.entity.Person;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;
public interface PersonJPARepository extends Repository<Person,Integer>, JpaSpecificationExecutor<Person> {
}
