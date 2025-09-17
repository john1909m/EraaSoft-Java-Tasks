package com.spring.core;




public class MangerService implements UserService {

    @Override
    public void save(String name) {
        System.out.println("save manger "+name);

    }

    @Override
    public void update(String name) {
        System.out.println("update manger "+name);

    }
}
