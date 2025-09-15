package com.servlet.model;

import java.sql.Date;

public class Item {
	private long id;
	private String name;
	private double price;
	private int totalNumber;
	private String desc;
	private String brand;
	private Date expirationDate;
	private boolean hasDetails;
	
	
	public Item(Long id) {
		
	}
	public Item() {
		
	}
	public Item(String name, double price, int totalNumber) {
		this.name = name;
		this.price = price;
		this.totalNumber = totalNumber;
	}
	
	
	public Item(long id, String name, double price, int totalNumber) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.totalNumber = totalNumber;
	}
	public Item(long id, String desc,String brand,Date expirationDate) {
		this.id = id;
		this.desc=desc;
		this.brand=brand;
		this.expirationDate=expirationDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public boolean isHasDetails() {
		return hasDetails;
	}
	public void setHasDetails(boolean hasDetails) {
		this.hasDetails = hasDetails;
	}

	
	
}
