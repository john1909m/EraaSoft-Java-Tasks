<%@page import="com.servlet.model.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Item Details</title>
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
        textarea {
            width: 100%;
            height: 120px;
            padding: 10px 12px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
            outline: none;
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
	Item item =(Item) session.getAttribute("selectedItem");
%>
<body>
    <div class="container">
        <h2>Add Item Details</h2>
        <form action="ItemController?action=editDetails" method="post">
            <input type="hidden" name="item_id" value="<%= item.getId() %>">
            <input type="hidden" name="name" value="<%= item.getName() %>">
            <input type="hidden" name="price" value="<%= item.getPrice() %>">
            <input type="hidden" name="total_number" value="<%= item.getTotalNumber() %>">

            <div class="form-group">
                <label for="details">Item Details</label>
                <textarea id="details" name="details" required maxlength="500">${itemDetails}</textarea>
            </div>

            <button type="submit">Save Details</button>
        </form>
    </div>
</body>
</html>
