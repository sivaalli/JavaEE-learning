<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="ex" uri="WEB-INF/custom.tld" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ex:Counter/>
	<p>The total number of visits to this page are <%= application.getAttribute("counter") %></p>
	<jsp:forward page="randompage.jsp"></jsp:forward>
	
	
</body>
</html>