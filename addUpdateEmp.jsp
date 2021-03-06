<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add or Update Employee</title>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>	    
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>  
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
	<form:form method="post" style="width:300px" modelAttribute="emp">
	
	<form:hidden path="id"/>
	
		<fieldset class="form-group">
		<label>Add Employee</label>
		</fieldset>
		
		<fieldset class="form-group">
		<form:label path="name">Name :</form:label>
		<form:input path="name" name="name" type="text" class="form-control" /> 
		<form:errors path="name" cssClass="text-warning"></form:errors> 
		</fieldset> 
		 

		 
		<fieldset class="form-group">	
		<form:label path="age">Age: </form:label>
		<form:input  path="age" name="age" type="text" class="form-control" />
		<form:errors path="age" cssClass="text-warning"></form:errors> 
		</fieldset>   
		 
		<fieldset class="form-group">	
		<form:label path="city">City: </form:label>	
		<form:select path="city" class="form-control">
		   <form:option value="" label="--- Select ---"/>
		   <form:options items="${cityList}" />
		</form:select>		
		<form:errors path="city" cssClass="text-warning"></form:errors>
		</fieldset>  
		 
		 <fieldset class="form-group">	
		<form:label path="salary">Salary: </form:label>
		<form:input path="salary"  name="salary" type="text" class="form-control" />
		<form:errors path="salary" cssClass="text-warning"></form:errors> 
		</fieldset> 
		
		 
	
		<button class="btn btn-success" type="submit">Submit</button>
		
	</form:form>
	</div>
	
	
	
	<div>
		<table>
			<thead></thead>
			<tbody></tbody>
		</table>
	
	</div>
	
	
	
</body>
</html>