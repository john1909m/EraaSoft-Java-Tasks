package com.item.service.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.item.service.userService;
import com.servlet.controller.ItemController;
import com.servlet.model.User;

public class userServiceImpl implements userService {
	private DataSource dataSource;
	
	public userServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public User login(User user) {
		Connection connection=null;
		Statement statement=null;
		try {
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			String sql="SELECT * fROM USERS WHERE EMAIL='"
			+user.getEmail()+"' AND PASSWORD='"
			+user.getPassword()+"'";
			ResultSet resultSet=statement.executeQuery(sql);
			if(resultSet.next()) {
				return user;
			}
			
		}catch (Exception e) {
			System.out.println("--------> " + e.getMessage());
		}finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
			}catch(Exception e) {
				System.out.println("--------> " + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public boolean register(User user) {
		Connection connection=null;
		Statement statement=null;
		try {
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			String sql="INSERT INTO USERS (first_name,last_name,phone_number,email,password) VALUES ('"
					+ user.getFirstName()+"', '"
					+ user.getLastName()+"', '"
					+ user.getPhoneNumber()+"', '"
					+ user.getEmail()+"', '"
					+ user.getPassword()+"')";
			statement.execute(sql);
			System.out.println(sql);
			return true;
		}  catch (Exception e) {
			System.out.println("--------> " + e.getMessage());
		}finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
			}catch(Exception e) {
				System.out.println("--------> " + e.getMessage());
			}
		}
		return false;
	}

}
