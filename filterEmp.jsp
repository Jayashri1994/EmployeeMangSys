<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filter Employee</title>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
<script type="text/javascript"></script>
</head>
<body>
<br>
	<div class="container">
	<form:form method="post" style="width:300px" modelAttribute="emp">
			<label>Age and Salary</label>
		        <select class="custom-select form-control" id="filter" name="filter" required>
		          <option value="">Select Filter Type...</option>
		          <option value="Greater">	Greater	</option>
		          <option value="Equals">	Equals	</option>
				  <option value="Lesser">	Lesser	</option>
		        </select>   
		<br>
		<br>
		<br>
		
		
		<fieldset class="form-group">
		<form:label path ="age">Age :</form:label>
		<form:input path ="age" name="age" type="text" class="form-control" />
		<form:errors path ="age" cssClass="text-warning"></form:errors>
		</fieldset>
		
		<fieldset class="form-group">
		<form:label path="city">City: </form:label>
		<form:select path="city" class="form-control">
			<form:option value="" label="--- Select ---"></form:option>
			<form:options items="${cityList}"></form:options>
		</form:select>		
		<form:errors path="city" cssClass="text-warning"></form:errors>
		</fieldset>
		
		<fieldset class="form-group">
		<form:label path="salary">Salary:</form:label>
		<form:input path="salary" name="salary" type="text" class="form-control"/>					
		<form:errors path="salary" cssClass="text-warning"></form:errors>
		</fieldset>
		<button class="btn btn-success" type="submit">Submit</button>
	</form:form>
	</div>

</body>
</html>