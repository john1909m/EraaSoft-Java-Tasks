package com.spring.boot.service;

import com.spring.boot.model.Course;
import com.spring.boot.model.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor addInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
    List<Course> getAllCourses();
}
