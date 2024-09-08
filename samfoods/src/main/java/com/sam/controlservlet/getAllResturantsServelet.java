package com.sam.controlservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.samfoods.Dao.RestaurantDao;
import com.samfoods.DaoImpl.RestaurantDaoImpl;
import com.samfoods.model.Restaurant;


@WebServlet("/getAllResturantsServlet")
public class getAllResturantsServelet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RestaurantDao allres = new RestaurantDaoImpl();
		
		ArrayList<Restaurant> restaurantList = allres.getAllResturant();
		 HttpSession session =req.getSession();
		 session.setAttribute("restaurantList", restaurantList);
		 
		 resp.sendRedirect("home.jsp");

	}
}
