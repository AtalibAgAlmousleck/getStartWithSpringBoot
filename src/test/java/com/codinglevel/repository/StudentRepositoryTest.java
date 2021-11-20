package com.codinglevel.repository;

import com.codinglevel.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    private final StudentRepository studentRepository;

    @Autowired
    StudentRepositoryTest(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Test
    public void saveStudent() {

     Student atalib = Student.builder()
             .name("Atalib")
             .email("atalib@gmail.com")
             .major("COMPUTER SCIENCE")
             .dob(LocalDate.of(1997, Month.JANUARY, 10))
             .build();

        Student benjamin = Student.builder()
                .name("Benjamin")
                .email("benji@gmail.com")
                .major("COMPUTER SCIENCE")
                .dob(LocalDate.of(1998, Month.JANUARY, 9))
                .build();

        studentRepository.saveAll(
                List.of(
                        atalib, benjamin
                )
        );
    }
}