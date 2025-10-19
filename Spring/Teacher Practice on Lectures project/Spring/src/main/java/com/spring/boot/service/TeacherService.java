package com.spring.boot.service;

import com.spring.boot.dto.TeacherDto;


import java.util.List;

public interface TeacherService {

    List<TeacherDto> getAllTeachers();


    TeacherDto addTeacher(TeacherDto teacher);


    TeacherDto updateTeacher(TeacherDto teacher);


    void deleteTeacher(Long id);

    TeacherDto getTeacherById(Long id);

    TeacherDto getTeacherByUserName(String userName);
}
