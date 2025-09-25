package com.java.model;

import org.hibernate.annotations.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "passport_id")
    private Passport passport;
}
