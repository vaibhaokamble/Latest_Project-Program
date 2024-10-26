<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hey vaibhao.................</h1>

	<%!
	
	int a, b, c;
	
	%> <!--declaration-->

	<%
	a = 100;
	b = 200;
	c = a + b;

	out.println("<h1> Addition is &nbsp;" + c + " </h1>");
	%>  <!-- scriplet -->
	
	
	
</body>
</html>