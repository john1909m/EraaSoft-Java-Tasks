package com.java.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DoctorDetails {
    @Id
    private int id;
    private String address;
    private String firstName;
    private String lastName;
    private int age;

    @OneToOne
    Doctor doctor;
}
