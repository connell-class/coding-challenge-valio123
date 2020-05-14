package com.grocerylist.com.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.grocerylist.com.model.Item;

@Entity
@Table(name="grocery_list")
public class GroceryList {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;


	@NotNull
	private String name;
	
	@OneToMany(mappedBy = "grocerylist", cascade = { CascadeType.ALL })
	private Set<Item> items;

	public GroceryList(int id, @NotNull String name, Set<Item> items) {
		super();
		this.id = id;
		this.name = name;
		this.items = items;
	}
	
	public GroceryList(int id) {
		super();
		this.id = id;
	}

	public GroceryList() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "GroceryList [id=" + id + ", name=" + name + ", items=" + items + "]";
	}
}