package com.samfoods.DaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.samfoods.Dao.OderHistoryDao;
import com.samfoods.DbUtills.DButills;
import com.samfoods.model.orderhistory;

public class OrderHistoryDaoImpl implements OderHistoryDao
{
	Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;

    ArrayList<orderhistory> orderHistoryList = new ArrayList<>();
    orderhistory orderHistory;

    private static final String ADD_HISTORY = "INSERT INTO `orderhistory`(`orderId`, `userId`, `orderDate`, `totalAmount`, `status`) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM `orderhistory`";
    private static final String SELECT_ON_ORDER_ID = "SELECT * FROM `orderhistory` WHERE `userId`=?";
    
    
    
    private static final String SELECT_HISTORY_BY_USER_ID = "SELECT * FROM orderhistory WHERE userId=?";


    public  OrderHistoryDaoImpl() {
        try {
            con = DButills.myConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public int addHistory(orderhistory oh) {
		int status = 0;
        try {
            pstmt = con.prepareStatement(ADD_HISTORY);
            pstmt.setInt(1, oh.getOrderId());
            pstmt.setInt(2, oh.getUserId());
            pstmt.setString(3, oh.getOrderDate());
            pstmt.setFloat(4, oh.getTotalAmount());
            pstmt.setString(5, oh.getStatus());
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

	}

	@Override
	public ArrayList<orderhistory> getAllOderHistoryIteams(int userId) {
		try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(SELECT_ALL);
            orderHistoryList = extractOrderHistoryFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistoryList;
	}

	@Override
	public orderhistory getSpecificHistoryIteam(int userId) {
		try {
            pstmt = con.prepareStatement(SELECT_ON_ORDER_ID);
            pstmt.setInt(1, userId);
            resultSet = pstmt.executeQuery();
            ArrayList<orderhistory> resultList = extractOrderHistoryFromResultSet(resultSet);
            if (!resultList.isEmpty()) {
                orderHistory = resultList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistory;
	}
	
	 private ArrayList<orderhistory> extractOrderHistoryFromResultSet(ResultSet resultSet) {
	        ArrayList<orderhistory> list = new ArrayList<>();
	        try {
	            while (resultSet.next()) {
	                list.add(new orderhistory(
	                    resultSet.getInt("orderHistoryId"),
	                    resultSet.getInt("orderId"),
	                    resultSet.getInt("userId"),
	                    resultSet.getString("orderDate"),
	                    resultSet.getFloat("totalAmount"),
	                    resultSet.getString("status")
	                ));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	@Override
	public ArrayList<orderhistory> getOrderHistoryByUserId(int userId) {
        ArrayList<orderhistory> historyList = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(SELECT_HISTORY_BY_USER_ID);
            pstmt.setInt(1, userId);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                historyList.add(new orderhistory(
                		resultSet.getInt("orderHistoryId"),
	                    resultSet.getInt("orderId"),
	                    resultSet.getInt("userId"),
	                    resultSet.getString("orderDate"),
	                    resultSet.getFloat("totalAmount"),
	                    resultSet.getString("status")
	                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historyList;
    }

}
