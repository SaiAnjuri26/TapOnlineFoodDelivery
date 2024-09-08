package com.sam.controlservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samfoods.Dao.UserDao;
import com.samfoods.DaoImpl.UserDaoImpl;
import com.samfoods.model.user;



@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String phonenumber = req.getParameter("phonenumber");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		
		user u = new user(username, email, phonenumber, password, address);
		UserDao userDao= new UserDaoImpl();
		 
		int status= userDao.addUser1(u);
		
		if(status==0) {
			resp.sendRedirect("Failure.jsp");
		}
		else {
			resp.sendRedirect("login.jsp");
		}
	}
   
}
