package com.spring.boot.service.impl;

import com.spring.boot.model.Course;
import com.spring.boot.model.Instructor;
import com.spring.boot.repo.CourseRepo;
import com.spring.boot.repo.InstructorRepo;
import com.spring.boot.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private InstructorRepo instructorRepo;
    private CourseRepo courseRepo;

    @Autowired
    public void setInstructorRepo(InstructorRepo instructorRepo, CourseRepo courseRepo) {
        this.instructorRepo = instructorRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepo.findAll();
    }

    @Override
    public List<Course> getAllCourses() {
        return  courseRepo.findAll();
    }
}
