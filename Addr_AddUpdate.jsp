<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add or Update Address</title>
			<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
		    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
		    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form:form method="post" style="width:300px" modelAttribute="address" >
		<form:hidden path="aid"/>
		
			<fieldset class="form-group">
			<label>Add or Update Employee Address Details</label>
			</fieldset>
		
			<fieldset class="form-group">
			<form:label path="employee">Employee ID</form:label>
			<form:input path="employee" class="form-control" name="employee" pattern="\d*" title="Please enter Numeric Value."></form:input>
			<form:errors path="employee" cssClass="text-warning"></form:errors>
			</fieldset>
		
		
			<fieldset class="form-group">
			<form:label path="addressType">Address Type</form:label>
			<form:select path="addressType" class="custom-select form-control" name= "addressType" >
				<form:option value="" label="Select Address Type ..."></form:option>
				<form:options items="${addressType}"></form:options>
			</form:select>
			<form:errors path="addressType" cssClass="text-warning"></form:errors>
			</fieldset>
			
			<fieldset class="form-group">
			<form:label path="addressLine">Address Line</form:label>
			<form:input path="addressLine" class="form-control" type="text" name="addressLine"></form:input>
			<form:errors path="addressLine" cssClass="text-warning"></form:errors>
			</fieldset>
			
			<fieldset class="form-group">
			<form:label path="country">Country</form:label>
			<form:select path="country" name="country" class="form-control" onchange="/allState">
				<form:option value="" label="-- Select ---"></form:option>
				<form:options items="${countryList}"></form:options>
			</form:select>
			<form:errors path="country" cssClass="text-warning"></form:errors>
			</fieldset>
			
			<fieldset class="form-group">
			<form:label path="state">State</form:label>
			<form:select path="state" name="state" class="form-control">
				<form:option value="" label="-- Select ---"></form:option>
				<form:options items="${stateList }"></form:options>
			</form:select>
			<form:errors path="state" cssClass="text-warning"></form:errors>
			</fieldset>
			
			<fieldset class="form-group">
			<form:label path="city">City</form:label>
			<form:select path="city" name="city" class="form-control">
				<form:option value="" label="-- Select ---"></form:option>
				<form:options items="${cityList}"></form:options>
			</form:select>
			<form:errors path="city" cssClass="text-warning"></form:errors>
			</fieldset>
			
			<fieldset class="form-group">
			<form:label path="postalCode">Postal Code</form:label>
			<form:input path="postalCode" name="postalCode" class="form-control" pattern="\d*" title="Please enter Numeric Value."></form:input>
			<form:errors path="postalCode" cssClass="text-warning"></form:errors>
			</fieldset>
		
			<button class="btn btn-success" type="submit">Submit</button>
		
		</form:form>
	</div>
</body>
</html>