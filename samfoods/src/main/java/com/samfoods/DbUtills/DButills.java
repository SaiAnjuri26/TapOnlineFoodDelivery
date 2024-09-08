package com.samfoods.DbUtills;

import java.sql.DriverManager;
import java.sql.Connection;

final public class DButills 
{
	private static Connection con=null;
	private static String url="jdbc:mysql://localhost:3306/samfoods";
	private static String username="root";
	private static String password ="@Biggy2326!";
	public static  Connection myConnect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
