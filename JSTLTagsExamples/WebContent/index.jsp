<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,java.io.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP page for accessing database</title>
</head>
<body>
	<h1>Here are the records in DB </h1> 
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost/student" password="administrator" user="root" />
	<sql:query var="result" dataSource="${snapshot}">Select * from student</sql:query>
	<table border="1" width="100%">
		<tr>
			<th> ID </th>
			<th> Name </th>
			<th> Address </th>
	 	</tr>
	 	<c:forEach var="row" items="${result.rows}">
	 		<tr>
	 			<td><c:out value="${row.id}"></c:out></td>
	 			<td><c:out value="${row.name}"></c:out></td>
	 			<td><c:out value="${row.address}"></c:out></td>
	 		</tr>
	 	</c:forEach>
	</table>
</body>
</html>