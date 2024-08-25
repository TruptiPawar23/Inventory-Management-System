<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.montran.model.*" %>
    <%@page import="com.montran.services.*" %>
       <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin requests</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        min-height: 100vh;
    }

    h1 {
        color: #333;
        margin-bottom: 20px;
        font-size: 24px;
    }

    table {
        width: 80%;
        max-width: 1000px;
        border-collapse: collapse;
        background-color: white;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        overflow: hidden;
        margin-bottom: 20px;
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

    button {
        padding: 8px 12px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button[name="action"][value="reject"] {
        background-color: #f44336;
    }

    button:hover {
        background-color: #45a049;
    }

    button[name="action"][value="reject"]:hover {
        background-color: #d32f2f;
    }

    form {
        display: flex;
        gap: 10px;
    }
</style>
</head>
<body>
<%@ include file="header.jsp"%>
<h1> Pending Requests </h1>
<table border="1"> 
<thead>
<tr>
<th>ITEM_ID</th>
<th>NAME</th>
<th>QUANTITY</th>
<th>ACCEPT/REJECT</th>
</tr>
</thead>
<tbody>
	<%
	List<ConsumptionRequest> req=(List<ConsumptionRequest>)request.getAttribute("pendingRequest");
	
	%>
	<%
	for(ConsumptionRequest cr:req){
		int id =cr.getItemid();
		List<Product> list = ProductDao.getAllProducts();
	%>
<tr>
<td>
<%=cr.getItemid() %>
</td>
<td>
<%=cr.getName() %>
</td>
<td>
<%for (Product p : list) {
if(cr.getItemid() == p.getProduct_id()){%>
<%= p.getQuantity()%>
<%} }%>
</td>
<td>
<form action="ApproveReject">
<input type="hidden" name="requestId" value="<%=cr.getId() %>">

<button type="submit" name="action" value="accept">Accept</button>
<button type="submit" name="action" value="reject">Reject</button>
</form>
</td>
</tr>
<%} %>
</tbody>

</table>
<%@ include file="footer.jsp" %>
</body>
</html>