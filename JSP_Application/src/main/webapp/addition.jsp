<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
input {
	width: 400px;
	height: 40px
}
</style>
</head>
<body>

	<%!int a, b, c;%>

	<%@include file='master.jsp'%>

	<form action="" method="post">
		<input type='text' name='first' value='' placeholder='add first'>
		<br> <br> <input type='text' name='second' value=''
			placeholder='add second'> <br> <br> <input
			type='submit' name='s' value='Addition'>
		<%
		String btn = request.getParameter("s");

		if (btn != null) {
			String first = request.getParameter("first");

			String second = request.getParameter("second");

			a = Integer.parseInt(first);
			b = Integer.parseInt(second);
			c = a + b;
		}
		%>
		<h1>
			Addition is
			<%=c%>
		</h1>



	</form>
</body>
</html>