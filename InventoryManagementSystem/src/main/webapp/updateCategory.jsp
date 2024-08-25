<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.montran.model.*"%>
<%@ page import="com.montran.services.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Category</title>
<style>
body {
	font-family:Times New Roman,serif;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	text-align: center;
	background-color: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 400px;
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

input[type="text"], input[type="file"] {
	width: 93%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.button {
	width: 100%;
	padding: 10px 20px;
	background-color: #28a745;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

.button:hover {
	background-color: #218838;
}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	Category c = CategoryDao.getCategoryByID(id);
	%>
	<div class="container">
	<h2>Update New Category</h2>
	<form action="updateCategory" enctype="multipart/form-data">
		<input type="hidden" id="category_id" name="category_id" value='<%= c.getCategory_id()%>'>
		
		<label for="category_name">Category Name:</label>
		<input type="text" id="category_name" name="category_name" value='<%= c.getCategory_name()%>'>
		
		<button type="submit" class="button">Update Category</button>
	</form>
	</div>
	 <%@ include file="footer.jsp" %>
</body>
</html>