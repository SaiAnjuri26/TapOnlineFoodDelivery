<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    <link rel="stylesheet" href="orderConfirmation.css">
</head>
<body>
    <div class="container">
        <h1>🎉 Thank You for Your Order! 🥳</h1>
        <p>Your payment has been successfully processed. 🍽️</p>
        <p>Order Number: <strong><%= "12345" %></strong></p>
        <p>You will receive a confirmation email shortly. ✉️</p>
        <a href="home.jsp" class="go-to-home">Go to Home 🏠</a>
    </div>

    <!-- Confetti Animation -->
    <div class="confetti"></div>
    <div class="confetti"></div>
    <div class="confetti"></div>
    <div class="confetti"></div>
    <div class="confetti"></div> <!-- Extra confetti element for a larger burst -->
</body>
</html>
