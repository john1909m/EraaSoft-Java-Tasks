package com.spring.core;

public class AccountServiceImpl implements UserService {
//    private UserService userService;
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
    @Override
    public void save (String name) {
        userService.save(name);
    }
}
