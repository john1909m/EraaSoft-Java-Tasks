package com.java.model;

import javax.persistence.*;
import java.util.List;

public class Course_Student {
    @Entity
    class Course {
        @Id
        private Long id;

        @ManyToMany
        @JoinColumn(name = "student_id")
        private List<Student> students;
    }

    @Entity
    class Student {
        @Id
        private Long id;

        @ManyToMany(mappedBy = "students")
        private List<Course> courses;
    }

}
