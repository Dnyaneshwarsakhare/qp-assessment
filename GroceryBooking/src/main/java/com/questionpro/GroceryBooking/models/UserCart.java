package com.questionpro.GroceryBooking.models;

public class UserCart {

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQty() {
		return qty;
	}
	public UserCart() {
		super();
	}
	public UserCart(int itemId, int qty, int totalItemsInCart, int totalItemsCartPrice) {
		super();
		this.itemId = itemId;
		this.qty = qty;
		this.totalItemsInCart = totalItemsInCart;
		this.totalItemsCartPrice = totalItemsCartPrice;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	int itemId;
	int qty;
	public int getTotalItemsInCart() {
		return totalItemsInCart;
	}
	public void setTotalItemsInCart(int totalItemsInCart) {
		this.totalItemsInCart = totalItemsInCart;
	}
	public int getTotalItemsCartPrice() {
		return totalItemsCartPrice;
	}
	public void setTotalItemsCartPrice(int totalItemsCartPrice) {
		this.totalItemsCartPrice = totalItemsCartPrice;
	}
	int totalItemsInCart;
	int totalItemsCartPrice;
}
