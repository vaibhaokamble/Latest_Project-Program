package vaibhao.org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Get form parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			// Load MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "vaibhaovk","vaibhao");

			if (conn != null) {
				PreparedStatement pstmt = conn
						.prepareStatement("select * from users where username = ? and password = ?");

				pstmt.setString(1, username);
				pstmt.setString(2, password);

				// Execute query
				ResultSet rs = pstmt.executeQuery();

				// If user exists
				if (rs.next()) {
					out.println("<h1>Login Successful!</h1>");
				} else {
					out.println("<h1>Invalid username or password!</h1>");
				}
			} else {
				out.println("<h1>Database Connection Failed</h1>");
			}

		} catch (Exception e) {
			out.println("Error is " + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
