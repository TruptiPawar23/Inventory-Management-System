<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.montran.model.Category"%>
<%@ page import="com.montran.services.CategoryDao"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }

    h1 {
        color: #333;
        text-align: center;
        margin-bottom: 20px;
        font-size: 24px;
    }

    table {
        width: 100%;
        max-width: 800px;
        margin: 0 auto;
        border-collapse: collapse;
        background-color: white;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        overflow: hidden;
    }

    th, td {
        padding: 15px;
        text-align: left;
    }

    th {
        background-color: #4CAF50;
        color: white;
        font-weight: bold;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #e0e0e0;
    }

    td {
        border-bottom: 1px solid #ddd;
    }

    a {
        color: #4CAF50;
        text-decoration: none;
        font-weight: bold;
        transition: color 0.3s ease;
    }

    a:hover {
        color: #45a049;
    }

    td a {
        margin-right: 10px;
    }

    table {
        margin-bottom: 20px;
    }
</style>
</head>
<body>
<%@ include file="header.jsp"%>
<br><br><br>
	<h1>Category details</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>UPDATE</th>
			<th>DELETE</th>
		</tr>
		<%
		List<Category> list = CategoryDao.getCategory();
		for (Category c : list) {
		%>
		<tr>
			<td><%=c.getCategory_id()%></td>
			<td><%=c.getCategory_name()%></td>
			<td><a href='updateCategory.jsp?id=<%=c.getCategory_id()%>'>edit</a></td>
			<td><a href='deleteCategory?id=<%=c.getCategory_id()%>'>delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<%@ include file="footer.jsp" %>
</body>
</html>