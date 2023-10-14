package com.questionpro.GroceryBooking.service;

import java.util.List;

import com.questionpro.GroceryBooking.entities.TbGrocery;
import com.questionpro.GroceryBooking.models.UserCart;

public interface GroceryBookingService {

	List<TbGrocery> getAllItems() throws Exception;

	TbGrocery getItem(Integer id) throws Exception;

	TbGrocery addItem(TbGrocery tbGrocery) throws Exception;

	List<TbGrocery> addItems(List<TbGrocery> tbGroceryList)throws Exception;

	String deleteItem(Integer id) throws Exception;

	String [] deleteItems(Integer[] ids) throws Exception;

	TbGrocery updateItem(TbGrocery tbGrocery)  throws Exception;

	UserCart bookItems(List<UserCart> userCartList) throws Exception;

	
}