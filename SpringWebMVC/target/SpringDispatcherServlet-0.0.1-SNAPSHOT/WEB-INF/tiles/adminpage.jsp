<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Welcome administrator</h1>

<table class="formTable">
	<tr>
		<th>Username</th>
		<th>Email</th>
		<th>Authority</th>
		<th>Enabled</th>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr>
			<td><c:out value="${user.username }"></c:out></td>
			<td><c:out value="${user.email }"></c:out></td>
			<td><c:out value="${user.authority }"></c:out></td>
			<td><c:out value="${user.enabled }"></c:out></td>
		</tr>
	</c:forEach>
</table>
