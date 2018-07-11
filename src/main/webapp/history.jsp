<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<table align="center" cellpadding="5" cellspacing="5" border="1" id="mytable">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>user</b></td>
<td><b>Train Name</b></td>
<td><b>No of tickets booked</b></td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM tickets where uname='lahari'";


resultSet = statement.executeQuery(sql);

while(resultSet.next()){
	int i=0;
%>
<tr bgcolor="#DEB887" onclick="myFunc(this)">
<td><%=resultSet.getString("uname") %></td>
<td><%=resultSet.getString("trainname") %></td>
<td><%=resultSet.getString("tickets") %></td>


</tr>

<% 
}

} catch (Exception e) {  
e.printStackTrace();
}
%>
</table> 
</body>
</html>