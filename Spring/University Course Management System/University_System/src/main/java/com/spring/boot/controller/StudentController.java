package com.spring.boot.controller;

import com.spring.boot.model.Course;
import com.spring.boot.model.Student;
import com.spring.boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student")
    public Student getStudentById(@RequestParam Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/student/addCourse/{studentId}/{courseId}")
    public Course addCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.addStudentToCourse(courseId,studentId);
    }
}
