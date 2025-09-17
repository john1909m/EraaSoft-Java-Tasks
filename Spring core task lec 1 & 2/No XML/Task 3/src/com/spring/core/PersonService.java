package com.spring.core;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonService implements UserService {
    @Override
    public void save (String name) {
        System.out.println(name);
    }

    public void openConnection() {
        System.out.println("openConnection");
    }
    public void closeConnection() {
        System.out.println("closeConnection");
    }
}
