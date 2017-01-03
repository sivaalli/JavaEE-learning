<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer" >
	<table class="formTable">
		<tr><td class="label">Name: </td><td><sf:input path="name" type="text" name="name" /></br><sf:errors path="name" cssClass="error"></sf:errors></td></tr>
		<tr><td class="label">Email: </td><td><sf:input path="email" type="text" name="email" /></br><sf:errors path="email" cssClass="error"></sf:errors></td></tr>
		<tr><td class="label">Your offer: </td><td><sf:textarea path="text" name="text" rows="10 " cols="10"></sf:textarea></br><sf:errors path="text" cssClass="error"></sf:errors></td></tr>
		<tr><td class="label"></td><td><input type="submit" value="Create advert" ></td></tr>
	</table>
</sf:form>
