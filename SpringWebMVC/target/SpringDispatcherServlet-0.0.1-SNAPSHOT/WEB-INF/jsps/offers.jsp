<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Offers</h1>
	<table id=offers>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Comments/Text</th>
		</tr>
		<c:forEach var="offer" items="${offers}">
		<tr>
			<td><c:out value="${offer.id}"></c:out></td>	
			<td><c:out value="${offer.name}"></c:out></td>
			<td><c:out value="${offer.email}"></c:out></td>
			<td><c:out value="${offer.text}"></c:out></td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>