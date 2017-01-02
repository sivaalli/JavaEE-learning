<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="${pageContext.request.contextPath}/static/scripts/jQuery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#logoutLink').click(function() {
			$('#logoutForm').submit();
		});
	});
</script>
</head>
<body>
	<h1>Welcome to Offers</h1>
	<ul>
		<li><a href="${pageContext.request.contextPath}/offers">Show
				offers</a></li>
		<li><a href="${pageContext.request.contextPath}/createoffer">Create
				offer</a></li>
		
		<sec:authorize access="hasRole('ADMIN')">
			<li><a href="${pageContext.request.contextPath}/adminpage">Admin</a></li>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
		<c:url var="logoutUrl" value="/logout" />
		<li><a id="logoutLink" href="#">Logout</a>
			<form id="logoutForm" action="${logoutUrl}" method="POST">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form></li>
		</sec:authorize>
		
		<sec:authorize access="!isAuthenticated()">
		<li><a href="${pageContext.request.contextPath}/loginform">Login</a></li>
		</sec:authorize>
		
		


		

	</ul>
</body>
</html>