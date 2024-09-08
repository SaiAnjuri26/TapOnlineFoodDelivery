package com.samfoods.DaoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.samfoods.Dao.OrderDao;
import com.samfoods.DbUtills.DButills;
import com.samfoods.model.Ordertable;
public class OrderDaoImpl implements OrderDao
{
	Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;
    
    ArrayList<Ordertable> orderList = new ArrayList<>();
    Ordertable order;

    // SQL statements
    private static final String ADD_ORDER = "INSERT INTO `ordertable`(`restaurantId`, `userId`, `orderDate`, `totalAmount`, `status`, `paymentMode`) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM `ordertable`";
    private static final String SELECT_ON_RESTAURANT_ID = "SELECT * FROM `ordertable` WHERE `restaurantId`=?";
    
    int status = 0;
	private int restaurantId;

    public OrderDaoImpl() {
    	 try {
             con = DButills.myConnect();
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

	@Override
	public int addOrder(Ordertable o) {
		try {
            pstmt = con.prepareStatement(ADD_ORDER);
            
            pstmt.setInt(1, o.getRestuarantId());
            pstmt.setInt(2, o.getUserId());
            pstmt.setString(3, o.getOderDate());
            pstmt.setDouble(4, o.getTotalAmount());
            pstmt.setString(5, o.getStatus());
            pstmt.setString(6, o.getPaymentMode());
            
            status = pstmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
	}

	@Override
	public ArrayList<Ordertable> getAllOrders() {
		try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(SELECT_ALL);
            orderList = extractOrderFromResultSet(resultSet);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return orderList;
	}

	@Override
	public Ordertable getSpecificRestuarant(int restaurantId) {
		try {
            pstmt = con.prepareStatement(SELECT_ON_RESTAURANT_ID);
            pstmt.setInt(1, restaurantId);
            
            resultSet = pstmt.executeQuery();
            ArrayList<Ordertable> resultList = extractOrderFromResultSet(resultSet);
            if (!resultList.isEmpty()) {
                order = resultList.get(0);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return order;
	}
	private ArrayList<Ordertable> extractOrderFromResultSet(ResultSet resultSet) {
        try {
            ArrayList<Ordertable> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(new Ordertable(
                    resultSet.getInt("orderId"),
                    resultSet.getInt("restaurantId"),
                    resultSet.getInt("userId"),
                    resultSet.getString("orderDate"),
                    resultSet.getDouble("totalAmount"),
                    resultSet.getString("status"),
                    resultSet.getString("paymentMode")
                ));
            }
            return list;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

	public int getMaxId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
