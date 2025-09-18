<%@page import="javax.servlet.http.Cookie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String favPlace = request.getParameter("favplace");

    if (favPlace != null && !favPlace.trim().isEmpty()) {
       Cookie placeCookie = new Cookie("favplace", favPlace);
        placeCookie.setMaxAge(30 * 24 * 60 * 60);
        response.addCookie(placeCookie);
    } else {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("favplace")) {
                    favPlace = c.getValue();
                    break;
                }
            }
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>
    <h2>Welcome to Home Page</h2>
    <%
        if (favPlace != null && !favPlace.isEmpty()) {
            out.println("<p>Your favorite place is: <b>" + favPlace + "</b></p>");
        } else {
            out.println("<p>No favorite place found. Please go back and enter one.</p>");
        }
    %>
    <br>
    <a href="start.html">Back to Start</a>
</body>
</html>
