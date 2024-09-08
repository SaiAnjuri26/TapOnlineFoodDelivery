package com.samfoods.Dao;

import java.util.ArrayList;


import com.samfoods.model.orderhistory;

public interface OderHistoryDao {
	int addHistory(orderhistory oh);
	ArrayList<orderhistory> getAllOderHistoryIteams(int userId);
	orderhistory getSpecificHistoryIteam(int userId);
	 
	
	ArrayList<orderhistory> getOrderHistoryByUserId(int userId);
	
}
