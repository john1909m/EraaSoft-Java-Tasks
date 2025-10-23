package com.spring.boot.Mapper;


import com.spring.boot.dto.TeacherDto;
import com.spring.boot.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {


    Teacher toEntity(TeacherDto teacherDto);

//    @Mapping(target="password",ignore = true)
    TeacherDto toDto(Teacher teacher);
    List<Teacher> toEntityList(List<TeacherDto> teacherDtoList);
    List<TeacherDto> toDtoList(List<Teacher> teachers);


}
