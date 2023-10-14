package com.questionpro.GroceryBooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionpro.GroceryBooking.entities.TbGrocery;
import com.questionpro.GroceryBooking.models.UserCart;
import com.questionpro.GroceryBooking.repository.GroceryBookingRepository;

@Service
public class GroceryBookingSeviceImpl implements GroceryBookingService {

	@Autowired
	GroceryBookingRepository groceryBookingRepository;
	
	@Override
	public List<TbGrocery> getAllItems() throws Exception{
		List<TbGrocery> tbGrocerylist1 = null;
		try {
			return groceryBookingRepository.findAll();
		}catch(Exception ex) {
			System.out.println("Error occurred while getting all items "+ex);
		}
		return tbGrocerylist1;
	}

	@Override
	public TbGrocery getItem(Integer id) throws Exception {
		TbGrocery tbGrocery1 = null;
		try {
			Optional<TbGrocery> tbGrocery = groceryBookingRepository.findById(id);
			return tbGrocery.get();
		}catch(Exception ex) {
			System.out.println("Error occurred while getting item "+ex);
		}
		return tbGrocery1;
	}

	@Override
	public TbGrocery addItem(TbGrocery tbGrocery) throws Exception{
		TbGrocery tbGrocery1 = null;
		try {
			return groceryBookingRepository.save(tbGrocery);
		}catch(Exception ex) {
			System.out.println("Error occurred while adding item "+ex);
		}
		return tbGrocery1;
	}

	@Override
	public List<TbGrocery> addItems(List<TbGrocery> tbGroceryList) throws Exception {
		List<TbGrocery> tbGroceryList1 = null;
		try {
			return groceryBookingRepository.saveAll(tbGroceryList);
		}catch(Exception ex) {
			System.out.println("Error occurred while adding items : "+ex);
		}
		return tbGroceryList1;
	}

	@Override
	public String deleteItem(Integer id) throws Exception{
		try {
		if (groceryBookingRepository.existsById(id)) {
			groceryBookingRepository.deleteById(id);
		}else {
			return "Grocery Item Does not exist with given id : "+id;
		}
		}catch(Exception ex) {
			System.out.println("Error occurred while deleting item with id : "+id +""+ex);
		}
		return "Grocery Item deleted with given id : "+id; 
	}
 
	@Override
	public String [] deleteItems(Integer[] ids) throws Exception {
		String [] arr = new String[ids.length];
		int i=0;
		try {
			for(Integer id : ids) {
				if (groceryBookingRepository.existsById(id)) {
					groceryBookingRepository.deleteById(id);
					arr[i] = "Grocery Item deleted successfully with given id : "+id;
				}else {
					arr[i] = "Grocery Item Does not exist with given id : "+id;
				}
				i++;
			}
		}catch(Exception ex) {
			System.out.println("Error occurred while deleting items :"+ex);
		}
		return arr; 
	}

	@Override
	public TbGrocery updateItem(TbGrocery tbGrocery) throws Exception {
		TbGrocery tbGrocery1 = null;
		if (groceryBookingRepository.existsById(tbGrocery.getItemId())) {
			return groceryBookingRepository.save(tbGrocery);
		}
		return tbGrocery1;
	}

	@Override
	public UserCart bookItems(List<UserCart> userCartList) throws Exception {
		int totalItemsPrice = 0;
		int totalItemsPresent=0;
		UserCart userCart = new UserCart();
		try {
			for(UserCart eachUserCartItem : userCartList) {
				if (groceryBookingRepository.existsById(eachUserCartItem.getItemId())) {
					Optional<TbGrocery> tbGrocery = groceryBookingRepository.findById(eachUserCartItem.getItemId());	
					TbGrocery tbGroc = tbGrocery.get();
					int itemQty = eachUserCartItem.getQty();
					if(itemQty < tbGroc.getItemQty()) {
						tbGroc.setItemQty(tbGroc.getItemQty() -  itemQty);
						totalItemsPrice += tbGroc.getItemPrice() * itemQty;
						totalItemsPresent++;
						groceryBookingRepository.save(tbGroc);
					}
				}
			}
			userCart.setTotalItemsCartPrice(totalItemsPrice);
			userCart.setTotalItemsInCart(totalItemsPresent);
		}catch(Exception ex) {
			System.out.println("Error occurred while deleting items :"+ex);
		}
		return userCart; 
	}

}
