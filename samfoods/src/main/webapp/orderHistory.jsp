<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Order History</title>
    <link rel="stylesheet" href="orderHistory.css">
</head>
<body>
    <div class="container">
        <h1>Your Order History</h1>
        <c:forEach var="item" items="${historyItems}">
            <div class="order-item">
                <p>Order ID: ${item.orderId}</p>
                <p>Order Date: ${item.orderDate}</p>
                <p>Total Amount: ${item.totalAmount}</p>
            </div>
        </c:forEach>
    </div>
</body>
</html>
