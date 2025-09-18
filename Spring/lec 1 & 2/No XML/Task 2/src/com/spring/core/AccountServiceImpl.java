package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccounService {
    private UserService userService;
    @Autowired
    public AccountServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void getSavedPerson(String name) {
        userService.save(name);
    }



}
