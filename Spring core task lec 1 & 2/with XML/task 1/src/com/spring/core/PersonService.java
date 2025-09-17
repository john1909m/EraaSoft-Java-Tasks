package com.spring.core;

public class PersonService implements UserService {

    @Override
    public void save(String name) {
        System.out.println("save person "+name);
    }

    @Override
    public void update(String name) {
        System.out.println("update person "+name);

    }
}
