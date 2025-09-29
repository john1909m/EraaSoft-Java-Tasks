package com.spring.boot.service;

import com.spring.boot.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();


    Teacher addTeacher(Teacher teacher);


    Teacher updateTeacher(Teacher teacher);


    void deleteTeacher(Long id);

    Teacher getTeacherById(Long id);
}
