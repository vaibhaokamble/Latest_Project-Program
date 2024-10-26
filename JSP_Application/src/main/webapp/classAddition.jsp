<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addition</title>
<style>
input {
	width: 400px;
	height: 40px;
}
</style>
</head>
<body>

<%@include file='master.jsp' %>



	<%!
	
	int a,b,c;
	
	%>

	<form action="" method='post'>
	
	<input type='text' name='first' placeholder=' first'>
	<br>
	<br>

	<input type='text' name='second' placeholder='second'>
	<br>
	<br>

	<input type='submit' name='s' value='Addition'>
	
	
	<%
	String btn = request.getParameter("s");
	
	if(btn!=null){
		
		String f = request.getParameter("first");
		
		String s = request.getParameter("second");
		
		a = Integer.parseInt(f);
		
		b = Integer.parseInt(s);
		
		c = a+b;
		
		out.println("<h1> Addition is &nbsp; "+c+"</h1>");
		
	}
	
	%>
	

	
	</form>
</body>
</html>