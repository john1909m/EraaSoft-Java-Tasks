<%@page import="com.item.service.userService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>User Login</title>
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
      width: 350px;
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

    input {
      width: 100%;
      padding: 10px 12px;
      border: 1px solid #ccc;
      border-radius: 8px;
      font-size: 14px;
      outline: none;
      transition: border-color .2s;
    }

    input:focus {
      border-color: #007bff;
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

    .note {
      text-align: center;
      font-size: 13px;
      margin-top: 10px;
      color: #666;
    }
    .error{
    	color:red;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Login</h2>
    <%if(request.getAttribute("error")!=null){ %>
    <p class="error"><%=request.getAttribute("error") %>
    <% } %>
    <form action="/Item_Shop/userController?action=login" method="post">
      <div class="form-group">
        <label for="email">Email Address</label>
        <input type="email" id="email" name="email" required maxlength="255">
      </div>

      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required minlength="6" maxlength="255">
        
      </div>

      <button type="submit">Login</button>
      <p class="note">Don't have an account? <a href="./Register.jsp">Register</a></p>
    </form>
  </div>
</body>
</html>
