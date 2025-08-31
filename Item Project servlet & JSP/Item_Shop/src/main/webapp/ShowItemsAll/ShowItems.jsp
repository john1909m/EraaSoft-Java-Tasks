<%@ page import="java.util.List" %>
<%@ page import="com.servlet.model.Item" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Items</title>
    <link rel="stylesheet" href="ShowItems.css">
</head>
<body>
<div class="layer">
    <h1>Items</h1>

    <%
        List<Item> items = (List<Item>) request.getAttribute("allItems");
    %>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>PRICE</th>
                <th>TOTAL_NUMBER</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <% if (items != null && !items.isEmpty()) {
               for (Item item : items) { %>
                   <tr>
                       <td><strong><%= item.getId() %></strong></td>
                       <td><%= item.getName() %></td>
                       <td><%= item.getPrice() %></td>
                       <td><%= item.getTotalNumber() %></td>
                       <td>
                           <a href="#">Update</a>
                           <a href="#">Delete</a>
                       </td>
                   </tr>
        <%     } 
           } else { %>
               <tr><td colspan="5">No items found.</td></tr>
        <% } %>
        </tbody>
    </table>

    <button class="f"><a href="#">Add Item</a></button>
</div>
</body>
</html>
