<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.samfoods.model.CartItem" %>
<%@ page import="com.samfoods.model.Cart" %>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Shopping Cart</title>
    <link rel="stylesheet" href="cart.css">
</head>
<body>
    <div class="container">
        <div class="content-container">
            <h2>Your Shopping Cart</h2>
            <%
                Cart cart = (Cart) session.getAttribute("cart");
                if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {
                    DecimalFormat df = new DecimalFormat("0.00");
            %>
                <div class="cart-items-container">
                    <%
                        for (CartItem item : cart.getItems().values()) {
                    %>
                    <div class="cart-item">
                        <!-- Image section -->
                        <div class="cart-item-image">
                            <img src="<%= request.getContextPath() %>/SamFoodImages/<%= item.getImagePath() %>" alt="<%= item.getName() %> Image">
                        </div>
                        
                        <!-- Details section -->
                        <div class="cart-item-details">
                            <h3><%= item.getName() %></h3>
                            <p>Price: ₹<%= df.format(item.getPrice()) %></p>
                            <p>Total: ₹<%= df.format(item.getPrice() * item.getQuantity()) %></p>
                        </div>
                        
                        <!-- Actions section -->
                        <div class="cart-item-actions">
                            <form action="cartServlet" method="post" class="action-form">
                                <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                                <div class="quantity-wrapper">
                                    <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1">
                                </div>
                                <input type="submit" value="Update">
                                <input type="hidden" name="action" value="update">
                            </form>
                            <form action="cartServlet" method="post" class="action-form">
                                <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                                <input type="submit" value="Remove">
                                <input type="hidden" name="action" value="remove">
                            </form>
                            <!-- Add More Button -->
                            <form action="menu.jsp" method="get" class="action-form">
                                <input type="submit" value="Add More" class="add-more-button">
                            </form>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>

                <!-- Cart summary -->
                <div class="cart-summary">
                    <p>Total Amount: <span class="total">₹<%= df.format(cart.getTotalPrice()) %></span></p>
                </div>

                <!-- Payment mode section -->
                <div class="payment-mode">
                    <h2>Select Payment Method</h2>
                    <form action="paymentMethodSelection.jsp" method="post">
                        <div class="payment-options">
                            <label class="payment-option">
                                <input type="radio" id="creditCard" name="paymentMethod" value="CreditCard" required>
                                <span>💳 Credit Card</span>
                            </label>
                            <label class="payment-option">
                                <input type="radio" id="cash" name="paymentMethod" value="Cash" required>
                                <span>💵 Cash on Delivery</span>
                            </label>
                            <label class="payment-option">
                                <input type="radio" id="upi" name="paymentMethod" value="UPI" required>
                                <span>📱 UPI</span>
                            </label>
                        </div>
                        <input type="submit" value="Proceed To Pay" class="payment-submit">
                    </form>
                </div>
            <%
                } else {
            %>
                <p>Your cart is empty. Redirecting to menu...</p>
                <script>
                    setTimeout(function(){
                        window.location.href = '<%= request.getContextPath() %>/menu.jsp';
                    }, 2000);
                </script>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>
