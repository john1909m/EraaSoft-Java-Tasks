package com.spring.boot.controller;

import com.spring.boot.model.Course;
import com.spring.boot.model.Instructor;
import com.spring.boot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/course/add")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/instructor_course/add/{instructorId}/{courseId}")
    public Instructor addInstructorToCourse(@PathVariable Long instructorId, @PathVariable Long courseId) {
        return courseService.addInstructorToCourse(instructorId, courseId);
    }
}
