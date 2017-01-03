<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

	<h1>Create a new Account</h1>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/createaccount"
		modelAttribute="user">
		<table class="formTable">
			<tr>
				<td class="label">Username:</td>
				<td><sf:input class="control" path="username" name="username"
						type="text" /><br />
				<div class="error">
						<sf:errors path="username"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input class="control" path="email" name="email"
						type="text" />
					<div class="error">
						<sf:errors path="email"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><sf:input id="password" class="control" path="password"
						name="password" type="password" />
					<div class="error">
						<sf:errors path="password"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Confirm Password:</td>
				<td><input id="confirmpass" class="control" name="confirmpass"
					type="text" type="password"/>
				<div id="matchpass"></div></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create account" type="submit" /></td>
			</tr>
		</table>
	</sf:form>