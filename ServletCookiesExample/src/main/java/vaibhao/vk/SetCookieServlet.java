package vaibhao.vk;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");

		if (username != null && !username.trim().isEmpty()) {
			Cookie userCookie = new Cookie("username", username);

			userCookie.setMaxAge(24 * 60 * 60); // 1 day

			response.addCookie(userCookie);

			out.println("<html><body>");
			out.println("<h2>Cookie has been set successfully for username: " + username + "</h2>");
			out.println("<a href='GetCookieServlet'>Click here to view the cookie</a>");
			out.println("</body></html>");
		} else {
			out.println("<html><body>");
			out.println("<h2>Please enter a valid username.</h2>");
			out.println("<a href='index.html'>Go back</a>");
			out.println("</body></html>");
		}
	}
}
