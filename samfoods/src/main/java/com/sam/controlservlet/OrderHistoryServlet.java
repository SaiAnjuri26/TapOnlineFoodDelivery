package com.sam.controlservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.samfoods.DaoImpl.OrderDaoImpl;
import com.samfoods.Dao.OrderDao;
import com.samfoods.DaoImpl.OrderHistoryDaoImpl;
import com.samfoods.DaoImpl.OrderIteamDaoImpl;
import com.samfoods.model.Cart;
import com.samfoods.model.Ordertable;
import com.samfoods.model.orderhistory;
import com.samfoods.model.orderiteam;
import com.samfoods.model.user;


@WebServlet("/Orderhistory")
public class OrderHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter printwriter =resp.getWriter();
    	
    	String status ="Pending";
    	String paymentMode=req.getParameter("paymentMode");
    	Float totalAmount = Float.parseFloat(req.getParameter("totalAmount"));
    	HttpSession session = req.getSession();
    	user User = (user)session.getAttribute("loggedIn");
    	if(User==null) {
    		resp.sendRedirect("Failure.jsp");
    		return;
    	}
    	int userId=User.getUserId();
    	
    	Cart cart = (Cart) session.getAttribute("cart");
    	if(cart==null || cart.getItems()==null) {
    		resp.sendRedirect("cart.jsp");
    		return;
    	}
    	int quality=cart.getItems().values().iterator().next().getQuantity();
    	float price=(float) cart.getItems().values().iterator().next().getPrice();
    	int menuId=cart.getItems().values().iterator().next().getMenuId();
    	int resturantId=cart.getItems().values().iterator().next().getRestaurantId();
    	
    	OrderDaoImpl orderDao = new OrderDaoImpl();
    	
    	Ordertable Ordertable = new Ordertable (
    		resturantId, userId, paymentMode, totalAmount, status, paymentMode);
    			
    	orderDao.addOrder(Ordertable);
    	
    	
    	
    	
    	
    	RequestDispatcher reqdep = req.getRequestDispatcher("OrderConfirmation.jsp");
    	reqdep.forward(req, resp);
    	
    }
}

