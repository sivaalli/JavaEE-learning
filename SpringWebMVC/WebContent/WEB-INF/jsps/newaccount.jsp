<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/style.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/jQuery.js"></script>
<script type="text/javascript">
	function onLoad() {

		$("#password").keyup(checkPasswordsMatch);
		$("#confirmpass").keyup(checkPasswordsMatch);

		$("#details").submit(canSubmit);
	}
	
	function canSubmit() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		
		if(password != confirmpass) {
			alert("Passwords do not match!")
			return false;
		}
		else {
			return true;
		}
	}

	function checkPasswordsMatch() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();

		if (password.length > 3 || confirmpass.length > 3) {

			if (password == confirmpass) {
				$("#matchpass").text("<fmt:message key='MatchedPasswords.user.password'></fmt:message>");
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");
			} else {
				$("#matchpass").text("<fmt:message key='UnmatchedPasswords.user.password'></fmt:message>");
				$("#matchpass").addClass("error");
				$("#matchpass").removeClass("valid");
			}
		}
	}

	$(document).ready(onLoad);
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


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
						name="password" type="text" />
					<div class="error">
						<sf:errors path="password"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Confirm Password:</td>
				<td><input id="confirmpass" class="control" name="confirmpass"
					type="text" />
				<div id="matchpass"></div></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create account" type="submit" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>