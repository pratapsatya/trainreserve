<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view ticket</title>
</head>
<body>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "db_example";
String userId = "lahari";
String password = "Satya977";
 String num=request.getParameter("trainId"); 
String fname1=request.getParameter("firstname1");
String lname1=request.getParameter("lastname1");
String age1=request.getParameter("age1");
String fname2=request.getParameter("firstname2");
String lname2=request.getParameter("lastname2");
String age2=request.getParameter("age2");
String fname3=request.getParameter("firstname3");
String lname3=request.getParameter("lastname3");
String age3=request.getParameter("age3");
String fname4=request.getParameter("firstname4");
String lname4=request.getParameter("lastname4");
String age4=request.getParameter("age4");
String tno=request.getParameter("nooftickets");
String uname=request.getParameter("username");
String date=request.getParameter("date");
int g=0;
int id=Integer.parseInt(num);
int count=Integer.parseInt(tno);
boolean p;
try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

<a onclick="document.forms['logoutForm'].submit()">Logout</a>
<h3></h3>
<div align="center">Passenger Details:</div>
<table align="center" cellpadding="5" cellspacing="5" border="0" id="mytable1">
<tr><td>firstname</td><td>lastname</td><td>age<td></td></tr>
<tr><td><%=fname1%></td><td><%=lname1%></td><td><%=age1%><td></td></tr>
<tr><td><%=fname2%></td><td><%=lname2%></td><td><%=age2%><td></td></tr>
<tr><td><%=fname3%></td><td><%=lname3%></td><td><%=age3%><td></td></tr>
<tr><td><%=fname4%></td><td><%=lname4%></td><td><%=age4%><td></td></tr>
</table>
<div align="center">Train Details</div>
<table align="center" cellpadding="5" cellspacing="5" border="1" id="mytable">

<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM trains where trains_id="+id;
String sql1="UPDATE trains SET available = available-"+count+" where trains_id="+id;
p=statement.execute(sql1);
resultSet = statement.executeQuery(sql);


while(resultSet.next()){
	
%>

<tr><td>Train Number:</td><td><%=resultSet.getString("trainnumber") %></td></tr>
<tr><td>Source:</td><td><%=resultSet.getString("source") %></td></tr>
<tr><td>Destination:</td><td><%=resultSet.getString("destination") %></td></tr>
<tr><td>Train Name:</td><td><%=resultSet.getString("trainname") %></td></tr>
<tr><td>Timings:</td><td><%=resultSet.getString("timings") %></td></tr>
<tr><td>Seat Number:</td><td>10</td></tr>
<% 
}

} catch (Exception e) {  
e.printStackTrace();
}
%>
<tr><td>date:</td><td><%=date%></td></tr>
</table>

<br>
<br>
<%-- <a href="${contextPath}/welcome">Book a return ticket</a> --%>
<div id="trapParent"><a id="trap" href="${contextPath}/welcome">Book a return ticket</a></div>
<script type="text/javascript">
function myFun(){
	if(localStorage.trip=="roundtrip")
	{var parent = document.getElementById('trapParent');
	var child = document.getElementById('trap');
	parent.removeChild(child);}
	
}</script>
</body>
</html>