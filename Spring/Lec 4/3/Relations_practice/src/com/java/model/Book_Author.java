package com.java.model;

import javax.persistence.*;
import java.util.List;

public class Book_Author {
    @Entity
    class Book {
        @Id
        private Long id;

        @ManyToOne
        @JoinColumn(name = "author_id")
        private Author author;
    }

    @Entity
    class Author {
        @Id
        private Long id;

        @OneToMany(mappedBy = "author")
        private List<Book> books;
    }
}
