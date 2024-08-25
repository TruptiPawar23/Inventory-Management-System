<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<style>
body,html{
margin:0;
padding:0;
font-family:Times New Roman,serif;
height:100%;
display:flex;
flex-direction:column;
}
.navbar{
background-color:#333333;
padding:4px 15px;
position:fixed;
top:0;
width:100%;
display:flex;
justify-content:space-between;
align-items:center;
z-index:1000;
box-sizing:border-box;
}

.navbar img{
height:40px;

}

.navbar h2{
color:white;
margin:0;
}
.navbar .menu-icon{
font-size:24px;
color:white;
cursor:pointer;
}
.navbar .search-bar{
display:flex;
align-items:center;
margin-left:auto;
margin-right:20px;
}
.navbar input[type="text"]{
padding:5px;
            border: none;
            border-radius: 5px;
            font-size:16px;
            margin-right:10px;
}

.navbar input[type="submit"]{

            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            background-color:#4CAF50;
            color:white;
            cursor:pointer;
}


.sidebar{
height:100%;
width:0;
position:fixed;
z-index:1000;
top:0;
left:0;
background-color:#111;
overflow-x:hidden;
transition:0.5s;
padding-top:60px;
box-sizing:border-box;
}
.sidebar a{
display:block;
color:white;
padding:10px 15px;
text-decoration:none;
font-size:18px;
transition:0.3s;
}
.sidebar a:hover{
background-color:#575757;
}

.sidebar .close-btn{
position:absoulte;
top:10px;
right:25px;
font-size:36px;
}

</style>
</head>
<body>
<div class="navbar">

<span class="menu-icon" onclick="openSidebar()">&#9776;</span>

<img alt="Inventory logo" src=" logo.png">


<div class="search-bar">
        <form action="searchItems.jsp" method="get">
            <input type="text"  name="query" placeholder="Search Items..." required>
<input type="submit" value="Search">
</form>
</div>
</div>
<div id="mySidebar" class="sidebar"> 
<a href="javascript:void(0)" class="close-btn" onclick="closeSidebar()">&times;</a>
<a href="adminHome.jsp" >Admin Home</a>
<a href="addCategories.jsp">Add Categories</a>
<a href="viewCategories.jsp" >View Categories</a>
<a href="addProduct.jsp">Add Product</a>
<a href="viewProduct.jsp">View Product</a>
<a href="RequestForward">Approve</a>
<a href="index.jsp">Logout</a>
</div>
<script>
function openSidebar(){
	document.getElementById("mySidebar").style.width="250px";
	
}
function closeSidebar(){
	document.getElementById("mySidebar").style.width="0";
	
}
</script>
</body>
</html>