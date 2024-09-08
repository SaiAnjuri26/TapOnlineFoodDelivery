<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Credit Card Payment</title>
    <link rel="stylesheet" href="creditCard.css">
</head>
<body>
    <div class="container">
        <center><h2>Enter Your Credit Card Details</h2></center>
        <form action="Billing.jsp" method="post">
            <label for="cardName">Cardholder's Name:</label>
            <input type="text" id="cardName" name="cardName" required>
            
            <label for="cardNumber">Card Number:</label>
            <input type="text" id="cardNumber" name="cardNumber" required>
            
            <label for="expiryDate">Expiry Date (MM/YY):</label>
            <input type="text" id="expiryDate" name="expiryDate" required>
            
            <label for="cvv">CVV:</label>
            <input type="text" id="cvv" name="cvv" required>
            
            <input type="submit" value="Submit Payment">
        </form>
    </div>
</body>
</html>
