<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<a href="${pageContext.request.contextPath}/offers">Show offers</a>
</br>
<a href="${pageContext.request.contextPath}/createoffer">Create offer</a></br>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href="${pageContext.request.contextPath}/adminpage">Admin</a>
</sec:authorize>

