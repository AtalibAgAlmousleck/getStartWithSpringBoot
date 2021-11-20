package com.codinglevel.service;

import com.codinglevel.entities.Student;
import com.codinglevel.entities.Teacher;
import com.codinglevel.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void insertTeacher(Teacher teacher) {
        Optional<Teacher> ifTeacherExistThenThrowException = teacherRepository
                .findTeacherByName(teacher.getName());
        if(ifTeacherExistThenThrowException.isPresent()) {
            throw new IllegalStateException("Teacher already exist");
        } else {
            teacherRepository.save(teacher);
        }
    }

    public void deleteTeacher(Long teacherId) {
        boolean ifTeacherExist = teacherRepository.existsById(teacherId);
        if(!ifTeacherExist) {
            throw  new IllegalStateException("Teacher with id " + teacherId + " does not exist");
        } else {
            teacherRepository.deleteById(teacherId);
        }
    }

    public void updateTeacher(Long teacherId, String name) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalStateException("teacher with id" + teacherId + " does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(teacher.getName(), name)) {
            Optional<Teacher> teacherOptional = teacherRepository
                    .findTeacherByName(name);
            if(teacherOptional.isPresent()) {
                throw  new IllegalStateException("teacher already exist");
            } else {
                teacher.setName(name);
            }
        }
    }


}

























