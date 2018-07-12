<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
<td><b>date</b></td>
</tr>
<!-- </table> 
 <table align="center" cellpadding="5" cellspacing="5" border="1"> -->
<c:forEach items="${list}" var="item" >
    
<tr bgcolor="#DEB887" >
<td>${item.uname}</td>
<td>${item.trainname} </td>
<td>${item.tickets} </td>
<td>${item.date} </td>

</tr>

</c:forEach>
</table>
</body>
</html>