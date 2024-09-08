package com.samfoods.DaoImpl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.samfoods.Dao.RestaurantDao;
import com.samfoods.DbUtills.DButills;
import com.samfoods.model.Restaurant;
public class RestaurantDaoImpl  implements RestaurantDao 
{
	Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;
    
    ArrayList<Restaurant> restaurantList = new ArrayList<>();
    Restaurant restaurant;

    private static final String ADD_RESTAURANT = "INSERT INTO `restauranttable`(`restaurantName`, `deliveryTime`, `cuisineType`, `address`, `rating`, `isActive`, `adminId`, `imagePath`) "
                                                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_RESTAURANTS = "SELECT * FROM `restauranttable`";
    private static final String SELECT_RESTAURANT_BY_ID = "SELECT * FROM `restauranttable` WHERE `restaurantId`=?";
    private static final String UPDATE_RESTAURANT_BY_ID = "UPDATE `restauranttable` SET `restaurantName`=?, `deliveryTime`=?, `cuisineType`=?, `address`=?, `rating`=?, `isActive`=?, `imagePath`=? WHERE `restaurantId`=?";
    private static final String DELETE_RESTAURANT_BY_ID = "DELETE FROM `restauranttable` WHERE `restaurantId`=?";

    int status = 0;
	private int restaurantId;

    public RestaurantDaoImpl() {
        try {
            con = DButills.myConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public int addResturant(Restaurant r) {
		try {
            pstmt = con.prepareStatement(ADD_RESTAURANT);
            pstmt.setString(1, r.getRestaurantName());
            pstmt.setString(2, r.getDeliveryTime());
            pstmt.setString(3, r.getCuisineType());
            pstmt.setString(4, r.getAddress());
            pstmt.setFloat(5, r.getRating());
            pstmt.setString(6, r.getisActive());
            pstmt.setInt(7, r.getAdminId()); // You need to include adminId in your model
            pstmt.setString(8, r.getImagePath());
            
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

	

	@Override
	public  ArrayList<Restaurant> getAllResturant() {
		 try {
	            stmt = con.createStatement();
	            resultSet = stmt.executeQuery(SELECT_ALL_RESTAURANTS);
	            restaurantList = extractRestaurantFromResultSet(resultSet);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return restaurantList;
	}

	

	@Override
	public  Restaurant getSpecificResturant(int resturantId) {
		try {
            pstmt = con.prepareStatement(SELECT_RESTAURANT_BY_ID);
			pstmt.setInt(1, restaurantId);
            resultSet = pstmt.executeQuery();
            restaurantList = extractRestaurantFromResultSet(resultSet);
            if (!restaurantList.isEmpty()) {
                restaurant = restaurantList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurant;
	}

	@Override
	public int updateResturant(Restaurant r) {
		try {
            pstmt = con.prepareStatement(UPDATE_RESTAURANT_BY_ID);
            pstmt.setString(1, r.getRestaurantName());
            pstmt.setString(2, r.getDeliveryTime());
            pstmt.setString(3, r.getCuisineType());
            pstmt.setString(4, r.getAddress());
            pstmt.setFloat(5, r.getRating());
            pstmt.setString(6, r.getisActive());
            pstmt.setString(7, r.getImagePath());
            pstmt.setInt(8, r.getRestaurantId());
            
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
	}

	@Override
	public int deleteResturant(int resturantId) {
		 try {
	            pstmt = con.prepareStatement(DELETE_RESTAURANT_BY_ID);
	            pstmt.setInt(1, restaurantId);
	            
	            status = pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return status;
	}
	
	private ArrayList<Restaurant> extractRestaurantFromResultSet(ResultSet resultSet) {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Restaurant r = new Restaurant(
                    resultSet.getInt("restaurantId"),
                    resultSet.getString("restaurantName"),
                    resultSet.getString("deliveryTime"),
                    resultSet.getString("cuisineType"),
                    resultSet.getString("address"),
                    resultSet.getFloat("rating"),
                    resultSet.getString("isActive"), restaurantId
                );
                r.setImagePath(resultSet.getString("imagePath"));
                restaurants.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurants;
    }

}
