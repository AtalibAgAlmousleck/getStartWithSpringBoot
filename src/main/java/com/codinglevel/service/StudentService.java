package com.codinglevel.service;

import com.codinglevel.entities.Student;
import com.codinglevel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository
                .findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("Student email already exist");
        } else {
            studentRepository.save(student);
        }

    }

    public void deleteStudent(Long studentId) {
        boolean studentExist = studentRepository.existsById(studentId);
        if(!studentExist) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        } else {
            studentRepository.deleteById(studentId);
        }
    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name, String email) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with id" + studentId + " does not exist"));

        if(name != null && name.length() > 0 &&
           !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if(studentOptional.isPresent()) {
                throw  new IllegalStateException("email already exist");
            }else {
                student.setEmail(email);
            }
        }

    }
}
