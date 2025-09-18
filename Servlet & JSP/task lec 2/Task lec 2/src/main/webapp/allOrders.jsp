<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
    HttpSession session = request.getSession(false);
    List<String> orders = null;

    if (session != null) {
        orders = (List<String>) session.getAttribute("orders");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Orders</title>
</head>
<body>
    <h2>All Orders in This Session</h2>
    <%
        if (orders != null && !orders.isEmpty()) {
            out.println("<ul>");
            for (String order : orders) {
                out.println("<li>" + order + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>No orders found in this session.</p>");
        }
    %>

    <br>
    <a href="order.jsp">Back to Order Page</a>
</body>
</html>
