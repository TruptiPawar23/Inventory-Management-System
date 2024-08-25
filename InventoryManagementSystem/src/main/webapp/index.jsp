<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<style>

 body{
	font-family:Times New Roman,serif;
	display:flex;
	justify-content:center;
	align-items:center;
	height:100vh;
	background-color:#f4f4f4;
	margin:0;
	padding:0;
}

.container{
	background-color: #fff;
	padding: 30px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius:10px;
	text-align:center;
	
}

h1 {
	color: #333;
}
.button{

background-color:#007bff;
color:white;
padding:15px 25px;
margin:10px;
border:none;
border-radius:5px;
cursor:pointer;
font-size:16px;

}

.button:hover{
	background-color: #0056b3;
	

}
a{

color:#007bff;
text-decoration:none;
font-size:16px;

}
a:hover{
text-decoration:underline;

}
</style>

</head>
<body>

 <div class ="container">
      <h1>Inventory Management System</h1> 
      
      <form action ="login.jsp">
      <button type="submit" class="button" name="role" value="Admin"> Login as Admin</button>
      <button type="submit" class="button" name="role" value="User"> Login as User</button>
     
      </form><br><br>
      
      <a href="register.jsp">Register as a New User</a>
      </div>
</body>
</html>