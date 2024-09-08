this is Payment.jsp file
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    String paymentMethod = request.getParameter("paymentMethod");
    String redirectUrl = "";

    if ("CreditCard".equals(paymentMethod)) {
        redirectUrl = "CreditCard.jsp";
    } else if ("Cash".equals(paymentMethod)) {
        redirectUrl = "Billing.jsp";
    } else if ("UPI".equals(paymentMethod)) {
        redirectUrl = "Upi.jsp";
    }
    
    if (redirectUrl != null && !redirectUrl.isEmpty()) {
        response.sendRedirect(redirectUrl);
    } else {
        out.println("Invalid payment method selected. Please go back and try again.");
    }
%>
</body>
</html>
