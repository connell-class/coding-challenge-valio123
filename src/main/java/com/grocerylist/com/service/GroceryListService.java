package com.grocerylist.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerylist.com.dao.DaoContract;
import com.grocerylist.com.model.GroceryList;

@Service
public class GroceryListService {

	private DaoContract<GroceryList, Integer> grlist;
	
	@Autowired
	public void setGroceryList(DaoContract<GroceryList, Integer> gl) {
		grlist=gl;
	}
	
	public List<GroceryList> getAll(){
		return grlist.findAll();
	}
	
	public GroceryList save(GroceryList g) {
		grlist.save(g);
		return g;
	}
	
	public GroceryList update(GroceryList g) {
		grlist.update(g);
		return g;
	}
	
	public void delete(GroceryList g) {
		grlist.delete(g);
	}
	
	public void deleteById(int id) {
		grlist.deleteById(id);
	}
	
	public GroceryList findById(int id) {
		return grlist.findById(id);
	}
}