<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.montran.services.CategoryDao" %>
	<%@ page import="com.montran.model.Category" %>
	<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>

<style>
body {
	font-family: Arial, sans-serif;
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
	text-align: center;
}

label {
	font-size: 14px;
	color: #555;
	margin-bottom: 5px;
	display: block;
	text-align: left;
}

input[type="text"], input[type="number"], input[type="date"] {
	width: 93%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
}
select {
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
</head >
 <body>
 <%@ include file="header.jsp"%>
 <br><br><br>
 <div class="container">
 
 <h2>Add New Product</h2>
	<form action="pcontroller" method="post">
		<label for="product_id">Product ID:</label>
		<input type="text" id="product_id" name="product_id" >
		
		<label for="product_name">Product Name:</label>
		<input type="text" id="product_name" name="product_name">
		
		<label for="quantity">Quantity:</label>
		<input type="number" id="quantity" name="quantity">
		
		<label for="price">Price:</label>
		<input type="number" id="price" name="price">
		
		<label for="man_date">Manufacture Date::</label>
		<input type="date" id="man_date" name="man_date">
		
		<label for="exp_date">Expiry Date:</label>
		<input type="date" id="exp_date" name="exp_date">
		
		<label for="category">Category:</label>
		<select id="category" name="category">
			<% List<Category> ctg = CategoryDao.getCategory();
				for(Category i: ctg){%>
					<option value="<%= i.getCategory_name()%>"><%= i.getCategory_name()%></option>
				<%}
			%>
		</select>
		<button type="submit" class="button">Add Product</button>
		
 </form>
 </div>
 <%@ include file="footer.jsp" %>
  </body > 
  
  </html >