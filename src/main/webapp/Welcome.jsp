<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
<title>Make Your Trip</title>
     <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
     

</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name}....Planning for a Vacataion....!Then why to wait...Book your Tickets | <a onclick="document.forms['logoutForm'].submit()">Logout</a>|<a href="${contextPath}/history">History</a></h2>
       <form method="POST" action="${contextPath}/trains" onsubmit="return myFunction()">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
         <table>
<tr>
<td>From:</td><td> 
<input list="from" id="source" name="source" onfocus="myFunction1()">
<datalist id="from">
<option value="hyderabad">
<option value="tirupathi">
<option value="vijayawada">
</datalist>

            </td>
            </tr>
            <tr>
<td>To:</td> <td><input list="to" id="destiny" name="destiny">
<datalist id="to">
<option value="hyderabad">
<option value="tirupathi">
<option value="vijayawada">
</datalist>

            </td>
</tr>
<tr>
<td><select id="trip">
  <option value="roundtrip">roundtrip</option>
  <option value="oneway">oneway</option>
</select></td>
</tr>
<tr>
<td><input type="date" id="myDate" name="date" value="2018-07-12" min="" max="" onfocus="myFunction1()">
</td>
</tr>

         </table> 
         <input type="submit" value="Search Trains">
</form>
    </c:if>

</div>


<p id="error2">
</p>
<!-- /container -->
<script>
    function myFunction1(){
        var d=new Date();
    var y=d.getFullYear()+"-0"+(d.getMonth()+1)+"-"+d.getDate();
     document.getElementById("myDate").min=y;
    var z=d.getFullYear()+"-0"+(d.getMonth()+1)+"-"+(d.getDate()+7);
    document.getElementById("myDate").max=z;
    document.getElementById("myDate").value=y;
    var g=document.getElementById("myDate").value;
    localStorage.date=g;
    var s=document.getElementById("trip");
    localStorage.trip=s.value;
    
    
    }
function myFunction() {
	  var s=document.getElementById("source").value;
	  var d=document.getElementById("destiny").value;
	  if(s==""||d=="")
		  {
		  document.getElementById("error2").innerHTML="source and destination cant be empty";
		  return false;
		  }
	  if(s===d)
	  { document.getElementById("error2").innerHTML="source and destination cant be same";
	  return false;}
	  
	  
}
                
    
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>



</body>
</html>


   
