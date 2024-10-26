<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>
<%
int id = Integer.parseInt(request.getParameter("id"));

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "vaibhaovk", "vaibhao");

	String sql = "DELETE FROM Students WHERE id=?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1, id);

	int result = ps.executeUpdate();
	conn.close();

	if (result > 0) {
		response.sendRedirect("index.jsp"); // Redirect to main page after deletion
	} else {
		out.println("<h3>Error deleting student. Please try again.</h3>");
	}
} catch (SQLException e) {
	e.printStackTrace();
}
%>
