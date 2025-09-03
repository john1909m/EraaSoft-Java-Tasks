<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Edit Item</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f4f6f8;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    .form-container {
      background: #fff;
      padding: 20px 30px;
      border-radius: 12px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
      width: 350px;
    }

    .form-container h2 {
      text-align: center;
      color: #333;
      margin-bottom: 20px;
    }

    label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
      color: #555;
    }

    input {
      width: 100%;
      padding: 8px 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 8px;
      font-size: 14px;
    }

    button {
      width: 100%;
      padding: 10px;
      background: #007bff;
      color: white;
      font-size: 16px;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: background 0.3s;
    }

    button:hover {
      background: #0056b3;
    }
  </style>
</head>
<body>

  <div class="form-container">
    <h2>Edit Item</h2>
    <form action="/Item_Shop/ItemController?action=editItem" method="post">
      <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
      <label for="name">Name</label>
      <input type="text" id="name" name="name" value="<%= request.getParameter("name") %>" required>

      <label for="price">Price</label>
      <input type="number" id="price" name="price" step="0.01" value="<%= request.getParameter("price") %>" required>

      <label for="totalNumber">Total Number</label>
      <input type="number" id="totalNumber" name="totalNumber" value="<%= request.getParameter("totalNumber") %>" required>

      <button type="submit">Update Item</button>
    </form>
  </div>

</body>
</html>
