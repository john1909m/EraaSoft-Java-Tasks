package com.spring.boot.service.impl;
import com.spring.boot.dto.TeacherDto;
import com.spring.boot.model.Teacher;
import com.spring.boot.repo.TeacherRepo;
import com.spring.boot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    TeacherRepo teacherRepo;

    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherRepo.findAll();
        return teachers.stream().map(teacher ->
                new TeacherDto(teacher.getId(), teacher.getUsername(), teacher.getPassword()))
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto) {
        if(Objects.nonNull(teacherDto.getId())){
            throw new RuntimeException("id.teacher.notRequired");
        }
        if(Objects.isNull(teacherDto.getUsername())){
            throw new RuntimeException("username.teacher.required");
        }
        if(Objects.isNull(teacherDto.getPassword())){
            throw new RuntimeException("password.teacher.required");
        }
        Optional<Teacher> teacherOptional = teacherRepo.findByusername(teacherDto.getUsername());
        if(teacherOptional.isPresent()){
            throw new RuntimeException("teacher.exist");
        }
        Teacher teacher = teacherRepo.save(new Teacher(teacherDto.getUsername(),teacherDto.getPassword()));
        teacherDto.setId(teacher.getId());
        return teacherDto;
    }

    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) {
        if(Objects.isNull(teacherDto.getId())){
            throw new RuntimeException("id.teacher.Required");
        }
        Teacher teacher = teacherRepo.save(new Teacher(teacherDto.getId(),teacherDto.getUsername(),teacherDto.getPassword()));
        return teacherDto;

    }

    @Override
    public void deleteTeacher(Long id) {
        Optional<Teacher> teacherOptional = teacherRepo.findById(id);
        if(teacherOptional.isEmpty()){
            throw new RuntimeException("teacher.notExist");
        }
        teacherRepo.deleteById(id);
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        Optional<Teacher> teacherOptional = teacherRepo.findById(id);
        if(teacherOptional.isEmpty()){
            throw new RuntimeException("teacher.notExist");
        }
        Teacher teacher =teacherOptional.get();
        return new TeacherDto(teacher.getId(), teacher.getUsername(), teacher.getPassword());
    }

    @Override
    public TeacherDto getTeacherByUserName(String userName) {
        Optional<Teacher> teacherOptional = teacherRepo.findByusername(userName);
        if(teacherOptional.isEmpty()){
            throw new RuntimeException("teacher.notExist");
        }
        Teacher teacher =teacherOptional.get();
        return new TeacherDto(teacher.getId(), teacher.getUsername(), teacher.getPassword());
    }
}
