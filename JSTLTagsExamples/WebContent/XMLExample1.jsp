<%@ page import="java.util.*,java.io.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>Books Info</h1>
	<c:import var="bookInfo" url="http://localhost:8080/JSTLTagsExamples/books.xml"></c:import>
	<x:parse var="output" xml="${bookInfo}" ></x:parse>
	<p>The title of the book is <x:out select="$output/books/book[1]/name"/></p>
	<p>The Price of the book is <x:out select="$output/books/book[2]/price"/></p>
	
</body>
</html>