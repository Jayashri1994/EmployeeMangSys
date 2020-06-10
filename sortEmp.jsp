<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sort Employee</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  

</head>
<body>
		<div class="container">
			<form method="post"  style="width:300px"  >
			<label>Sort Employee</label>
		        <select class="custom-select form-control" id="sortType" name="sortType">
		          <option selected>Select Sort Type...</option>
		          	<option value="idDESC">      Id in in DESCENDING    </option>
					<option value="nameASC">     Name in ASCENDING  </option>
					<option value="nameDESC">    Name in DESCENDING  </option>
					<option value="ageASC">      Age in ASCENDING    </option>
					<option value="ageDESC">     Age in DESCENDING   </option>
					<option value="cityASC">     City in ASCENDING   </option>
					<option value="cityDESC">    City in DESCENDING  </option>
					<option value="salaryASC">   Salary in ASCENDING </option>
					<option value="salaryDESC">  Salary in DESCENDING  </option>
					<option value="multiASC">   Multi-level in ASCENDING </option>
					<option value="multiDESC">  Multi-level in DESCENDING  </option>
		        </select> 
		        <br>
		        <br>
		        <br>
		        <button class="btn btn-success" type="submit">Submit</button>
		          
		    </form>
		 </div>   
</body>
</html>