<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.samfoods.model.Cart" %>
<%@ page import="com.samfoods.model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>UPI Payment</title>
    <link rel="stylesheet" href="Upi.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <img src="googlepay.jpg" alt="Google Pay Logo" class="logo">
            <img src="phonepe.jpg" alt="PhonePe Logo" class="logo">
            <h1>UPI Payment</h1>
        </div>
        
        <div class="billing-summary">
            <h2>Order Summary</h2>
            <table>
                <thead>
                    <tr>
                        <th>Item Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        Cart cart = (Cart) session.getAttribute("cart");
                        double totalAmount = 0.0;
                        if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {
                            for (CartItem item : cart.getItems().values()) {
                                totalAmount += item.getPrice() * item.getQuantity();
                    %>
                    <tr>
                        <td><%= item.getName() %></td>
                        <td><%= item.getQuantity() %></td>
                        <td>$<%= item.getPrice() %></td>
                        <td>$<%= item.getPrice() * item.getQuantity() %></td>
                    </tr>
                    <% 
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="4">No items in the cart.</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <h3 class="total-amount">Total Amount: $<%= totalAmount %></h3>
        </div>

        <form action="OrderConfirmation.jsp" method="post">
            <div class="form-group">
                <label for="upiId">UPI ID:</label>
                <input type="text" id="upiId" name="upiId" placeholder="Enter your UPI ID" required>
            </div>
            <div class="form-group">
                <label for="amount">Amount:</label>
                <input type="number" id="amount" name="amount" value="<%= totalAmount %>" readonly>
            </div>
            <input type="submit" value="Proceed with Payment" class="submit-btn">
        </form>
    </div>
</body>
</html>
