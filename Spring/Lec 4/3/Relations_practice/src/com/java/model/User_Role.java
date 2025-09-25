package com.java.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.List;

public class User_Role {
    @Entity
    class User {
        @Id
        private Long id;

        @ManyToMany
        @JoinColumn(name = "role_id")
        private List<Role> roles;
    }

    @Entity
    class Role {
        @Id
        private Long id;

        @ManyToMany(mappedBy = "roles")
        private List<User> users;
    }

}
