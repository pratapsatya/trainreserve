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
<form id="logoutForm" method="POST" action="${contextPath}/logout" >
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<a onclick="document.forms['logoutForm'].submit()">Logout</a>


<form method="POST" action="${contextPath}/ticketconfirmation" onsubmit="return validate()" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

<h3>Passenger Details</h3>

<div class="container">

<p id="visible"></p>
<input type="button" value="click here to see number of available tickets" onclick="show()">
     
 <p id="error"> </p>
 <input type="number" id="tn" name="nooftickets" placeholder="enter no of tickets........." min="1" max="4" onblur="valid()" required>
   
    <label for="fname" >First Name</label>
    <input type="text" id="fname1" name="firstname1" placeholder="Your name.." onfocus="getTrain()" required>

    <label for="lname">Last Name</label>
    <input type="text" id="lname1" name="lastname1"  placeholder="Your last name.." required>

    <label for="age">age</label>
    <input type="number" id="age1" name="age1" placeholder="Your age........." min="1" required>
    
    <select id="berth">
    <option value="volvo">upper berth</option>
    <option value="saab">lower berth</option>
    </select>
 
  
    <label for="fname" >First Name</label>
    <input type="text" id="fname2" name="firstname2" placeholder="Your name.."  >

    <label for="lname">Last Name</label>
    <input type="text" id="lname2" name="lastname2" placeholder="Your last name.." >

    <label for="age">age</label>
    <input type="number" id="age2" name="age2" placeholder="Your age........." min="1">
    
    <select id="berth">
    <option value="volvo">upper berth</option>
    <option value="saab">lower berth</option>
    </select>
 
  
    <label for="fname" >First Name</label>
    <input type="text" id="fname3" name="firstname3" placeholder="Your name.." >

    <label for="lname">Last Name</label>
    <input type="text" id="lname3" name="lastname3" placeholder="Your last name.." >

    <label for="age">age</label>
    <input type="number" id="age3" name="age3" placeholder="Your age........." min="1" >
    
    <select id="berth">
    <option value="volvo">upper berth</option>
    <option value="saab">lower berth</option>
    </select>
 
  
    <label for="fname" >First Name</label>
    <input type="text" id="fname4" name="firstname4" placeholder="Your name.." >

    <label for="lname">Last Name</label>
    <input type="text" id="lname4" name="lastname4" placeholder="Your last name.." >

    <label for="age">age</label>
    <input type="number" id="age4" name="age4" placeholder="Your age........." min="1" >
    
    <select id="berth">
    <option value="volvo">upper berth</option>
    <option value="saab">lower berth</option>
    </select>
    
    <select id="type">
    <option value="ac">ac-200</option>
    <option value="general">general-150</option>
    </select>
 
  
  
Card Details
<input type="text" id="accnum" name="accnum" placeholder="Your card number.." required>
<input type="number" id="csv" name="cvv" placeholder="cvv.." min="100" max="999" required>
Expiry:
<input type="month" id="expiry" name="expiry" placeholder="mm/yyyy" required>  
<input type="hidden" name="trainId" id="trainid">

<input type="hidden" name="trainname" id="trainname"> 
<input type="hidden" name="date" id="date">

<input type="submit" value="Confirm Booking" >
 
</div>
<p id="error1"></p>
<p id="error2"></p>
</form>
<script>
function show()
{
	document.getElementById("visible").innerHTML=localStorage.tickets;
}
function valid()
{
	var z=document.getElementById("tn").value;
	var q=localStorage.tickets;
	
	if(z > q)
		document.getElementById("error").innerHTML="choose tickets less than available";	

}
function getTrain()
{
	document.getElementById("trainid").value=localStorage.trainId;
}
function validate()
{
	
 	document.getElementById("date").value=localStorage.date;
	document.getElementById("trainname").value=localStorage.trainname;
	var f4=document.getElementById("fname4").value;
	var l4=document.getElementById("lname4").value;
	var a4=document.getElementById("age4").value;
	var f3=document.getElementById("fname3").value;
	var l3=document.getElementById("lname3").value;
	var a3=document.getElementById("age3").value;
	var f2=document.getElementById("fname2").value;
	var l2=document.getElementById("lname2").value;
	var a2=document.getElementById("age2").value;
	
	var z=document.getElementById("tn").value;
	var q=localStorage.tickets;
	
	
	if(z>=2)
	{
			if(f2==""||l2==""||a2=="")
			{
				console.log("enter second passenger details");
				document.getElementById("error1").innerHTML="enter second passenger details";
				return false;
			}
				 
	}
	if(z>=3)
	{
		
		if(f3==""||l3==""||a3=="")
			{
			console.log("enter third passenger details");
			document.getElementById("error1").innerHTML="enter third passenger details";
			return false;
			}
				
	}
	if(z==4)
	{
		
		if(f4==""||l4==""||a4=="")
			{
			console.log("enter fourth passenger details");
			document.getElementById("error1").innerHTML="enter fourth passenger details";
			return false;
			}
		
	} 
	
	
	if(z <= q)
	{
		return true;
	}
	else
	{
		
		
		document.getElementById("error").innerHTML="choose tickets less than available";
		return false;
	
	}
	
}
	
</script>
</body>
</html>