package com.example.simpleApp.repos;

import com.example.simpleApp.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
