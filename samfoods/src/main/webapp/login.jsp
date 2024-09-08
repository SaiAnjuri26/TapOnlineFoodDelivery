<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
    <link rel="stylesheet" href="login.css"> <!-- Linking the CSS file -->
</head>
<body>
    <div class="full-bg">
        <div class="content-center">
            <!-- Title "Sam Foods" with food emoji below -->
            <h1>Sam Foods</h1>
            <div class="emoji">🍽️</div> <!-- Emoji below the title -->
        </div>

        <div class="login-container">
            <% 
                // Displaying an error message if one exists
                String errorMessage = (String) request.getAttribute("Errormessage");
                if (errorMessage != null) { 
            %>
                <p style="color: red;"><%= errorMessage %></p> <!-- Red error message -->
            <% 
                } 
            %>
            <!-- Form starts here -->
            <form action="loginServlet" method="POST">
                <!-- Email Input -->
                <label for="email">Email</label>
                <input type="text" name="email" id="email" required placeholder="Enter your email">

                <!-- Password Input -->
                <label for="password">Password</label>
                <input type="password" name="password" id="password" required placeholder="Enter your password">

                <!-- Submit Button -->
                <input type="submit" value="Login">
            </form>
        </div>
    </div>
</body>
</html>
