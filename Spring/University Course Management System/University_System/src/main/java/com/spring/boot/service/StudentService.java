package com.spring.boot.service;

import com.spring.boot.model.Course;
import com.spring.boot.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student addStudent(Student student);
    Student getStudentById(Long id);
    Course addStudentToCourse(Long courseId, Long studentId);
}
