package com.item.service;

import com.servlet.model.User;

public interface userService {
	User login(User user);
	boolean register(User user);
	boolean hasAccount(User user);
	boolean deleteAccount(User user);
	
	
	
}
