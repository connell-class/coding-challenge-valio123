package com.grocerylist.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grocerylist.com.model.GroceryList;
import com.grocerylist.com.service.GroceryListService;


@Controller
@CrossOrigin(origins = "http://localhost:9013")
public class GroceryListController {


		@Autowired
		private GroceryListService gl;
		
		
		/** 
		 * Gets GroceryList by id
		 * @param listId
		 * @return GroceryList object
		 */	
		@RequestMapping(method = RequestMethod.GET, value = "/grocery-lists/{listId}")
		public ResponseEntity<GroceryList> getById(@PathVariable("listId") int id){
			return new ResponseEntity<GroceryList>(gl.findById(id),HttpStatus.OK);
		}


	//	get all Grocery Lists
		@RequestMapping(method = RequestMethod.GET, value = "/grocery-lists")
		public ResponseEntity<List<GroceryList>> findAll() {
			return new ResponseEntity<List<GroceryList>>(gl.getAll(), HttpStatus.OK);
		}
		
	// Save new Grocery List
		@RequestMapping(method = RequestMethod.POST, value = "/grocery-lists")
		public ResponseEntity<GroceryList> save(@RequestBody GroceryList g) {
			return new ResponseEntity<GroceryList>(gl.save(g), HttpStatus.OK);
		}

		/**
		 * Deletes List by id 
		 * @param listId
		 */
		@RequestMapping(method = RequestMethod.DELETE, value = "/grocery-lists/{listId}")
		public ResponseEntity<String> delete(@PathVariable("listId") int id){
			gl.deleteById(id);
			return new ResponseEntity<String>("list, now deleted",HttpStatus.OK);
		}
		
	
		/**
		 * Deletes List by list
		 * @param listId
		 */
		@RequestMapping(method = RequestMethod.DELETE, value = "/grocery-lists")
		public ResponseEntity<String> delete(@RequestBody GroceryList glist){
			gl.delete(glist);
			return new ResponseEntity<String>("list, now deleted",HttpStatus.OK);
		}

}
