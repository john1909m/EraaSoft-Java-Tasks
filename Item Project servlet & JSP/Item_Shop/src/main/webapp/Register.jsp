<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>User Registration</title>
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
      width: 380px;
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
  </style>
</head>
<body>
  <div class="container">
    <h2>Register</h2>
    <form action="/Item_Shop/userController?action=register" method="post">
      <div class="form-group">
        <label for="first_name">First Name</label>
        <input type="text" id="first_name" name="first_name" required minlength="2" maxlength="50">
        <%if(request.getAttribute("fNameError")!=null){ %>
        <p><%=request.getAttribute("fNameError") %></p>
        <% } %>
      </div>

      <div class="form-group">
        <label for="last_name">Last Name</label>
        <input type="text" id="last_name" name="last_name" required minlength="2" maxlength="50">
      	<%if(request.getAttribute("lNameError")!=null){ %>
        <p><%=request.getAttribute("lNameError") %></p>
        <% } %>
      </div>

      <div class="form-group">
        <label for="phone_number">Phone Number</label>
        <input type="tel" id="phone_number" name="phone_number" pattern="[0-9]{11}" placeholder="e.g., 01234567890" required>
        <%if(request.getAttribute("phoneError")!=null){ %>
        <p><%=request.getAttribute("phoneError") %></p>
        <% } %>
      </div>

      <div class="form-group">
        <label for="email">Email Address</label>
        <input type="email" id="email" name="email" required maxlength="255">
        <%if(request.getAttribute("emailError")!=null){ %>
        <p><%=request.getAttribute("emailError") %></p>
        <% } if(request.getAttribute("emailExist")!=null){ %>
        <p><%=request.getAttribute("emailExist") %></p>
        <% } %>
      </div>

      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required minlength="6" maxlength="255">
        <%if(request.getAttribute("passwordError")!=null){ %>
        <p><%=request.getAttribute("passwordError") %></p>
        <% } %>
      </div>

      <button type="submit">Register</button>
      <p class="note">Already have an account? <a href="./login.html">Login</a></p>
    </form>
  </div>
</body>
</html>
