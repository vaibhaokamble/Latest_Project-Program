<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Request Object Example</title>
<style>
input {
	width: 400px;
	height: 40px;
}
</style>
</head>
<body>
	<div>
		<h2>Form Submission Example</h2>
		<form action="" method="post">
			<input type="text" name="name" placeholder='enter the name'><br>
			<br> <input type="number" name="age" placeholder='enter the age'><br>
			<br> <input type="submit" value="Submit">
		</form>
	</div>


	<div>
		<h2>Form Data Received</h2>
		<p>
			Name is =
			<%=request.getParameter("name")%></p>
		<p>
			Age is =
			<%=request.getParameter("age")%></p>

	</div>
</body>
</html>
