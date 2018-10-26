package com.ttn.bootspring.repositories;
import com.ttn.bootspring.entity.Student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositories extends CrudRepository<Student, Integer> {
}
