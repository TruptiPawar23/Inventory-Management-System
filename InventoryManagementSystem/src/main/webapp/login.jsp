<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="javax.servlet.http.HttpServletRequest" %>
<%
    String role = request.getParameter("role");
%>

<!DOCTYPE html>
<html>
<head>
    <title><%= role %> Login</title>
    <style>
        body {
            font-family:Times New Roman,serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        label {
            font-size: 14px;
            color: #555;
            margin-bottom: 5px;
            display: block;
            text-align: left;
        }
        input[type="text"], input[type="password"] {
            width: 93%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .button {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .button:hover {
            background-color: #218838;
        }
    </style>
    <script>
    function showAlert(){
    alert("Invalid credentials.Please try again.");
    }
    </script>
</head>
<body>
    <div class="container">
        <h2><%= role %> Login</h2>
        <form action="Login" method="post">
            <input type="hidden" name="role" value="<%= role %>">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <button type="submit" class="button">Login</button>
        </form>
        <%
        if("true".equals(request.getAttribute("fail"))){
        %>
        <script>showAlert();</script>
        <%
        }
        %>
    </div>
</body>
</html>