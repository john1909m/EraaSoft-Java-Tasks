<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%

    HttpSession session = request.getSession();
    List<String> orders = (List<String>) session.getAttribute("orders");
    if (orders == null) {
        orders = new ArrayList<>();
        session.setAttribute("orders", orders);
    }
    String food = request.getParameter("food");
    if (food != null && !food.trim().isEmpty()) {
        orders.add(food.trim());
        session.setAttribute("orders", orders);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Food</title>
</head>
<body>
    <h2>Order Food</h2>
    <form method="post">
        <label for="food">Enter Food:</label>
        <input type="text" id="food" name="food" required>
        <button type="submit">Add Order</button>
    </form>

    <br>
    <a href="allorders.jsp">View All Orders</a>
</body>
</html>
