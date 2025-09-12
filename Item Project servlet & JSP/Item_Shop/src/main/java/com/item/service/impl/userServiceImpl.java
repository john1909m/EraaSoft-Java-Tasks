package com.item.service.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
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
			String sql="SELECT * fROM USERS WHERE EMAIL=? AND PASSWORD=?";
			
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ResultSet resultSet=ps.executeQuery();
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
			String sql="INSERT INTO USERS (first_name,last_name,phone_number,email,password) VALUES (?,?,?,?,?)";

			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getPhoneNumber());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			return ps.executeUpdate()>0;
//			String sql="INSERT INTO USERS (first_name,last_name,phone_number,email,password) VALUES ('"
//					+ user.getFirstName()+"', '"
//					+ user.getLastName()+"', '"
//					+ user.getPhoneNumber()+"', '"
//					+ user.getEmail()+"', '"
//					+ user.getPassword()+"')";
//			statement.execute(sql);
//			System.out.println(sql);
//			return true;
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
