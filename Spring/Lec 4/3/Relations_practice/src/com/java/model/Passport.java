package com.java.model;

import org.hibernate.annotations.Entity;

import javax.persistence.Id;

@Entity
public class Passport {
    @Id
    private Long id;
    private String number;
}
