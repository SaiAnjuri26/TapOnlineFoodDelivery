package com.sam.controlservlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.samfoods.Dao.MenuDao;
import com.samfoods.DaoImpl.MenuDaoImpl;
import com.samfoods.model.Menu;


@WebServlet("/menu")
public class MenuServelet extends HttpServlet {
	
	
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp)  {
			try {
				int restaurantId=Integer.parseInt(req.getParameter("restaurantId"));
				
				MenuDao menuDao= new  MenuDaoImpl();
				ArrayList<Menu> menuList=menuDao.getMenuOnRestaurantId(restaurantId);
				
				
				 HttpSession session =req.getSession();
				 session.setAttribute("menuList", menuList);
				 
				 resp.sendRedirect("menu.jsp");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
   
}

