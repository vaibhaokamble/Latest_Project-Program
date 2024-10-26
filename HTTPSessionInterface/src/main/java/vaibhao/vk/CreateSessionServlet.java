package vaibhao.vk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/create")
public class CreateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateSessionServlet() {
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
		String id=session.getId();
		out.println("<h1>Session id "+id+"</h1>");
		String uname=request.getParameter("username");
		String upass=request.getParameter("password");
		session.setAttribute("u", uname);
		session.setAttribute("p", upass);
		out.println("<a href='view'>View Session Data</a>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
