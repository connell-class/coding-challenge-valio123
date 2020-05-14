package com.grocerylist.com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grocerylist.com.dao.DaoContract;
import com.grocerylist.com.model.GroceryList;


@Repository
@Transactional
public class GroceryListDao implements DaoContract<GroceryList, Integer> {

	private SessionFactory sesfact;

	@Autowired
	public GroceryListDao(SessionFactory sse) {
		sesfact = sse;
	}

	@Override
	public List<GroceryList> findAll() {
		return sesfact.openSession().createQuery("from GroceryList", GroceryList.class).list();
	}

	@Override
	public GroceryList findById(Integer id) {
		return sesfact.openSession().get(GroceryList.class, id);
	}

	@Override
	public void save(GroceryList t) {
		sesfact.openSession().save(t);

	}

	@Override
	public void update(GroceryList t) {
		sesfact.getCurrentSession().update(t);
	}

	@Override
	public void deleteById(Integer id) {		
		GroceryList gl = sesfact.getCurrentSession().get(GroceryList.class, id);
		sesfact.getCurrentSession().delete(gl);	
	}
	
	

	@Override
	public void delete(GroceryList t) {
		sesfact.getCurrentSession().delete(t);
	}


}
