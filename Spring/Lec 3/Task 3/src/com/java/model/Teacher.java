package com.java.model;

import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String name;

    @Column(columnDefinition = "NUMBER(3) CHECK (age BETWEEN 15 AND 20)")
    private int age;

    @Column(unique = true)
    private String address;
}
