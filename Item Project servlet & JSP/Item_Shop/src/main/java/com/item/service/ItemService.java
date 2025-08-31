package com.item.service;

import java.util.List;

import com.servlet.model.Item;

public interface ItemService {
	boolean addItem(Item item);
	boolean removeItem(Long id);
	boolean editItem(Item item);
	Item getItem(int id);
	List<Item> getItems();
	
}
