package com.spring.boot.service.impl;

import com.spring.boot.dto.TeacherDto;
import com.spring.boot.helper.CustomUserDetails;
import com.spring.boot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TeacherService teacherService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TeacherDto teacherDto = teacherService.getTeacherByUserName(username);

        return new CustomUserDetails(teacherDto);
    }
}
