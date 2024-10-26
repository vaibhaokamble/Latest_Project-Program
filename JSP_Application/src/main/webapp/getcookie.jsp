<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<head>
<title>Get Cookie Example</title>
</head>
<body>
	<h1>Retrieve Cookie</h1>
	<%
	// Get the cookies from the request
	Cookie[] cookies = request.getCookies();
	String username = null;

	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("username")) {
		username = cookie.getValue(); // Retrieve the cookie value
		break;
			}
		}
	}
	%>
	<h2>Cookie Retrieval</h2>
	<%
	if (username != null) {
	%>
	<p>
		Welcome back, <strong><%=username%></strong>!
	</p>
	<%
	} else {
	%>
	<p>No username cookie found!</p>
	<%
	}
	%>
	<p>
		<a href="setcookie.jsp">Go to Set Cookie Page</a>
	</p>
</body>
</html>
