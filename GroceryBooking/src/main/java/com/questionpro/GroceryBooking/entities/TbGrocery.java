package com.questionpro.GroceryBooking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_grocery")
public class TbGrocery {

	@Id
	@Column(name = "ITEM_ID")
	private int itemId;

	@Column(name = "ITEM_QTY")
	private int itemQty;

	@Column(name = "ITEM_NAME")
	private String itemName;

	public TbGrocery() {
		super();
	}

	public TbGrocery(int itemId, int itemQty, String itemName, int itemPrice) {
		super();
		this.itemId = itemId;
		this.itemQty = itemQty;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	@Column(name = "ITEM_PRICE")
	private int itemPrice;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

}
