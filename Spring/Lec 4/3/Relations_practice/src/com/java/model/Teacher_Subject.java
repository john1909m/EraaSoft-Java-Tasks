package com.java.model;

import javax.persistence.*;
import java.util.List;

public class Teacher_Subject {
    @Entity
    class Teacher {
        @Id
        private Long id;

        @ManyToMany
        private List<Subject> subjects;
    }

    @Entity
    class Subject {
        @Id
        private Long id;

        @ManyToMany(mappedBy = "subjects")
        private List<Teacher> teachers;
    }

}
