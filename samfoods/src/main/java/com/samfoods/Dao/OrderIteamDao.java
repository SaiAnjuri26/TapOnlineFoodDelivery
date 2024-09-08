package com.samfoods.Dao;

import java.util.ArrayList;


import com.samfoods.model.orderiteam;


public interface OrderIteamDao {
	int addOderIteam(orderiteam ot);
	ArrayList<orderiteam> getAllOderIteams();
	orderiteam getSpecificOrderIteam(int orderId);
}
