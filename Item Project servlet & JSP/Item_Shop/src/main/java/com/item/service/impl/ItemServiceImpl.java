package com.item.service.impl;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
			String sql ="INSERT INTO ITEM (name,price,total_number) VALUES (?,?,?)";
			try {
				PreparedStatement ps=connection.prepareStatement(sql);
				ps.setString(1, item.getName());
				ps.setDouble(2, item.getPrice());
				ps.setInt(3, item.getTotalNumber());
				return ps.executeUpdate() >0;
			} catch (Exception e) {
				// TODO: handle exception
			}
//			statement=connection.createStatement();
//			String sql="INSERT INTO ITEM (name,price,total_number) VALUES ('"
//			        +item.getName()+"', "
//			        +item.getPrice()+", "
//			        +item.getTotalNumber()+")";
//			statement.execute(sql);
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
	public boolean removeItem(Long id) {
		Connection connection=null;
		Statement statement=null;
		try {
			connection=dataSource.getConnection();
			
			String sql="Delete FROM ITEM WHERE id= ?";
			try {
				PreparedStatement ps=connection.prepareStatement(sql);
				ps.setLong(1, id);
				return ps.executeUpdate()>0;
			} catch (Exception e) {
				// TODO: handle exception
			}

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

			String sql="UPDATE ITEM SET NAME=?, PRICE=?,TOTAL_NUMBER=? where ID=? ";
			try {
				PreparedStatement ps=connection.prepareStatement(sql);
				ps.setString(1, item.getName());
				ps.setDouble(2, item.getPrice());
				ps.setInt(3, item.getTotalNumber());
				ps.setLong(4, item.getId());

				return ps.executeUpdate()>0;
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	
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
		ResultSet resultSet=null;
		try {
			connection=dataSource.getConnection();
			String sql="SELECT * FROM ITEM WHERE id=?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setLong(1, id);
			resultSet=ps.executeQuery();
			Item item=new Item();
			if(resultSet.next()) {
				item.setId(resultSet.getLong("id"));
				item.setName(resultSet.getString("name"));
				item.setPrice(resultSet.getDouble("price"));
				item.setTotalNumber(resultSet.getInt("total_number"));
				return item;
			}else {
				return null;
			}
			
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
	@Override
	public boolean saveDetails(Item item) {
	    Connection connection = null;
	    PreparedStatement ps = null;
	    try {
	        connection = dataSource.getConnection();
	        String sql = "INSERT INTO ITEM_DETAILS (item_id, details) VALUES (?, ?)";
	        ps = connection.prepareStatement(sql);
	        ps.setLong(1, item.getId());
	        ps.setString(2, item.getDetails());

	        return ps.executeUpdate()>0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (connection != null) connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}
	@Override
	public boolean removeDetails(Long id) {
		Connection connection=null;
		try {
			String sql="DELETE FROM ITEM_DETAILS WHERE ITEM_ID=?";
			try {
				connection=dataSource.getConnection();
				PreparedStatement ps=connection.prepareStatement(sql);
				ps.setLong(1, id);
				return ps.executeUpdate()>0;
			} catch (Exception e) {
				// TODO: handle exception
			}
			
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
	public boolean editDetails(Item item) {
		Connection connection=null;
		try {
			String sql="UPDATE ITEM_DETAILS SET details=? WHERE ITEM_ID=?";
			try {
				connection=dataSource.getConnection();
				PreparedStatement ps=connection.prepareStatement(sql);
				ps.setString(1, item.getDetails());
				ps.setLong(2, item.getId());
				
				return ps.executeUpdate()>0;
			} catch (Exception e) {
				// TODO: handle exception
			}
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
	public String showDetails(Long id) {
		Connection connection=null;
		String details="";
		try {
			String sql="SELECT details FROM ITEM_DETAILS WHERE ITEM_ID=?";
			try {
				connection=dataSource.getConnection();
				PreparedStatement ps=connection.prepareStatement(sql);
				ps.setLong(1, id);
				ResultSet resultSet=ps.executeQuery();
				if(resultSet.next()) {
					details=resultSet.getString("details");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			System.out.println("--------> " + e.getMessage());
		}finally {
			try {
				if(connection != null) connection.close();
				
			}catch(Exception e) {
				System.out.println("--------> " + e.getMessage());
			}
		}
		
		
		return details;
	}

	
}
