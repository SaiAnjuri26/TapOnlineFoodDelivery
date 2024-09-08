package com.samfoods.Dao;

import java.util.ArrayList
;

import com.samfoods.model.Ordertable;


public interface OrderDao 
{
	int addOrder(Ordertable o);
	ArrayList<Ordertable> getAllOrders();
	Ordertable getSpecificRestuarant(int restaurantId);
}
