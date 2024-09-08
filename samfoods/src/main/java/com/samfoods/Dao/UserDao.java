package com.samfoods.Dao;

import java.util.ArrayList;




import com.samfoods.model.user;


public interface UserDao {

	int addUser(user u);
	ArrayList<user> getAllUsers();
	user getUser(String email);
	int updateUser(user u);
	int  deleteUser(String email);
	
	
	int addUser1(user u);
	//ModifyServlet
	int modifyUser(user u);
	
}
