package com.grocerylist.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerylist.com.dao.DaoContract;
import com.grocerylist.com.model.GroceryList;
import com.grocerylist.com.model.Item;

@Service
public class ItemService {

	private DaoContract<Item, Integer> item;
	
	@Autowired
	public void setItem(DaoContract<Item, Integer> i) {
		item=i;
	}
	
	public List<Item> getAll(){
		return item.findAll();
	}
	
	public Item save(Item i) {
		item.save(i);
		return i;
	}
	
	public Item update(Item i) {
		item.update(i);
		return i;
	}
	
	public void delete(Item i) {
		item.delete(i);
	}
	
	public void deleteById(int id) {
		item.deleteById(id);
	}
	
	public Item findById(int id) {
		return item.findById(id);
	}
}