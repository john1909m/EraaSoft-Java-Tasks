package com.spring.boot.helper;

import com.spring.boot.dto.TeacherDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private TeacherDto teacherDto;
    public CustomUserDetails(TeacherDto teacherDto) {
        this.teacherDto = teacherDto;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> roles = teacherDto.getRoles().stream().map(
                roleDto -> new SimpleGrantedAuthority("ROLE_"+roleDto.getCode())
        ).collect(Collectors.toList());

        return roles;
    }

    @Override
    public String getPassword() {
        return "{noop}"+teacherDto.getPassword();
    }

    @Override
    public String getUsername() {
        return teacherDto.getUsername();
    }
}
