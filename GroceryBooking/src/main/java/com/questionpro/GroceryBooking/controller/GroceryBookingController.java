package com.questionpro.GroceryBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.GroceryBooking.entities.TbGrocery;
import com.questionpro.GroceryBooking.models.UserCart;
import com.questionpro.GroceryBooking.service.GroceryBookingService;

@RestController
public class GroceryBookingController {
	
	@Autowired
	private GroceryBookingService groceryBookingService;

	//,consumes="application/json", produces="application/json"
	@GetMapping("/getAllItems")
	@ResponseBody
	public List <TbGrocery> getAllItems() throws Exception{
		return groceryBookingService.getAllItems();
	}
	
	@GetMapping("/{role}/getItem/{id}")
	public TbGrocery getOneItem(@PathVariable(name = "role") String role, @PathVariable(name = "id") Integer id) throws Exception{
		TbGrocery item = null;
		if(role.equalsIgnoreCase("ADMIN")) {
			 item = groceryBookingService.getItem(id);
		}
		return item ;
	} 
	
	@PostMapping("/{role}/addItem")
	public TbGrocery addItem(@PathVariable(name = "role") String role,@RequestBody TbGrocery tbGrocery) throws Exception{
		TbGrocery item = null;
		if(role.equalsIgnoreCase("ADMIN")) {
			item = groceryBookingService.addItem(tbGrocery);
		}
		return item ;
	}
	
	@PostMapping("/{role}/addItems")
	public List<TbGrocery> addItems(@PathVariable(name = "role") String role,@RequestBody List<TbGrocery> tbGroceryList) throws Exception{
		List<TbGrocery> tbGroceries = null;
		if(role.equalsIgnoreCase("ADMIN")) {
			tbGroceries  = groceryBookingService.addItems(tbGroceryList);
		}
		return tbGroceries ;
	}
	
	@DeleteMapping("/{role}/deleteItem/{id}")
	public String deleteItem(@PathVariable(name = "role") String role,@PathVariable(name = "id") Integer id) throws Exception{
		if(role.equalsIgnoreCase("ADMIN")) {
			return groceryBookingService.deleteItem(id);
		}
		return "NOT AUTHORIZED TO DELETE THE ITEM";
	}
	
	@DeleteMapping("/{role}/deleteItems/{ids}")
	public String []  deleteItems(@PathVariable(name = "role") String role,@PathVariable(name = "ids") Integer [] ids) throws Exception{
		if(role.equalsIgnoreCase("ADMIN")) {
			return groceryBookingService.deleteItems(ids);
		}
		return new String []{"NOT AUTHORIZED TO DELETE THE ITEM"};
	}
	
	@PutMapping("/{role}/updateItem")
	public TbGrocery updateItem(@PathVariable(name = "role") String role,@RequestBody TbGrocery tbGrocery) throws Exception{
		TbGrocery item = null;
		if(role.equalsIgnoreCase("ADMIN")) {
			item = groceryBookingService.updateItem(tbGrocery);
		}
		return item ;
	}
	
	@PostMapping("/{role}/bookItems")
	public UserCart bookItems(@PathVariable(name = "role") String role,@RequestBody List<UserCart> userCartList) throws Exception{
		UserCart userCart = null;
		if(role.equalsIgnoreCase("USER")) {
			return groceryBookingService.bookItems(userCartList);
		}
		return userCart;
	}
	
}
