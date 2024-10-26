<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page import="java.sql.*"%>
<%
String name = request.getParameter("name");
String email = request.getParameter("email");
String course = request.getParameter("course");

try {
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "vaibhaovk", "vaibhao");

	String sql = "INSERT INTO Students (name, email, course) VALUES (?, ?, ?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, name);
	ps.setString(2, email);
	ps.setString(3, course);

	int result = ps.executeUpdate();
	conn.close();

	if (result > 0) {
		out.println("<h3>Student added successfully!</h3>");
		out.println("<a href='index.jsp'>Go back to Student List</a>");
	} else {
		out.println("<h3>Error adding student. Please try again.</h3>");
	}
} catch (SQLException e) {
	e.printStackTrace();
}
%>
