package vaibhao.vk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/valid")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("username");
		String upass = request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "vaibhaovk", "vaibhao");
			if (conn != null) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select *from register where username='" + uname + "' and password='" + upass + "'");
				if (rs.next()) {
					out.println("<h1>Login Success</h1>");
					HttpSession session = request.getSession(true);
					int userId = rs.getInt(1);
					session.setAttribute("uid", userId);
					RequestDispatcher r = request.getRequestDispatcher("Viewprofile.html");
					r.forward(request, response);
				} else {
					RequestDispatcher r = request.getRequestDispatcher("login.html");
					r.include(request, response);
					out.println("<h1>Invalid login</h1>");
				}
			} else {

			}
		} catch (Exception ex) {
			out.println("Error is " + ex);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
