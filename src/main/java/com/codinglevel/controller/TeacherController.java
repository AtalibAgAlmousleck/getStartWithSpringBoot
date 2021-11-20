package com.codinglevel.controller;

import com.codinglevel.entities.Teacher;
import com.codinglevel.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public List<Teacher> getAll() {
        return teacherService.getTeachers();
    }

    @PostMapping("/add")
    public void insertNewTeacher(@RequestBody Teacher teacher) {
        teacherService.insertTeacher(teacher);
    }

    @DeleteMapping(path = "{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }

    @PutMapping("{teacherId}")
    public void updateTeacher(@PathVariable("teacherId") Long teacherId,
                            @RequestParam(required = false) String name) {
        teacherService.updateTeacher(teacherId, name);
    }
}
