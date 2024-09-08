package com.sam.controlservlet;

import java.io.IOException;






import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.samfoods.Dao.UserDao;
import com.samfoods.DaoImpl.UserDaoImpl;
import com.samfoods.model.user;

/**
 * Servlet implementation class loginServelet
 */

@WebServlet("/loginServlet")
public class loginServelet extends HttpServlet {
    private HttpSession session;

	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        session= req.getSession();
        UserDao userDao = new UserDaoImpl();
        user user = userDao.getUser(email);
        session.setAttribute("user", user);
        System.out.println("User at 30 login servlet: " + user);

        if (user == null) {
            req.setAttribute("Errormessage", "Invalid Email or Password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else if (password.equals(user.getPassword())) {
            HttpSession session = req.getSession();
            session.setAttribute("loggedIn", user);
            resp.sendRedirect("getAllResturantsServlet");
        } else {
            req.setAttribute("Errormessage", "Invalid Email or Password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}


	
	
	


