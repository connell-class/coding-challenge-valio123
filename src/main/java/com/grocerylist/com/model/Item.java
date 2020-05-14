package com.grocerylist.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.grocerylist.com.model.GroceryList;

@Entity
@Table(name="items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column(unique = true)
	@NotNull
	private String name;
	
	@Column
	@NotNull
	private String type;

	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GroceryList grocerylist;

	public Item(int id, @NotNull String name, @NotNull String type, GroceryList grocerylist) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.grocerylist = grocerylist;
	}

	public Item(int id) {
		super();
		this.id = id;
	}
	
	public Item() {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public GroceryList getGrocerylist() {
		return grocerylist;
	}

	public void setGrocerylist(GroceryList grocerylist) {
		this.grocerylist = grocerylist;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", type=" + type + ", grocerylist=" + grocerylist + "]";
	}

	


}