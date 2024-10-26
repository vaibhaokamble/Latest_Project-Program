<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Session Example</title>
</head>
<body>

	<%!HttpSession session;%>
	<%
	// Create or retrieve the session
	session = request.getSession();

	// Set an attribute in the session
	session.setAttribute("username", "Vaibhao");
	%>
	<h1>Session Created</h1>
	<p>
		Your session ID is:
		<%=session.getId()%></p>
	<p>
		Username stored in session:
		<%=session.getAttribute("username")%></p>
</body>
</html>
