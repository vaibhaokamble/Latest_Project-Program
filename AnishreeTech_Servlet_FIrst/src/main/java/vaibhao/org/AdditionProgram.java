package vaibhao.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addition")
public class AdditionProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdditionProgram() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String f = request.getParameter("first");
		
		String s = request.getParameter("second");
		
		int  total = Integer.parseInt(f) + Integer.parseInt(s);
		
		out.println("<h1>Addition is = " +total+ "</h1>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
