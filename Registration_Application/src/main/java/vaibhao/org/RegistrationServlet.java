package vaibhao.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();

		    String name = request.getParameter("name");
		    String email = request.getParameter("email");
		    String contact = request.getParameter("contact");
		    String username = request.getParameter("username");
		    String password = request.getParameter("password");

		    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "vaibhaovk", "vaibhao");
		         PreparedStatement pstmt = conn.prepareStatement(
		                "INSERT INTO users (name, email, contact, username, password) VALUES (?, ?, ?, ?, ?)")) {

		        pstmt.setString(1, name);
		        pstmt.setString(2, email);
		        pstmt.setString(3, contact);
		        pstmt.setString(4, username);
		        pstmt.setString(5, password);

		        int value = pstmt.executeUpdate();

		        if (value > 0) {
		            out.println("<h1>Registration Successful!</h1>");
		        } else {
		            out.println("<h1>Registration Failed!</h1>");
		        }
		    } catch (Exception e) {
		        out.println("<h1>Error: " );
		    }
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
