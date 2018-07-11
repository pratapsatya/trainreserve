<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
String source=request.getParameter("source");
String destiny=request.getParameter("destiny");
String date=request.getParameter("date");
String y=date.substring(date.length()-2);
int x=Integer.parseInt(y);
x=x%7;
y=String.valueOf(x);
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
<h2 align="center"><font><strong>List of Trains Available on</strong></font></h2>
<h2 name="date"><% out.print(date); %></h2>
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

<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM trains where source='"+source+"' and destination='"+destiny+"' and day='"+y+"'";


resultSet = statement.executeQuery(sql);

while(resultSet.next()){
	int i=0;
%>
<tr bgcolor="#DEB887" onclick="myFunc(this)">
<td><%=resultSet.getString("trains_id") %></td>
<td><%=resultSet.getString("trainnumber") %></td>
<td><%=resultSet.getString("source") %></td>
<td><%=resultSet.getString("destination") %></td>
<td><%=resultSet.getString("trainname") %></td>
<td><%=resultSet.getString("timings") %></td>
<td><%=resultSet.getString("available") %></td>

</tr>

<% 
}

} catch (Exception e) {  
e.printStackTrace();
}
%>
</table> 

<script type="text/javascript">
function myFunc(x){
	
		var y=x.rowIndex;
		var z=document.getElementById("mytable").rows[y].cells["0"].innerHTML;
		var p=document.getElementById("mytable").rows[y].cells["6"].innerHTML;
		
		localStorage.trainId=z;
		localStorage.trainname=document.getElementById("mytable").rows[y].cells["4"].innerHTML;
		localStorage.tickets=p;
		window.location.assign("/payment")
}

</script>
</body>
</html>