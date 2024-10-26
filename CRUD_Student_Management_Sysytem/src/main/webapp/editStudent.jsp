<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>
<%
int id = Integer.parseInt(request.getParameter("id"));
String name = "";
String email = "";
String course = "";

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "vaibhaovk", "vaibhao");

	String sql = "SELECT * FROM Students WHERE id=?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();

	if (rs.next()) {
		name = rs.getString("name");
		email = rs.getString("email");
		course = rs.getString("course");
	}
	conn.close();
} catch (SQLException e) {
	e.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Student</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="container">
		<h2 class="text-center">Edit Student</h2>
		<form action="updateStudent.jsp" method="post">
			<input type="hidden" name="id" value="<%=id%>">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name" value="<%=name%>"
					required>
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" name="email" value="<%=email%>"
					required>
			</div>
			<div class="form-group">
				<label for="course">Course:</label> <input type="text"
					class="form-control" id="course" name="course"
					value="<%=course%>" required>
			</div>
			<button type="submit" class="btn btn-primary">Update Student</button>
		</form>
	</div>
</body>
</html>
