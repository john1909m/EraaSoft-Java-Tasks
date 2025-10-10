package com.spring.boot.service.impl;

import com.spring.boot.model.Course;
import com.spring.boot.model.Instructor;
import com.spring.boot.repo.CourseRepo;
import com.spring.boot.repo.InstructorRepo;
import com.spring.boot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepo courseRepo;
    private InstructorRepo instructorRepo;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo, InstructorRepo instructorRepo) {
        this.courseRepo = courseRepo;
        this.instructorRepo = instructorRepo;
    }


    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Instructor addInstructorToCourse(Long instructorId, Long courseId) {
        Course currentCourse = courseRepo.findById(courseId).get();
        Instructor currentInstructor = instructorRepo.findById(instructorId).get();
        currentCourse.setInstructor(currentInstructor);
        courseRepo.save(currentCourse);
        return currentInstructor;
    }
}
