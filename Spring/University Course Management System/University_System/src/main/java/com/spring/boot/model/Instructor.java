package com.spring.boot.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "instructor")
    private List<Course> course;

    public Instructor(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Instructor(String name, String email, List<Course> course) {
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public Instructor() {

    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public List<Course> getCourse() {return course;}

    public void setCourse(List<Course> course) {this.course = course;}
}
