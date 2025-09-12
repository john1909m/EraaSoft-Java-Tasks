package com.item.service;

import java.util.List;

import com.servlet.model.Item;

public interface ItemService {
	boolean addItem(Item item);
	boolean removeItem(Long id);
	boolean editItem(Item item);
	Item getItem(Long id);
	List<Item> getItems();
	boolean saveDetails(Item item);
	boolean editDetails(Item item);
	String showDetails(Long id);
	boolean removeDetails(Long id);	
	
}
