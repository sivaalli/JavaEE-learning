<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
