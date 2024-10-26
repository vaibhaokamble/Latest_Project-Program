<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Colorful Registration Form</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel='stylesheet' href='css/style.css'>
</head>
<body>

	<%!
	
	String name;
	String email;
	String contact;
	Connection conn;
	PreparedStatement pstmt;
	
	%>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="registration-form">
					<h2>Register Here</h2>
					<form action='' method='post'>
						<!-- Name Field -->
						<div class="form-group">
							<label for="name">Name</label> <input type="text"
								class="form-control" id="name" name='name'
								placeholder="Enter your name">
						</div>

						<!-- Email Field -->
						<div class="form-group">
							<label for="email">Email</label> <input type="email"
								class="form-control" id="email" name='email'
								placeholder="Enter your email">
						</div>

						<!-- Contact Field -->
						<div class="form-group">
							<label for="contact">Contact</label> <input type="text"
								class="form-control" id="contact"
								placeholder="Enter your contact number" name='contact'>
						</div>

						<!-- Submit Button -->
						<button type="submit" name='s' class="btn btn-custom">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>


	<%
	String btn = request.getParameter("s");
	if (btn != null) {
		name = request.getParameter("name");
		email = request.getParameter("email");
		contact = request.getParameter("contact");

		/*out.println("<h1> Name is = " + name + "</h1>");
		out.println("<h1> Email is = " + email + "</h1>");
		out.println("<h1> Contact is = " + contact + "</h1>");*/

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "vaibhaovk", "vaibhao");

			pstmt = conn.prepareStatement("insert into register values('0',?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, contact);

			int value = pstmt.executeUpdate();

			if (value > 0) {
		out.println("<h1> Registration Success..................");
			} else {
		out.println("<h1> Failed................");
			}
		} catch (Exception ex) {
			out.println("Error is " + ex);
		}
	}
	%>


	<!-- Bootstrap JS, Popper.js, and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
