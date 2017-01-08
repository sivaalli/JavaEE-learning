<%

 %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Display</title>
</head>
<body>
	Reading cookies<br>
	<c:forEach items="${cookie}" var="currentCookie">
		cookie stored with name <c:out value="${currentCookie.value.name}"></c:out><br>
		cookie stored with value <c:out value="${currentCookie.value.value}"></c:out><br>
	</c:forEach>
</body>
</html>