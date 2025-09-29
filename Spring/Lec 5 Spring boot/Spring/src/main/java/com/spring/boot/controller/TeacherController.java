package com.spring.boot.controller;

import com.spring.boot.model.Teacher;
import com.spring.boot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public void TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        return teacherService.getAllTeachers();

    }

    @PostMapping("/teacher/add")
    public Teacher addTeacher(Teacher teacher) {
        return teacherService.addTeacher(teacher);

    }

    @PutMapping("/teacher/update")
    public Teacher updateTeacher(Teacher teacher) {
        return teacherService.updateTeacher(teacher);

    }

    @DeleteMapping("/teacher/delete")
    public void deleteTeacher(Long id) {
        teacherService.deleteTeacher(id);

    }

    @GetMapping("/teacher")
    public Teacher getTeacher(Long id) {
        return teacherService.getTeacherById(id);

    }









}
