package vaibhao.vk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/valid")
public class ValidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ValidServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username.equals("admin") && password.equals("admin")) {
			RequestDispatcher r = request.getRequestDispatcher("welcome.html");
			r.forward(request, response);
		} else {
			RequestDispatcher r = request.getRequestDispatcher("login.html");
			r.include(request, response);

			out.println("<h1>Invalid username and password</h1>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
