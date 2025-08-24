<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Result</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f6f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .result-card {
        background: #ffffff;
        padding: 25px 35px;
        border-radius: 12px;
        box-shadow: 0px 6px 15px rgba(0,0,0,0.1);
        width: 400px;
        text-align: left;
    }

    .result-card h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #4facfe;
    }

    .result-card h3 {
        font-size: 16px;
        font-weight: normal;
        color: #333;
        background: #f9fafc;
        padding: 10px 15px;
        border-left: 4px solid #4facfe;
        margin: 8px 0;
        border-radius: 6px;
    }
</style>
</head>
<body>
    <div class="result-card">
        <h2>Form Submission Result</h2>
        <h3>Name: ${param.full_name}</h3>
        <h3>Password: ${param.password}</h3>
        <h3>Address: ${param.radio_address}</h3>
        <h3>Country: ${param.country}</h3>
    </div>
</body>
</html>
