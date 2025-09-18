package com.spring.core;

public class PersonService implements UserService {
    @Override
    public void save (String name) {
        System.out.println(name);
    }

}
