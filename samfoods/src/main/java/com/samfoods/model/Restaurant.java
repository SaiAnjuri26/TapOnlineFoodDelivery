package com.samfoods.model;

public class Restaurant {
	

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	private int restaurantId;
	private String restaurantName;
	private String deliveryTime;
	private String cuisineType;
	private String address;
	private float rating;
	private  String isActive;
	private int adminId;
	private String imagePath;
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int restaurantId, String restaurantName, String deliveryTime, String cuisineType, String address,
			float rating, String isActive,int adminId) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.cuisineType = cuisineType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
		this. adminId= adminId;
	}
	public Restaurant( String restaurantName, String deliveryTime, String cuisineType, String address,
			float rating, String isActive,int adminId) {
		super();
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.cuisineType = cuisineType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
		this. adminId = adminId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getisActive() {
		return isActive;
	}

	public void setActive(String isActive) {
		this.isActive = isActive;
	}

	public String getImagePath() {
		return imagePath;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	
	
}
