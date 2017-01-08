<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('#logoutLink').click(function() {
			$('#logoutForm').submit();
		});
	});
</script>

<a class="title" href="<c:url value='/' />">Offers</a>

<sec:authorize access="!isAuthenticated()">
	<a class="login" href="${pageContext.request.contextPath}/loginform">Login</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<c:url var="logoutUrl" value="/logout" />
	<a class="login" id="logoutLink" href="#">Logout</a>
	<form id="logoutForm" action="${logoutUrl}" method="POST">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</sec:authorize>

