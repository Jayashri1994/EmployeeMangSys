<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>List all Employees</title>
</head>
<body>

		<c:choose>  		
		    <c:when test="${filterList.size()  >= 0 }">  
					<c:set var="Emplist" scope="session" value="${filterList}"/> 
		    </c:when>  
		    <c:when test="${sortList.size()  >= 0}">
				<c:set var="Emplist" scope="session" value="${sortList}"/>  
		    </c:when>  
		    <c:otherwise>    
			   <c:set var="Emplist" scope="session" value="${Emplist}"/>  
		    </c:otherwise> 
		</c:choose> 
	
	<div class="container">
		<table class="table table-striped">
			<caption>List of all Employees</caption>
			<thead>
				<tr>
					<th>Id</th>					
					<th>Name</th>
					<th>Age</th>
					<th>City</th>
					<th>Salary</th>
					<th></th>
					<th><a type="button" class="btn btn-warning" href="/deleteAll">Delete All</a></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Emplist}" var="Emplist">
					<tr>
						<td>${Emplist.id}</td>
						<td>${Emplist.name}</td>
						<td>${Emplist.age}</td>
						<td>${Emplist.city}</td>
						<td>${Emplist.salary}</td>
						<td><a type="button" class="btn btn-success" href="/update?id=${Emplist.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="/delete?id=${Emplist.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	
</body>
</html>