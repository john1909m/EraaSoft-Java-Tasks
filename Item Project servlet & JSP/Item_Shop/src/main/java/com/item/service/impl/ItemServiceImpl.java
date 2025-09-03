package com.item.service.impl;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.item.service.ItemService;
import com.servlet.model.Item;

public class ItemServiceImpl implements ItemService{

	private DataSource dataSource;
	public ItemServiceImpl(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	@Override
	public boolean addItem(Item item) {
		Connection connection=null;
		Statement statement=null;
		try {
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			String sql="INSERT INTO ITEM (name,price,total_number) VALUES ('"
			        +item.getName()+"', "
			        +item.getPrice()+", "
			        +item.getTotalNumber()+")";
			statement.execute(sql);
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

	@Override
	public boolean removeItem(Long id) {
		Connection connection=null;
		Statement statement=null;
		try {
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			String sql="Delete FROM ITEM WHERE id= "+id;
			statement.execute(sql);
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

	@Override
	public boolean editItem(Item item) {
		Connection connection=null;
		Statement statement=null;
		try {
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			String sql="UPDATE ITEM SET NAME='"+item.getName()+"', "
					+"PRICE="+item.getPrice()+","
					+"TOTAL_NUMBER="+item.getTotalNumber()
					+" WHERE id= "+item.getId();
			statement.execute(sql);
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

	@Override
	public Item getItem(Long id) {
		Connection connection=null;
		Statement statement=null;
		try {
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			String sql="SELECT * FROM ITEM WHERE id="+id;
			ResultSet resultSet=statement.executeQuery(sql);
			Item item=new Item();
			if(resultSet.next()) {
				item.setId(resultSet.getLong("id"));
				item.setName(resultSet.getString("name"));
				item.setPrice(resultSet.getDouble("price"));
				item.setTotalNumber(resultSet.getInt("total_number"));
			}
			return item;
		} catch (Exception e) {
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
	public List<Item> getItems() {
		Connection connection = null;
		Statement statement= null;
		try {
			connection=dataSource.getConnection();
			statement=connection.createStatement();
			String sql="SELECT * FROM ITEM ORDER BY id";
			ResultSet resultSet=statement.executeQuery(sql);
			List<Item> items=new ArrayList<>();
			
			
			while(resultSet.next()) {
				Item item=new Item();
				item.setId(resultSet.getLong("id"));
				item.setName(resultSet.getString("name"));
				item.setPrice(resultSet.getDouble("price"));
				item.setTotalNumber(resultSet.getInt("total_number"));
				items.add(item);
			}
			return items;
		} catch (Exception e) {
			System.out.println("--------> " + e.getMessage());
		}finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
			}catch(Exception e) {
				System.out.println("--------> " + e.getMessage());
			}
		}
		return new ArrayList<>();
	}

	
}
