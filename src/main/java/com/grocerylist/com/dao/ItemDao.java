package com.grocerylist.com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grocerylist.com.dao.DaoContract;
import com.grocerylist.com.model.GroceryList;
import com.grocerylist.com.model.Item;


@Repository
@Transactional
public class ItemDao implements DaoContract<Item, Integer> {

	private SessionFactory sesfact;

	@Autowired
	public ItemDao(SessionFactory sse) {
		sesfact = sse;
	}

	@Override
	public List<Item> findAll() {
		return sesfact.openSession().createQuery("from Item", Item.class).list();
	}

	@Override
	public Item findById(Integer id) {
		return sesfact.openSession().get(Item.class, id);
	}

	@Override
	public void save(Item t) {
		sesfact.openSession().save(t);

	}

	@Override
	public void update(Item t) {
		sesfact.getCurrentSession().update(t);
	}

	@Override
	public void deleteById(Integer id) {
		Item i = sesfact.getCurrentSession().get(Item.class, id);
		sesfact.getCurrentSession().delete(i);		
	}

	@Override
	public void delete(Item t) {
		sesfact.getCurrentSession().delete(t);
	}


}
