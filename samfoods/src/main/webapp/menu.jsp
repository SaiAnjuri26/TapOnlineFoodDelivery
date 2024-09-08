<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.samfoods.model.Menu" %>
<%@ page import="com.samfoods.model.user,com.samfoods.model.Restaurant" %>
<%@ page import="java.text.DecimalFormat" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu Items</title>
    <link rel="stylesheet" href="menu.css"> 
    <link rel="stylesheet" href="home.css"> <!-- Link to home.css for consistent styling -->
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
</head>
<body>
    <% user user = (user)session.getAttribute("loggedIn"); %>
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
                    <a href="Logout.jsp">🚪 Logout</a>
                </div>
            </div>
        </div>
    </nav>

    <div class="container">
        <h2>Menu Items</h2>
        <% 
        DecimalFormat df = new DecimalFormat("0.00");
        ArrayList<Menu> menuList = (ArrayList<Menu>) session.getAttribute("menuList");
        if (menuList != null && !menuList.isEmpty()) {
            for (Menu menu : menuList) {
        %>
            <div class="menu-item">
                <img src="<%= request.getContextPath() %>/SamFoodImages/<%= menu.getImagePath() %>" alt="<%= menu.getMenuName() %> Image">
                
                <div class="details">
                    <h3><%= menu.getMenuName() %></h3>
                    <p><%= menu.getDescription() %></p>
                    <p class="price">Price: ₹<%= df.format(menu.getPrice()) %></p>
                    
                    <form action="cartServlet" method="post">
                        <input type="hidden" name="itemId" value="<%= menu.getMenuId() %>">
                        <div class="quantity-wrapper">
                            <span>Quantity:</span>
                            <input type="number" name="quantity" value="1" min="1">
                        </div>
                        <input type="submit" value="Add">
                        <input type="hidden" name="action" value="add">
                    </form>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p>No menu items available for this restaurant.</p>
        <% 
        } 
        %>
    </div>

    <!-- Footer -->
    <footer>
        <div class="footer-content">
            <p>&copy; 2024 Sam Online Foods. All rights reserved.</p>
            <p>123 Food Street, Food City, FC 12345</p>
            <p>Email: contact@samfoods2326.com | Phone: (123) 965-223-9663</p>
            <p><a href="privacy.jsp">Privacy Policy</a> | <a href="terms.jsp">Terms of Service</a></p>
        </div>
    </footer>
</body>
</html>
