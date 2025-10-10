package com.spring.boot.controller;

import com.spring.boot.dto.TeacherDto;
import com.spring.boot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public void TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<TeacherDto> getTeachers() {
        return teacherService.getAllTeachers();

    }

    @PostMapping("/teacher/add")
    public TeacherDto addTeacher(@RequestBody TeacherDto teacher) {
        return teacherService.addTeacher(teacher);

    }

    @PutMapping("/teacher/update")
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacher) {
        return teacherService.updateTeacher(teacher);

    }
    //method param
//    @DeleteMapping("/teacher/delete")
//    public void deleteTeacher(@RequestParam("t_id") Long id) {
//        teacherService.deleteTeacher(id);
//
//    }
    @DeleteMapping("/teacher/delete/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);

    }

    @GetMapping("/teacher")
    public TeacherDto getTeacher(@RequestParam Long id) {
        return teacherService.getTeacherById(id);

    }


    @GetMapping("/teacher/username")
    public TeacherDto getTeacher(@RequestParam String username) {
        return teacherService.getTeacherByUserName(username);

    }









}
