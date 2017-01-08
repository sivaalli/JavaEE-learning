<% 
	Cookie cookie1 = new Cookie("givenName",request.getParameter("given_name"));
	Cookie cookie2 = new Cookie("emailId",request.getParameter("email_id"));
	
	cookie1.setMaxAge(60*60*24);
	cookie2.setMaxAge(60*60*24);
	
	response.addCookie(cookie1);
	response.addCookie(cookie2);
%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	Thanks for registering with us <%= request.getParameter("given_name") %>
	 with you email id as <%=request.getParameter("emai_id") %>
	 <br>Cookies are added for better user activity
</body>
</html>