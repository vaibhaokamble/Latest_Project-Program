<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!int no, i, table;%>
	<form>
		<input type='text' name='no' placeholder='enter any name'> <br>
		<br> <input type='submit' name='s' value='Table'>
	</form>

	<%
	String btn = request.getParameter("s");
	if (btn != null) {
		no = Integer.parseInt(request.getParameter("no"));
		for (i = 1; i <= 10; i++) {
			out.println(no * i + "<br>");
		}
	}
	
	
	%>
</body>
</html>