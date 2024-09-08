package com.samfoods.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.samfoods.Dao.OrderIteamDao;

import com.samfoods.DbUtills.DButills;
import com.samfoods.model.orderiteam;

public class OrderIteamDaoImpl implements OrderIteamDao
{

	Connection con;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;

    ArrayList<orderiteam> orderIteamList = new ArrayList<orderiteam>();
    orderiteam orderIteam;

    private static final String ADD_ORDERITEAM = "INSERT INTO `orderiteam`(`orderId`, `menuId`, `quantity`, `subTotal`) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM `orderiteam`";
    private static final String SELECT_ON_ORDER_ID = "SELECT * FROM `orderiteam` WHERE `orderId`=?";
    
    public OrderIteamDaoImpl() {
        try {
            con = DButills.myConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public int addOderIteam(orderiteam ot) {
		int status = 0;
        try {
            pstmt = con.prepareStatement(ADD_ORDERITEAM);
            pstmt.setInt(1, ot.getOrderId());
            pstmt.setInt(2, ot.getMenuId());
            pstmt.setInt(3, ot.getQuantity());
            pstmt.setFloat(4, ot.getSubTotal());
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
	}

	@Override
	public ArrayList<orderiteam> getAllOderIteams() {
		 try {
	            stmt = con.createStatement();
	            resultSet = stmt.executeQuery(SELECT_ALL);
	            orderIteamList = extractOrderIteamFromResultSet(resultSet);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return orderIteamList;
	}

	@Override
	public orderiteam getSpecificOrderIteam(int orderId) {
		try {
            pstmt = con.prepareStatement(SELECT_ON_ORDER_ID);
            pstmt.setInt(1, orderId);
            resultSet = pstmt.executeQuery();
            ArrayList<orderiteam> resultList = extractOrderIteamFromResultSet(resultSet);
            if (!resultList.isEmpty()) {
                orderIteam = resultList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderIteam;
	}
	
	private ArrayList<orderiteam> extractOrderIteamFromResultSet(ResultSet resultSet) {
        ArrayList<orderiteam> list = new ArrayList<orderiteam>();
        try {
            while (resultSet.next()) {
                list.add(new orderiteam(
                    resultSet.getInt("oderIteamId"),
                    resultSet.getInt("orderId"),
                    resultSet.getInt("menuId"),
                    resultSet.getInt("quantity"),
                    resultSet.getFloat("subTotal")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	

}
