package vaibhao.vk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FirstServletDemo() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>hey its servlet page...</h1>");
		
		out.println("<h2>hey its servlet page...</h2>");
		
		out.println("<h3>hey its servlet page...</h3>");
		
		out.println("<h4>hey its servlet page...</h4>");
		
		out.println("<h5>hey its servlet page...</h5>");
		
		out.println("<h6>hey its servlet page...</h6>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
