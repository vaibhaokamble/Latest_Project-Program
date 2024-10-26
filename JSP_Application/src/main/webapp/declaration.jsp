<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!int numVisitors = 0;%>
	<%
	numVisitors++;
	%>
	<h2>
		Visitor Count on Click:
		<%=numVisitors%></h2>


</body>
</html>