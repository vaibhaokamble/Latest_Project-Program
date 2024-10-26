<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Management System</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Student Management System</h1>
		<a href="addStudent.jsp" class="btn btn-primary">Add New Student</a>
		<hr />

		<h2>Student List</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Course</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "vaibhaovk", "vaibhao");

				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Students");

				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String course = rs.getString("course");
				%>
				<tr>
					<td><%=id%></td>
					<td><%=name%></td>
					<td><%=email%></td>
					<td><%=course%></td>
					<td><a href="editStudent.jsp?id=<%=id%>"
						class="btn btn-warning btn-sm">Edit</a> <a
						href="deleteStudent.jsp?id=<%=id%>" class="btn btn-danger btn-sm">Delete</a></td>
				</tr>
				<%
				}
				conn.close();
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
