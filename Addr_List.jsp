<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
		<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<title>Employee Address Details</title>
</head>
<body>
	
	<div class="container">
		<form action="" method="post">
	
			Enter employee ID: <input type="text" name="empid" required>
			<button type="submit" class="btn btn-success">Submit</button>
		</form>	
	</div>
     
     <div class="container">
     <table class="table table-striped">
     	<caption>Address Details</caption>
	     <thead>
	     	<tr>
	     		<th>AID</th>
	     		<th>Address Type</th>
	     		<th>Address Line</th>
	     		<th>City</th>
	     		<th>State</th>
	     		<th>Country</th>
	     		<th>Postal Code</th>
	     		<th>Employee ID</th>
	     		<th>Update</th>
	     		<th><a type="button" class="btn btn-warning" href="/Address/deleteAllAddr">DeleteAll</a></th>
	     	</tr>
	     </thead>
	     <tbody>
	     <c:forEach items="${addressList}" var="addressList">
	     	<tr>
	     		<td>${addressList.aid}</td>
	     		<td>${addressList.addressType}</td>
	     		<td>${addressList.addressLine}</td>
	     		<td>${addressList.city}</td>
	     		<td>${addressList.state}</td>
	     		<td>${addressList.country}</td>
	     		<td>${addressList.postalCode}</td>
	     		<td>${addressList.postalCode}</td> <!-- empid -->
	     		<td><a type="button"  class="btn btn-success" href="/Address/updateAddr?aid=${addressList.aid }">Update</a></td>
	     		<td><a type="button" class="btn btn-success" href="/Address/deleteAddr?aid=${addressList.aid }">Delete</a></td>
	     	</tr>
	     </c:forEach>
	     </tbody>
     </table>     
     </div>
     
     
</body>
</html>