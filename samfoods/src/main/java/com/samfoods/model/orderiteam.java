package com.samfoods.model;

public class orderiteam {
	
	
	private int orderIteamId;
	private int orderId;
	private int menuId;
	private int quantity;
	private float subTotal;
	public orderiteam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderiteam(int orderIteamId, int orderId, int menuId, int quantity, float subTotal) {
		super();
		this.orderIteamId = orderIteamId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}
	public orderiteam(int orderId, int menuId, int quantity, float subTotal) {
		super();
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}
	public int getOrderIteamId() {
		return orderIteamId;
	}
	public void setOrderIteamId(int orderIteamId) {
		this.orderIteamId = orderIteamId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	@Override
	public String toString() {
		return "orderiteam [orderIteamId=" + orderIteamId + ", orderId=" + orderId + ", menuId=" + menuId
				+ ", quantity=" + quantity + ", subTotal=" + subTotal + "]";
	}
	
}
