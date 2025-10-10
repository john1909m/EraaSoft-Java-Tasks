package com.spring.boot.service.impl;

import com.spring.boot.model.Course;
import com.spring.boot.model.Student;
import com.spring.boot.repo.CourseRepo;
import com.spring.boot.repo.StudentRepo;
import com.spring.boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private  StudentRepo studentRepo;
    private CourseRepo courseRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public Course addStudentToCourse(Long courseId, Long studentId) {
        Student currentStudent = studentRepo.findById(studentId)
                .orElseThrow();
        Course currentCourse = courseRepo.findById(courseId).orElseThrow();
        currentStudent.getCourses().add(currentCourse);
        studentRepo.save(currentStudent);
        return currentCourse;
    }
}
