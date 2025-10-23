package com.spring.boot.dto;

import com.spring.boot.model.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    private Long id;
    
    private String code;


    @ManyToMany
    private List<TeacherDto> teacherDtos;
}
