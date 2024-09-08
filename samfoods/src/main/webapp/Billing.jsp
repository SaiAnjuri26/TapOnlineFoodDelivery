<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.samfoods.model.Cart" %>
<%@ page import="com.samfoods.model.CartItem" %>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Billing Information</title>
    <link rel="stylesheet" href="billing.css">
</head>
<body>
    <div class="container">
        <h1>Billing Information</h1> <!-- This will be centered in CSS -->
        <%
            DecimalFormat df = new DecimalFormat("0.00");
            Cart cart = (Cart) session.getAttribute("cart");
            double totalAmount = 0.0;

            if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {
                for (CartItem item : cart.getItems().values()) {
                    totalAmount += (item.getPrice() * item.getQuantity());
                }
        %>
            <div class="billing-container">
                <!-- Billing Summary Section -->
                <div class="billing-summary">
                    <h2 class="items-title">Your Items</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Item Image</th>
                                <th>Item Name</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (CartItem item : cart.getItems().values()) {
                            %>
                                <tr>
                                    <td class="cart-item-image"><img src="<%= request.getContextPath() %>/SamFoodImages/<%= item.getImagePath() %>" alt="<%= item.getName() %> Image"></td>
                                    <td><%= item.getName() %></td>
                                    <td><%= item.getQuantity() %></td>
                                    <td>₹<%= item.getPrice() %></td>
                                    <td>₹<%= item.getPrice() * item.getQuantity() %></td>
                                </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <h3 class="total-amount">Total Amount: ₹<%= df.format(totalAmount) %></h3>
                </div>
            </div>

            <!-- Address Section -->
            <div class="address-section">
                <h2>Delivery Address</h2>
                <form action="OrderConfirmation.jsp" method="post">
                    <div class="address-fields">
                        <label for="address">Address:</label>
                        <textarea id="address" name="address" rows="4" required></textarea>
                    </div>
                    <input type="hidden" name="totalAmount" value="<%= totalAmount %>">
                    <!-- Actions moved below the address -->
                    <div class="form-actions">
                        <input type="submit" value="Confirm Order" class="confirm-button">
                    </div>
                </form>
                <form action="cart.jsp" method="post" class="cancel-form">
                    <input type="submit" value="Cancel Order" class="cancel-button">
                </form>
            </div>

        <%
            } else {
        %>
            <p>Your cart is empty. Redirecting to menu...</p>
            <script>
                setTimeout(function(){
                    window.location.href = '<%= request.getContextPath() %>/menu.jsp';
                }, 3000);
            </script>
        <%
            }
        %>
    </div>
</body>
</html>
