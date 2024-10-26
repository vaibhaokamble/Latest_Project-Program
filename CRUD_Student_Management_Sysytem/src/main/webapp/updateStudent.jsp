<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page import="java.sql.*"%>
<%
int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String email = request.getParameter("email");
String course = request.getParameter("course");

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "vaibhaovk", "vaibhao");

	String sql = "UPDATE Students SET name=?, email=?, course=? WHERE id=?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, name);
	ps.setString(2, email);
	ps.setString(3, course);
	ps.setInt(4, id);

	int result = ps.executeUpdate();
	conn.close();

	if (result > 0) {
		response.sendRedirect("index.jsp"); // Redirect to main page after successful update
	} else {
		out.println("<h3>Error updating student. Please try again.</h3>");
	}
} catch (SQLException e) {
	e.printStackTrace();
}
%>
