package com.java.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hospital {
    @Id
    private int id;

    private String name;

    private int numberOfDoctors;
    private int numberOfPatients;

    @OneToMany
    List<Doctor> doctors;

    @ManyToMany
    List<Patient> patients;
}
