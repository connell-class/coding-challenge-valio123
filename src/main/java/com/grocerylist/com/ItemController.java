package com.grocerylist.com;

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
import com.grocerylist.com.model.Item;
import com.grocerylist.com.service.GroceryListService;
import com.grocerylist.com.service.ItemService;

@Controller
@CrossOrigin(origins = "http://localhost:9013")
public class ItemController {


		@Autowired
		private ItemService is;

		// Save item
	
		@RequestMapping(method = RequestMethod.POST, value = "/grocery-lists/items")
		public ResponseEntity<Item> save(@RequestBody Item i) {
			return new ResponseEntity<Item>(is.save(i), HttpStatus.OK);
		}
		
		// Update item by id
		
		@RequestMapping(method = RequestMethod.POST, value="/grocery-lists/items/update/{itemId}")
		public ResponseEntity<Item> update(@RequestBody Item i) {
			return new ResponseEntity<Item>(is.update(i), HttpStatus.OK);
		}	
		
		/**
		 * Deletes Item by id 
		 * @param itemId
		 */
		@RequestMapping(method = RequestMethod.DELETE, value = "/grocery-lists/items/{itemId}")
		public ResponseEntity<String> delete(@PathVariable("itemId") int id){
			is.deleteById(id);
			return new ResponseEntity<String>("record, now deleted",HttpStatus.OK);
		}


}
