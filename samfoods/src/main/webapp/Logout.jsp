<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logout</title>
    <link rel="stylesheet" href="home.css">
</head>
<body>
    <% // Check if a session exists and invalidate it
    HttpSession ses = request.getSession(false); // Avoid creating a new session if one doesn't exist
    if (session != null) {
        session.invalidate(); // Invalidate the session to clear all session data
    }

    // Redirect to the login page or home page after logout
    response.sendRedirect("index.jsp");
    %>
</body>
</html>
