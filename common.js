function validate(){
	alert("inside validate");
	var inputValue = document.inputForm.age.value;
	alert("age>> "+age);
	if(isNaN(inputValue)){
		alert("Inside if");
		document.getElementById("numloc").innerHTML = "Enter Numeric value only";
		return false;
	}
	else{
		return true;
	}
}