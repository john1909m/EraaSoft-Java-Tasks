package com.java.model;

import javax.persistence.*;
import java.util.List;

public class Rest_of_relations {
    @Entity
    public class Library {
        @Id
        private Long id;

        @OneToMany(mappedBy = "library")
        private List<Book> books;
    }

    @Entity
    public class Book {
        @Id
        private Long id;

        @ManyToOne
        @JoinColumn(name = "library_id")
        private Library library;
    }

    @Entity
    public class Doctor {
        @Id
        private Long id;

        @OneToMany(mappedBy = "doctor")
        private List<Patient> patients;
    }

    @Entity
    public class Patient {
        @Id
        private Long id;

        @ManyToOne
        @JoinColumn(name = "doctor_id")
        private Doctor doctor;
    }

    @Entity
    public class Product {
        @Id
        private Long id;

        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;
    }

    @Entity
    public class Category {
        @Id
        private Long id;

        @OneToMany(mappedBy = "category")
        private List<Product> products;
    }

    @Entity
    public class Project {
        @Id
        private Long id;

        @ManyToMany
        @JoinColumn(name = "employee_id")
        private List<Employee> employees;
    }

    @Entity
    public class Employee {
        @Id
        private Long id;

        @ManyToMany(mappedBy = "employees")
        private List<Project> projects;
    }

    @Entity
    public class Invoice {
        @Id
        private Long id;

        @OneToOne
        @JoinColumn(name = "payment_id")
        private Payment payment;
    }

    @Entity
    public class Payment {
        @Id
        private Long id;
        private Double amount;
    }

    @Entity
    public class Flight {
        @Id
        private Long id;

        @OneToMany(mappedBy = "flight")
        private List<Ticket> tickets;
    }

    @Entity
    public class Ticket {
        @Id
        private Long id;

        @ManyToOne
        @JoinColumn(name = "flight_id")
        private Flight flight;
    }
    @Entity
    public class Movie {
        @Id
        private Long id;

        @ManyToMany
        @JoinColumn(name = "actor_id")
        private List<Actor> actors;
    }

    @Entity
    public class Actor {
        @Id
        private Long id;

        @ManyToMany(mappedBy = "actors")
        private List<Movie> movies;
    }

    @Entity
    public class Parent {
        @Id
        private Long id;

        @OneToMany(mappedBy = "parent")
        private List<Child> children;
    }

    @Entity
    public class Child {
        @Id
        private Long id;

        @ManyToOne
        @JoinColumn(name = "parent_id")
        private Parent parent;
    }

    @Entity
    public class School {
        @Id
        private Long id;

        @OneToMany(mappedBy = "school")
        private List<Classroom> classrooms;
    }

    @Entity
    public class Classroom {
        @Id
        private Long id;

        @ManyToOne
        @JoinColumn(name = "school_id")
        private School school;
    }

    @Entity
    public class Driver {
        @Id
        private Long id;

        @OneToOne
        @JoinColumn(name = "car_id")
        private Car car;
    }

    @Entity
    public class Car {
        @Id
        private Long id;
        private String model;
    }

    @Entity
    public class Hotel {
        @Id
        private Long id;

        @OneToMany(mappedBy = "hotel")
        private List<Room> rooms;
    }

    @Entity
    public class Room {
        @Id
        private Long id;

        @ManyToOne
        @JoinColumn(name = "hotel_id")
        private Hotel hotel;
    }

    @Entity
    public class Account {
        @Id
        private Long id;

        @OneToMany(mappedBy = "account")
        private List<Transaction> transactions;
    }

    @Entity
    public class Transaction {
        @Id
        private Long id;

        @ManyToOne
        @JoinColumn(name = "account_id")
        private Account account;
    }


    @Entity
    public class Country {
        @Id
        private Long id;

        @OneToMany(mappedBy = "country")
        private List<City> cities;
    }

    @Entity
    public class City {
        @Id
        private Long id;

        @ManyToOne
        @JoinColumn(name = "country_id")
        private Country country;
    }

}
