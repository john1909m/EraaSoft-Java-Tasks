<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Styled JSP Example</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f9;
        margin: 0;
        padding: 20px;
        text-align: center;
    }
    h1 {
        color: #ffffff;
        background: indigo;
        padding: 15px 25px;
        border-radius: 12px;
        box-shadow: 0px 4px 8px rgba(0,0,0,0.2);
        display: inline-block;
    }
</style>
</head>
<body>
		
    <%! 
        public String concatanation(int id,String name){
            return "<h1>id: "+id+" → "+ name+"</h1>";
        }
    %>

    <%
        int id = 2;
        String name = "john";
        out.println(concatanation(id,name));
    %>

</body>
</html>
