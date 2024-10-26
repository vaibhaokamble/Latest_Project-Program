package vaibhao.vk;

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
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String n = request.getParameter("name");
		
		String e = request.getParameter("email");
		
		String c = request.getParameter("contact");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
			
			if(conn!=null) {
				PreparedStatement  pstmt = conn.prepareStatement("insert into register values (?,?,?)");
				
				pstmt.setString(1, n);
				
				pstmt.setString(2, e);
				
				pstmt.setString(3, c);
			
				int value = pstmt.executeUpdate();
				
				if(value>0) {
					out.println("<h1> Value Inserted Success...........");
				}
				else
				{
					out.println("<h1> Some Problem is there </h1>");
				}
			
			}
			else
			{
				out.println("<h1> Database is not connected </h1>");
			}
		
		}
		catch(Exception ex) {
			out.println("error is " + ex);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
