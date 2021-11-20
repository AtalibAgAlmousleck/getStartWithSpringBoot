package com.codinglevel.controller;

import com.codinglevel.entities.Student;
import com.codinglevel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/all")
    public List<Student> getStudents() {
        return studentService.getStudent();
    }

    @PostMapping("/save")
    public void addNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
        System.out.println("Insert student = " + student);
    }

    @DeleteMapping(path = "{studentId}")
    public void removeStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
        System.out.println("Delete student = " + studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
