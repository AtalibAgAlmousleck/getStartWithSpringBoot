package com.codinglevel.repository;

import com.codinglevel.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // SELECT * FROM student_table WHERE email = ?
    Optional<Student> findStudentByEmail(String email);
}
