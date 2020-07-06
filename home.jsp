<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>	    
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>  
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container">  
  <h2>Employee Management System</h2>  
  <ul class="list-group" style="width:300px">  
		<li class="list-group-item"><a href="/list">List of Employee</a></li>
		<li class="list-group-item"><a href="/add">Add Employee</a></li>
		<li class="list-group-item"><a href="/filter">Filter Employee</a></li>
		<li class="list-group-item"><a href="/sort">Sort Employee</a></li>
		<li class="list-group-item"><a href="/query">Query Property expressions</a></li>
	</ul>	
</div> 

<div class="container">
	<h4>Address Details</h4>
	<ul class="list-group" style="width:300px">
		<li class="list-group-item"><a href="/Address/addUpdateAddr">Add Address</a></li>
		<!-- <li class="list-group-item"><a href="/Address/deleteAddr">Delete Address</a></li> -->
		<li class="list-group-item"><a href="/Address/viewAddr">View Address</a></li>
	</ul>
</div>


</body>
</html>