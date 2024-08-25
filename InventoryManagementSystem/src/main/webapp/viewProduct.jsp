<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.montran.model.Product"%>
<%@ page import="com.montran.services.ProductDao"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
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
        max-width: 1000px;
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
	<h1>Product details</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>QUANTITY</th>
			<th>PRICE</th>
			<th>MAN-DATE</th>
			<th>EXP-DATE</th>
			<th>Category</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
		List<Product> list = ProductDao.getAllProducts();
		for (Product p : list) {
		%>
		<tr>
			<td><%=p.getProduct_id()%></td>
			<td><%=p.getProduct_name()%></td>
			<td><%=p.getQuantity()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getMan_date()%></td>
			<td><%=p.getExp_date()%></td>
			<td><%=p.getCtg().getCategory_name()%></td>
			<td><a href='updateProduct.jsp?id=<%=p.getProduct_id()%>'>edit</a></td>
			<td><a href='del?id=<%=p.getProduct_id()%>'>delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
	
	<%@ include file="footer.jsp" %>
</body>
</html>