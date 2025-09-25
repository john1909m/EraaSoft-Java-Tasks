package com.java.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient {
    @Id
    private int id;
    private String username;
    private String typeOfDisease;

    @ManyToOne
    Doctor doctor;

    @ManyToMany
    List<Hospital> hospitals;

}
