package com.codinglevel.repository;

import com.codinglevel.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository
        extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findTeacherByName(String name);
}
