package com.spring.boot.dto;

import jakarta.persistence.*;


public class TeacherDto {


    private Long id;


    private String username;

    public TeacherDto(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    private String password;

    public TeacherDto() {

    }

    public TeacherDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
