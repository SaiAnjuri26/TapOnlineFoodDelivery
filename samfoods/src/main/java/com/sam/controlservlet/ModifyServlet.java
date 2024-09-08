package com.sam.controlservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samfoods.model.user;
import com.samfoods.Dao.UserDao;
import com.samfoods.DaoImpl.UserDaoImpl;

@WebServlet("/modifyServlet")
public class ModifyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("userId"));
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phonenumber = req.getParameter("phonenumber");
        String address = req.getParameter("address");
        
        // Assuming password is not being modified here
        user u = new user(id, username, email, phonenumber, null, address);
        System.out.println("User at ModifyServlet: " + u);
        
        UserDao userDao = new UserDaoImpl();
        int status = userDao.modifyUser(u);
        
        if (status == 0) {
            resp.sendRedirect("failure.jsp");
        } else {
            // Update the session attribute with the new user details
            user updatedUser = userDao.getUser(email);
            req.getSession().setAttribute("loggedIn", updatedUser);
            resp.sendRedirect("home.jsp");
        }
    }
}
