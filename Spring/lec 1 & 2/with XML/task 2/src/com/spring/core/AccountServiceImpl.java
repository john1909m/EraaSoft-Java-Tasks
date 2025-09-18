package com.spring.core;

public class AccountServiceImpl implements AccounService {
    private UserService userService;
    public AccountServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void getSavedPerson(String name) {
        userService.save(name);
    }



}
