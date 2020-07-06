<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style= "margin: 2em">
<head>
<meta charset="ISO-8859-1">
<title>Query Property expressions</title>

	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	
</head>
<body>
		<div class="col-xs-6">
			<form method="post" class="well well-lg" id="form1">
				<select class="custom-select form-control" name="queryType" required>
		          <option value="">Select Equality Condition ...</option>
		          <option value="Equal">Equal</option>
		          <option value="Is">Is</option>
		          <option value="Equals">Equals</option>
		          <option value="IsNot">	IsNot	</option>
				  <option value="IsNull">	IsNull	</option>
				  <option value="IsNotNull">	IsNotNull	</option>
				  <option value="Count">	Count	</option>
		        </select> 
				<fieldset class="form-group">
					<label>Name</label>
					<input class="form-control" name="name" required pattern="[A-Za-z]{1,}" title="Please enter only Characters.">				
				</fieldset>
				<button class="btn btn-success">Submit</button>
			</form>
		</div>
		<div class="col-xs-6">
			<form method="post" class="well well-lg" id="form2">
			    <select class="custom-select form-control" name="queryType" required>
		          <option value="">Select Sort Condition...</option>
		          <option value="Sort">	Sort	</option>
		          <option value="Asc">	Asc	</option>
				  <option value="Desc">	Desc	</option>			  
				  <option value="First3">	First3	</option>
		          <option value="Top3">	Top3	</option>
				  <option value="Distinct">	Distinct	</option>
		          <option value="First3ByCityOrderByCityAsc">	First3ByCityOrderByCityAsc	</option>
				  <option value="Top3ByCityOrderByCityDesc">	Top3ByCityOrderByCityDesc	</option>
				  
		        </select> 
				<fieldset class="form-group">
					<label>City</label>
					<input class="form-control" name="city" required pattern="[A-Za-z]{1,}" title="Please enter only Characters.">				
				</fieldset>
				<button class="btn btn-success">Submit</button>
			</form>
		</div>
	
		<div class="col-xs-6">
			<form method="post" class="well well-lg" id="form3">
				<select class="custom-select form-control" name="queryType" required>
		          <option value="">Select Comparison Condition...</option>
		          <option value="LessThan">	LessThan	</option>
		          <option value="LessThanEqual">	LessThanEqual	</option>
		           <option value="GreaterThan">	GreaterThan	</option>
		          <option value="GreaterThanEqual">	GreaterThanEqual	</option>
		        </select> 
				<fieldset class="form-group">
					<label>Age</label>
					<input class="form-control" name="age" required pattern="\d*" title="Please enter Numeric Value.">				
				</fieldset>
				<button class="btn btn-success">Submit</button>
			</form>
				
				
			<form method="post" class="well well-lg" id="form8">
				<select class="custom-select form-control" name="queryType" required>
		          <option value="">Select Comparison Condition...</option>
				  <option value="Between">	Between	</option>
				  <!-- <option value="AgeIn">	AgeIn	</option> -->
		        </select>
				<fieldset class="form-group">
					<label>StartAge</label>
					<input class="form-control" name="startAge" required pattern="\d*" title="Please enter Numeric Value.">				
				</fieldset>
				<fieldset class="form-group">
					<label>EndAge</label>
					<input class="form-control" name="endAge" required pattern="\d*" title="Please enter Numeric Value.">				
				</fieldset>
				
				<!-- <fieldset class="form-group">
					<label>List of age</label>
					<input class="form-control" name="ageList" required>				
				</fieldset> -->
				
				<button class="btn btn-success">Submit</button>
			</form>
		</div>
			<div class="col-xs-6">
			<form method="post" class="well well-lg" id="form7">
				<select class="custom-select form-control" name="queryType" required>
		          <option value="">Select Similarity Condition...</option>
		          <option value="Prefix">	Name Prefix	</option>
		          <option value="Suffix">	Name Suffix	</option>
				  <option value="Infix">	Name Infix	</option>
				  <option value="Like">	Name Like	</option>
		        </select> 
				<fieldset class="form-group">
					<label>Pattern</label>
					<input class="form-control" name="pattern" required>				
				</fieldset>
				<button class="btn btn-success">Submit</button>
			</form>
		</div>
		
		<div class="col-xs-6">
			<form method="post" class="well well-lg" id="form5">
				<select class="custom-select form-control" name="queryType" required>
		          <option value="">Select Multiple Condition...</option>
		          <option value="AND">	AND	</option>
		          <option value="OR">	OR	</option>
		        </select> 
				<fieldset class="form-group">
					<label>Name</label>
					<input class="form-control" name="name" required pattern="[A-Za-z]{2,}" title="Please enter only characters.">				
				</fieldset>
				<fieldset class="form-group">
					<label>City</label>
					<input class="form-control" name="city" required pattern="[A-Za-z]{1,}" title="Please enter only Characters.">				
				</fieldset>
				<button class="btn btn-success">Submit</button>
			</form>
		</div>
		
			<div class="col-xs-6">
			<form method="post" class="well well-lg" id="form6">
				<select class="custom-select form-control" name="queryType" required>
		          <option value="">Select Multiple Condition...</option>
		          <option value="AND_OR">	AND_OR	</option>
		          <option value="OR_AND">	OR_AND	</option>
		        </select> 
				<fieldset class="form-group">
					<label>Name</label>
					<input class="form-control" name="name" required pattern="[A-Za-z]{1,}" title="Please enter only Characters.">				
				</fieldset>
				<fieldset class="form-group">
					<label>City</label>
					<input class="form-control" name="city" required pattern="[A-Za-z]{1,}" title="Please enter only Characters.">				
				</fieldset>
				<fieldset class="form-group">
					<label>Age</label>
					<input class="form-control" name="age" required pattern="\d*" title="Please enter Numeric Value.">				
				</fieldset>
				<button class="btn btn-success">Submit</button>
			</form>
		</div>

		<div class="row">
		<div class="col-xs-6">
			<form method="post" class="well well-lg" id="form4">
				<select class="custom-select form-control" name="queryType" required>
		          <option value="">Select Aggregate Condition ...</option>
		          <option value="Min">Min</option>
		          <option value="Max">Max</option>
		          <option value="Avg">	Avg	</option>
		        </select> 
				<fieldset class="form-group">
					<label>Salary</label>
					<input class="form-control" name="salary" required pattern="\d*" title="Please enter Numeric Value."> 				
				</fieldset>
				<button class="btn btn-success">Submit</button>
			</form>
		</div>

	</div>
</body>
</html>