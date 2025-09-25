package com.java.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctor {
    @Id
    private int id;
    private String username;
    private Double salary;

    @OneToOne
    DoctorDetails doctorDetails;

    @ManyToOne
    Hospital hospital;

    @OneToMany
    List<Patient> patients;

}
