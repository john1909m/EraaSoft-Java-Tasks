<%@ page import="java.util.List" %>
<%@ page import="com.servlet.model.Item" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Items</title>
    <style>
    	@charset "UTF-8";
/* General page style */
body {
    font-family: Arial, Helvetica, sans-serif;
    background: #f4f6f8;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: flex-start;
    min-height: 100vh;
}

/* Container */
.layer {
    width: 90%;
    max-width: 1000px;
    margin-top: 40px;
    background: #fff;
    padding: 20px 30px;
    border-radius: 12px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

/* Heading */
.layer h1 {
    text-align: center;
    color: #333;
    margin-bottom: 20px;
    font-size: 28px;
    border-bottom: 2px solid #007bff;
    padding-bottom: 10px;
}

/* Table */
table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

thead {
    background: #007bff;
    color: #fff;
}

th, td {
    text-align: center;
    padding: 12px 15px;
    border-bottom: 1px solid #ddd;
    font-size: 14px;
}

tbody tr:hover {
    background: #f1f7ff;
    transition: background 0.2s;
}

/* Action links */
td a {
    margin: 0 5px;
    text-decoration: none;
    color: #007bff;
    font-weight: bold;
    transition: color 0.2s;
}

td a:hover {
    color: #0056b3;
    text-decoration: underline;
}

/* Add Item button */
button.f {
    display: block;
    margin: 0 auto;
    padding: 10px 20px;
    border: none;
    border-radius: 8px;
    background: #007bff;
    cursor: pointer;
    transition: background 0.3s;
}

button.f a {
    color: #fff;
    width:100%;
    height:100%;
    text-decoration: none;
    font-weight: bold;
}

button.f:hover {
    background: #0056b3;
}

form {
  background: #fff;
  padding: 20px 25px;
  border-radius: 12px;
  width: 350px;
  margin: 30px auto;
  display: flex;
  flex-direction: column;
  gap: 12px;
  font-family: Arial, sans-serif;
}


form label {
  font-weight: bold;
  font-size: 14px;
  color: #333;
  margin-bottom: 5px;
}


form input[type="number"] {
  padding: 10px 12px;
  border: 1px solid #ccc;
  border-radius: 8px;
  font-size: 14px;
  transition: border-color 0.3s;
}

form input[type="number"]:focus {
  border-color: #007bff;
  outline: none;
}
form input[type="submit"] {
  padding: 10px;
  background: #007bff;
  border: none;
  border-radius: 8px;
  color: #fff;
  font-size: 15px;
  font-weight: bold;
  cursor: pointer;
  transition: background 0.3s;
}

form input[type="submit"]:hover {
  background: #0056b3;
}

    	
    </style>
</head>
<body>
<div class="layer">
    <h1>Items</h1>

    <%
        List<Item> items = (List<Item>) request.getAttribute("allItems");
    %>
	<form action="/Item_Shop/ItemController?action=getItem" method="post">
		<label>Search by ID</label>
		<input type="number" placeholder="Enter ID" name="id">
		<input type="submit" placeholder="Search">
		<button class="f"><a href="/Item_Shop/ItemController?action=getItems">Show All Items</a></button>
	</form>
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
                           <a href="./EditItem.jsp?id=<%= item.getId()%>&name=<%= item.getName()%>&price=<%= item.getPrice()%>&totalNumber=<%= item.getTotalNumber()%>">Update</a>
                           <a href="/Item_Shop/ItemController?action=removeItem&id=<%= item.getId() %>">Delete</a>
                       </td>
                   </tr>
        <%     } 
           } else { %>
               <tr><td colspan="5">No items found.</td></tr>
        <% } %>
        </tbody>
    </table>

    <button class="f"><a href="./addItem.jsp">Add Item</a></button>
</div>
</body>
</html>
