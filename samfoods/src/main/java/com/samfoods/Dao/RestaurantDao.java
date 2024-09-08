package com.samfoods.Dao;

import java.util.ArrayList;




import com.samfoods.model.Restaurant;

public interface RestaurantDao {
	
	int addResturant(Restaurant r);
	 ArrayList<Restaurant> getAllResturant();
	 Restaurant getSpecificResturant(int resturantId);
	int updateResturant(Restaurant r);
	int deleteResturant(int resturantId);
	
}
 