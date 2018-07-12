<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>see trains</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}
td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}
tr:nth-child(even) {
    background-color: #dddddd;
}
</style>

</head>
<body>

<%

String date=request.getParameter("date");
String y=date.substring(date.length()-2);
int x=Integer.parseInt(y);
x=x%7;
y=String.valueOf(x);
request.setAttribute("x",y);

%>
 <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>${contextPath} </h2>

<a onclick="document.forms['logoutForm'].submit()">Logout</a>
<form action="${contextPath}/payment"  onsubmit="return validate()">
<h2 align="center"><font><strong>List of Trains Available on</strong></font></h2>
<h2 name="date"><% out.print(date); %></h2>
<h2>Choose a train and continue</h2>
<table align="center" cellpadding="5" cellspacing="5" border="1" id="mytable">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>Train Id</b></td>
<td><b>Train Number</b></td>
<td><b>source</b></td>
<td><b>destiny</b></td>
<td><b>TrainName</b></td>
<td><b>Timings</b></td>
<td><b>Tickets available</b></td>
</tr>


 
</table>
<table id="mytable1">
<c:forEach items="${trains}" var="item" >
    <c:if test = "${item.day==x}">

<tr bgcolor="#DEB887" onclick="myFunc(this)">
<td>${item.trains_id}</td>
<td>${item.trainnumber} </td>
<td>${item.source} </td>
<td>${item.destination}</td>
<td>${item.trainname} </td>
<td>${item.timings} </td>
<td>${item.available}</td>

</tr>
</c:if>
</c:forEach>
</table>
<input type="submit" value="choose train and continue">
<p id="error"></p>
</form>

<script type="text/javascript">
function myFunc(x){
	
		var y=x.rowIndex;
		var z=document.getElementById("mytable1").rows[y].cells["0"].innerHTML;
		var p=document.getElementById("mytable1").rows[y].cells["6"].innerHTML;
		
		localStorage.trainId=z;
		localStorage.trainname=document.getElementById("mytable1").rows[y].cells["4"].innerHTML;
		localStorage.tickets=p;
		localStorage.valid=z;
		/* window.location.assign("/payment") */
}
function validate()
{
	if(localStorage.trainId!=localStorage.valid)
		{document.getElementById("error").innerHTML="select a train";
		return false;}
	localStorage.valid="-3";
	return true;
	}

</script>
</body>
</html>