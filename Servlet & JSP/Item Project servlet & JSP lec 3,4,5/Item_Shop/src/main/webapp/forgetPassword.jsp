<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Forget Password</title>
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

    .error {
      color: red;
      text-align: center;
      margin-bottom: 10px;
    }

    .note {
      text-align: center;
      font-size: 13px;
      margin-top: 10px;
      color: #666;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Forget Password</h2>

    <% if(request.getAttribute("error") != null) { %>
      <p class="error"><%= request.getAttribute("error") %></p>
    <% } %>

    <form action="userController?action=forgetPassword" method="post">
      <div class="form-group">
        <label>Email:</label>
        <input type="email" name="email" required >
      </div>

      <div class="form-group">
        <label>First Name:</label>
        <input type="text" name="firstName" required>
      </div>

      <div class="form-group">
        <label>Last Name:</label>
        <input type="text" name="lastName" required>
      </div>

      <button type="submit">Submit</button>
      <p class="note"><a href="./login.jsp">Back to Login</a></p>
    </form>
  </div>
</body>
</html>
