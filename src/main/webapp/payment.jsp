<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Details Page</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
input[type=text], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}
input[type=number], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}
input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
input[type=submit]:hover {
    background-color: #45a049;
}
.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</head>
<body>
<form id="logoutForm" method="POST" action="${contextPath}/logout" onsubmit="return myFunction()">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

<a onclick="document.forms['logoutForm'].submit()">Logout</a>
<form method="POST" action="${contextPath}/ticketconfirmation" >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<h3>Passenger Details</h3>

<div class="container">
<p id="visible"></p><input type="button" value="click here to see number of available tickets" onclick="show()">
     <p id="error"></p>
     <input type="number" id="tn" name="nooftickets" placeholder="enter no of tickets........." min="1" max="4" required>
    <label for="fname" >First Name</label>
    <input type="text" id="fname" name="firstname1" placeholder="Your name.." onfocus="myFunction()" required>

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastname1" placeholder="Your last name.." required>

    <label for="age">age</label>
    <input type="number" id="age" name="age1" placeholder="Your age........." min="1" required>
    <select id="berth">
    
  <option value="volvo">upper berth</option>
  <option value="saab">lower berth</option>
  
</select>
 
  
    <label for="fname" >First Name</label>
    <input type="text" id="fname" name="firstname2" placeholder="Your name.." onfocus="myFunction()" >

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastname2" placeholder="Your last name.." >

    <label for="age">age</label>
    <input type="number" id="age" name="age2" placeholder="Your age........." min="1">
    <select id="berth">
    
  <option value="volvo">upper berth</option>
  <option value="saab">lower berth</option>
  
</select>
 
  
    <label for="fname" >First Name</label>
    <input type="text" id="fname" name="firstname3" placeholder="Your name.." onfocus="myFunction()">

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastname3" placeholder="Your last name.." >

    <label for="age">age</label>
    <input type="number" id="age" name="age3" placeholder="Your age........." min="1" >
    <select id="berth">
    
  <option value="volvo">upper berth</option>
  <option value="saab">lower berth</option>
  
</select>
 
  
    <label for="fname" >First Name</label>
    <input type="text" id="fname" name="firstname4" placeholder="Your name.." onfocus="myFunction()">

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastname4" placeholder="Your last name.." >

    <label for="age">age</label>
    <input type="number" id="age" name="age4" placeholder="Your age........." min="1" >
    <select id="berth">
    
  <option value="volvo">upper berth</option>
  <option value="saab">lower berth</option>
  
</select>
 
  
  
  Card Details
  <input type="text" id="accnum" name="accnum" placeholder="Your card number.." required>
  <input type="number" id="csv" name="cvv" placeholder="cvv.." required>
  Expiry:
<input type="month" id="expiry" name="expiry" placeholder="mm/yyyy" required>  
<input type="hidden" name="trainId" id="trainid">
<input type="hidden" name="username" id="user"/>
<input type="hidden" name="trainname" id="trainname">
<input type="hidden" name="date" id="date">
    <input type="submit" value="Confirm Booking" >
 
</div>
<p id="error1"></p>
<p id="error2"></p>
</form>
<script>
function show(){
	document.getElementById("visible").innerHTML=localStorage.tickets;
	
}
function myFunction(){
	document.getElementById("trainid").value=localStorage.trainId;
	document.getElementById("user").value=localStorage.name;
	document.getElementById("date").value=localStorage.date;
	document.getElementById("trainname").value=localStorage.trainname;
	var z=document.getElementById("tn").value;
	document.getElementById("error1").innerHTML=z;
	if(z>localStorage.tickets)
		{document.getElementById("error").innerHTML="choose tickets less than available";
		return false;
		}
	if(z==4){
		var f4=document.getElementById("firstname4").value;
		var l4=document.getElementById("lastname4").value;
		var a4=document.getElementById("age4").value;
		if(f4==null||l4==null||a4==null)
			{
			document.getElementById("error1").innerHTML="enter fourth passenger details";
			}
		return false;
	}
	if(z==3){
		var f4=document.getElementById("firstname3").value;
		var l4=document.getElementById("lastname3").value;
		var a4=document.getElementById("age3").value;
		if(f4==null||l4==null||a4==null)
			{
			document.getElementById("error1").innerHTML="enter third passenger details";
			}
		return false;
	}
	if(z=="2"){
		var f4=document.getElementById("firstname2").value;
		var l4=document.getElementById("lastname2").value;
		var a4=document.getElementById("age2").value;
		if(f4==null||l4==null||a4==null)
			{
			document.getElementById("error1").innerHTML="enter second passenger details";
			return false;
			}
		document.getElementById("error2").innerHTML="2 passengers";
	}
	return true;
	}
	</script>
</body>
</html>