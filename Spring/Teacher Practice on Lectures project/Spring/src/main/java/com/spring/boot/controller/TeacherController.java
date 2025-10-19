package com.spring.boot.controller;

import com.spring.boot.dto.TeacherDto;
import com.spring.boot.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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
    public ResponseEntity<List<TeacherDto>> getTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());

    }

    @PostMapping("/teacher/add")
    public ResponseEntity<TeacherDto> addTeacher(@Valid @RequestBody TeacherDto teacher) throws URISyntaxException {
        return ResponseEntity.created(new URI("/teacher/add")).body(teacherService.addTeacher(teacher));

    }

    @PutMapping("/teacher/update")
    public ResponseEntity<TeacherDto> updateTeacher(@RequestBody TeacherDto teacher) {
        return ResponseEntity.ok(teacherService.updateTeacher(teacher));

    }

    @DeleteMapping("/teacher/delete/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/teacher")
    public ResponseEntity<TeacherDto> getTeacher(@RequestParam Long id) {
        return ResponseEntity.ok(teacherService.getTeacherById(id));

    }


    @GetMapping("/teacher/{username}")
    public ResponseEntity<TeacherDto> getTeacher(@PathVariable String username) {
        return ResponseEntity.ok(teacherService.getTeacherByUserName(username));

    }









}
