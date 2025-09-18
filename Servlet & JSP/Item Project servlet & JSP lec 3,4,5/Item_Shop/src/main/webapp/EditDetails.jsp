<%@page import="com.servlet.model.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Item Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
        .container {
            background: #fff;
            padding: 25px 30px;
            border-radius: 12px;
            box-shadow: 0 6px 15px rgba(0,0,0,0.1);
            width: 400px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            color: #555;
        }
        input, textarea {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
            outline: none;
        }
        textarea {
            height: 100px;
            resize: none;
        }
        button {
            width: 100%;
            padding: 12px;
            background: #007bff;
            border: none;
            border-radius: 8px;
            color: white;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background .3s;
        }
        button:hover {
            background: #0056b3;
        }
    </style>
</head>
<%
boolean isLoggedIn=false;
Cookie[] cookies=request.getCookies();
if(cookies != null) {
	for(Cookie c:cookies) {
		if ("isLoggedIn".equals(c.getName()) && "true".equals(c.getValue())) {
            isLoggedIn = true;
            break;
        }
	}
}
if(!isLoggedIn) {
	response.sendRedirect("userController?action=showLogin");
}
session=request.getSession();
if(session.getAttribute("currentUser")==null) {
	response.sendRedirect("userController?action=showLogin");
}
    Item itemDetails = (Item) request.getAttribute("itemDetails"); 
	String expDate = "";
	if(itemDetails != null && itemDetails.getExpirationDate() != null){
	    expDate = itemDetails.getExpirationDate().toString(); // ده بيرجع yyyy-MM-dd بالفعل
	}
%>
<body>
    <div class="container">
        <h2>Edit Item Details</h2>
        <form action="ItemController?action=editDetails" method="post">
            
            <input type="hidden" name="item_id" value="<%= itemDetails != null ? itemDetails.getId() : "" %>">

            <div class="form-group">
                <label for="desc">Description</label>
                <textarea id="desc" name="desc" required maxlength="500"><%= itemDetails != null ? itemDetails.getDesc() : "" %></textarea>
            </div>

            <div class="form-group">
                <label for="brand">Brand</label>
                <input id="brand" type="text" name="brand" value="<%= itemDetails != null ? itemDetails.getBrand() : "" %>" required>
            </div>

            <div class="form-group">
                <label for="expiration_date">Expiration Date</label>
                <input id="expiration_date" type="date" name="expiration_date" value="<%= expDate %>" required>
            </div>

            <button type="submit">Save Details</button>
        </form>
    </div>
</body>
</html>
