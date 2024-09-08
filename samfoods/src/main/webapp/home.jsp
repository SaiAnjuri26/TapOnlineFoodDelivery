<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.samfoods.model.user,com.samfoods.model.Restaurant" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="home.css">
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
    <% user loggedInUser = (user)session.getAttribute("loggedIn"); %>
    <nav>
        <div class="nav-links">
            <a href="home.jsp">🏠 Home</a>
            <a href="cart.jsp">🛒 View Cart</a>
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
        <div class="header-title">
            <h1>Welcome to Sam Online Foods</h1>
        </div>
        
        <% if (loggedInUser != null) { %>
            <div class="logged-in-popup">
                <h2>Welcome back, <%= loggedInUser.getUsername() %> 👋</h2>
            </div>
        <% } %>

        <h2>Restaurants</h2>
        <div class="restaurant-container">
        <% 
            ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) session.getAttribute("restaurantList");
            if (restaurants != null && !restaurants.isEmpty()) {
                for (Restaurant restaurant : restaurants) {
        %>
            <div class="restaurant">
                <img src="<%= request.getContextPath() %>/SamFoodImages/<%= restaurant.getImagePath() %>" alt="<%= restaurant.getRestaurantName() %> Image" class="restaurant-image">
                <h3><%= restaurant.getRestaurantName() %></h3>
                <p><%= restaurant.getCuisineType() %></p>
                <p class="is-active <%= "Open".equalsIgnoreCase(restaurant.getisActive()) ? "open" : "closed" %>">
                    Active: <%= "Open".equalsIgnoreCase(restaurant.getisActive()) ? "Open" : "Closed" %>
                </p>
                <p>Address: <%= restaurant.getAddress() %></p>
                <p>Delivery Time: <%= restaurant.getDeliveryTime() %></p>
                <p>Rating: <%= restaurant.getRating() %> ⭐</p>
                <a href="menu?restaurantId=<%= restaurant.getRestaurantId() %>" class="view-menu-button">📜 View Menu</a>
            </div>
        <% 
                }
            } else { 
        %>
            <p>No restaurants available.</p>
        <% 
            } 
        %>
        </div>
    </div>
    
    <footer>
        <div class="footer-content">
            <div class="footer-info">
                <p>&copy; 2024 Sam Online Foods. All rights reserved.</p>
                <p>123 Food Street, Food City, FC 12345</p>
                <p>Email: contact@samfoods2326.com | Phone: (123) 965-223-9663</p>
            </div>

            <div class="footer-links">
                <a href="https://www.apple.com/app-store/" target="_blank">
                     <img src="<%= request.getContextPath() %>/SamFoodImages/Appstore.png" alt="Download on the App Store">
                </a>
                <a href="https://play.google.com/store" target="_blank">
                    <img src="<%= request.getContextPath() %>/SamFoodImages/GoolePlay.webp" alt="Download on the Google Play Store">
                </a>
            </div>

            <p><a href="privacy.jsp">Privacy Policy</a> | <a href="terms.jsp">Terms of Service</a></p>
        </div>
    </footer>

</body>
</html>