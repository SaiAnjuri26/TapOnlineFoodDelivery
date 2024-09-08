package com.samfoods.model;



public class Menu {
	
	private int menuId;
	private int restaurantId;
	private String menuName;
	private float price;
	private String description;
	private String isAvaliable;
	private String imagePath;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(int menuId, int restuarantId, String menuName, float price, String description, String isAvaliable,
			String imagePath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restuarantId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.isAvaliable = isAvaliable;
		this.imagePath = imagePath;
	}
	public Menu( int  restaurantId, String menuName, float price, String description, String isAvaliable,
			String imagePath) {
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.isAvaliable = isAvaliable;
		this.imagePath = imagePath;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestuarantId(int  restaurantId) {
		this.restaurantId =  restaurantId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getisAvaliable() {
		return isAvaliable;
	}
	public void setAvaliable(String isAvaliable) {
		this.isAvaliable = isAvaliable;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", menuName=" + menuName + ", price="
				+ price + ", description=" + description + ", isAvaliable=" + isAvaliable + ", imagePath=" + imagePath
				+ "]";
	}
	

}

