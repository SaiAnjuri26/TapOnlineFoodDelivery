<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.samfoods.model.user" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
    <link rel="stylesheet" href="EditProfile.css">
    <link rel="stylesheet" href="home.css">
</head>
<body>
    <nav>
        <div class="nav-links">
            <a href="home.jsp">🏠 Home</a>
            <a href="ViewCart.jsp">🛒 View Cart</a>
            <a href="orderHistory.jsp">📜 View Order History</a>
            <div class="profile-menu">
                <a href="javascript:void(0)" class="profile-link" onclick="toggleDropdown()">👤 Profile</a>
                <div id="profileDropdown" class="dropdown-content">
                    <a href="EditProfile.jsp">✏️ Edit Profile</a>
                    <a href="settings.jsp">⚙️ Settings</a>
                    <a href="index.jsp">🚪 Logout</a>
                </div>
            </div>
        </div>
    </nav>
    
    <script>
        function toggleDropdown() {
            var dropdown = document.getElementById("profileDropdown");
            dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
        }

        window.onclick = function(event) {
            if (!event.target.matches('.profile-link')) {
                var dropdowns = document.getElementsByClassName("dropdown-content");
                for (var i = 0; i < dropdowns.length; i++) {
                    var openDropdown = dropdowns[i];
                    if (openDropdown.style.display === "block") {
                        openDropdown.style.display = "none";
                    }
                }
            }
        }
    </script>

    <div class="container">
        <h1>Edit Profile</h1>
        
        <% 
            user loggedInUser = (user) session.getAttribute("loggedIn");
            if (loggedInUser != null) {
        %>
        
        <form action="modifyServlet" method="post">
            <input type="hidden" name="userId" value="<%= loggedInUser.getUserId() %>">
            
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="<%= loggedInUser.getUsername() %>" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= loggedInUser.getEmail() %>" disabled>
            <input type="email" id="emailHidden" name="email" value="<%= loggedInUser.getEmail() %>" hidden>

            <label for="phonenumber">Phone Number:</label>
            <input type="text" id="phonenumber" name="phonenumber" value="<%= loggedInUser.getPhonenumber() %>" required>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" value="<%= loggedInUser.getAddress() %>" required>

            <button type="submit">Save Changes</button>
        </form>
        
        <% 
            } else {
        %>
        
        <p>You need to be logged in to modify your profile.</p>
        
        <% 
            }
        %>
        
    </div>

    <footer>
        <div class="footer-content">
            <div class="footer-info">
                <p>&copy; 2024 Sam Online Foods. All rights reserved.</p>
                <p>123 Food Street, Food City, FC 12345</p>
                <p>Email: contact@samfoods2326.com | Phone: (123) 965-223-9663</p>
            </div>
        </div>
    </footer>
</body>
</html>
