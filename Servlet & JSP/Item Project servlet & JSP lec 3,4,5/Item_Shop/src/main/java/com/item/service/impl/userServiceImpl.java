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

	@Override
	public boolean hasAccount(User user) {
		System.out.println("------------enter service");
		Connection connection=null;
		String sql ="SELECT * FROM USERS WHERE first_name=? and last_name=? and email=?";
		
		try {
			connection=dataSource.getConnection();
			System.out.println(connection);

			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			System.out.println("SQL: SELECT * FROM USERS WHERE first_name='" 
					   + user.getFirstName() + "' AND last_name='" 
					   + user.getLastName() + "' AND email='" 
					   + user.getEmail() + "'");
			ResultSet resultSet=ps.executeQuery();
			boolean found = resultSet.next();
			System.out.println("Found user? " + found);
			return found;


		} catch (Exception e) {
			System.out.println("--------> " + e.getMessage());
		}finally {
			try {
				if(connection != null) connection.close();
			}catch(Exception e) {
				System.out.println("--------> " + e.getMessage());
			}
		}
		return false;
	}

	@Override
	public boolean deleteAccount(User user) {
		Connection connection=null;
		String sql ="DELETE USERS WHERE email=?";
		try {
			connection=dataSource.getConnection();
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			System.out.println("--------> " + e.getMessage());
		}finally {
			try {
				if(connection != null) connection.close();
			}catch(Exception e) {
				System.out.println("--------> " + e.getMessage());
			}
		}
			
		return false;
	}

}
