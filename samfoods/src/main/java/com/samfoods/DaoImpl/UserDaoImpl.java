package com.samfoods.DaoImpl;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.samfoods.Dao.UserDao;
import com.samfoods.DbUtills.DButills;
import com.samfoods.model.user;


public class UserDaoImpl implements UserDao 
{
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	
	ArrayList<user> userList = new ArrayList<user>();
	user user=null;
	
	
	
	
	private static final String ADD_USER="insert into `user`(`username`,`email`,`phonenumber`,`password`,`address`)"
					+ " values(?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `user`";
	private static final String SELECT_ON_EMAIL="select * from `user` where `email`=?";
	private static final String UPDATE_ON_EMAIL="update `user` set `username`=?, `phonenumber`=?,`password`=?,"
			+ "`address`=? where `email`=?";
	private static final String DELETE_ON_EMAIL="DELETE FROM `user` WHERE `email`=?";
	
	
	private static final String ADD_USER1="insert into `user`(`username`,`email`,`phonenumber`,`password`,`address`)"
			+ " values(?,?,?,?,?)";
	
	private static final String MODIFY_USER = "UPDATE `user` SET `username` = ?, `email` = ?, `phonenumber` = ?, `address` = ? WHERE `userId` = ?";

	
	
	int status =0;
	private int x;
	
	
	public UserDaoImpl() {
		try
		{
			con=DButills.myConnect();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	public int addUser(user u) {
		try {
			 pstmt = con.prepareStatement(ADD_USER);
			 pstmt.setString(1, u.getUsername());
			 pstmt.setString(2, u.getEmail());
			 pstmt.setString(3, u.getPhonenumber());
			 pstmt.setString(4, u.getPassword());
			 pstmt.setString(5, u.getAddress());
			 
			  status = pstmt.executeUpdate();
			}
			catch(Exception e) 
			{
			e.printStackTrace();
			}
		return status;
		
	}
	public ArrayList<user>getAllUsers() {
		try 
			{
			
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(SELECT_ALL);
			userList = extractUserFromResultSet(resultSet);
			
			}
	catch(Exception e) 
			{
			e.printStackTrace();
			
			}
		return userList;
		
	}
	
	@Override
	public user getUser(String email) {
		
		try
		{
			System.out.println("Line 89 DaOIMPL : "+email);
			pstmt = con.prepareStatement(SELECT_ON_EMAIL);
			pstmt.setString(1, email);
			resultSet = pstmt.executeQuery();
			userList = extractUserFromResultSet(resultSet);
			user = userList.get(0);
			
			
			
	        }
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
		
	}

	
	@Override
	public int updateUser(user u) {
		try 
		{
			
			pstmt = con.prepareStatement(UPDATE_ON_EMAIL);
			
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPhonenumber());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getAddress());
			pstmt.setString(5, u.getEmail());
			
			status = pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
	@Override
	public int deleteUser(String email) {
		try
		{
			pstmt = con.prepareStatement( DELETE_ON_EMAIL);
			pstmt.setString(1, email);
	
			status = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	ArrayList<user> extractUserFromResultSet(ResultSet resultSet) {
		try 
		{
			while(resultSet.next()) {
				userList.add(new user(resultSet.getInt("userId"),
				resultSet.getString("username"),
				resultSet.getString("email"),
				resultSet.getString("phonenumber"),
				resultSet.getString("password"),
				resultSet.getString("address")));
			}
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public int addUser1(com.samfoods.model.user u) {
		try {
			 pstmt = con.prepareStatement(ADD_USER1);
			 pstmt.setString(1, u.getUsername());
			 pstmt.setString(2, u.getEmail());
			 pstmt.setString(3, u.getPhonenumber());
			 pstmt.setString(4, u.getPassword());
			 pstmt.setString(5, u.getAddress());
			 
			  status = pstmt.executeUpdate();
			}
			catch(Exception e) 
			{
			e.printStackTrace();
			}
		return status;
		
	}
	@Override
	public int modifyUser(user u) {
		
		
		try {
			pstmt =con.prepareStatement(MODIFY_USER);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2,u.getEmail());
			pstmt.setString(3, u.getPhonenumber());
			pstmt.setString(4,u.getAddress());
			
			pstmt.setInt(5,u.getUserId());
			x=pstmt.executeUpdate();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	
	
}
