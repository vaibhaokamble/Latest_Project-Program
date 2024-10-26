<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Set Cookie Example</title>
</head>
<body>
	<h1>Set Your Name</h1>
	<form action="" method="post">
		Name: <input type="text" name="username" required /> <input
			type="submit" value="Submit" />
	</form>

	<%
	// Check if the form has been submitted
	String username = request.getParameter("username");
	if (username != null && !username.isEmpty()) {
		// Create a cookie
		Cookie userCookie = new Cookie("username", username);
		userCookie.setMaxAge(60 * 60 * 24); // Set cookie to expire in 1 day
		response.addCookie(userCookie); // Add cookie to the response
	%>
	<h2>Cookie Created!</h2>
	<p>Your name has been stored in a cookie.</p>
	<%
	} else {
	%>
	<h2>No cookie created.</h2>
	<%
	}
	%>
	<p>
		<a href="getcookie.jsp">Go to Retrieve Cookie Page</a>
	</p>
</body>
</html>
