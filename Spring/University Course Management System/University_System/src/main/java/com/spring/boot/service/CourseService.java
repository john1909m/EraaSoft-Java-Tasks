package com.spring.boot.service;

import com.spring.boot.model.Course;
import com.spring.boot.model.Instructor;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);
    List<Course> getAllCourses();
    Instructor addInstructorToCourse(Long instructorId, Long courseId);
}
