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


@WebServlet("/validatelogin")
public class ValidateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
     
    public ValidateServ() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String un = request.getParameter("username");
		
		String up = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
					
			if(conn!=null) {
				PreparedStatement pstmt = conn.prepareStatement("select * from registration where username =? and password=?");
				
				pstmt.setString(1, un);
				
				pstmt.setString(2, up);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					out.println("<h1> Welcome User...... </h1>");
				}
				
				else
				{
					out.println("<h1> Invalid ......</h1>");
				}
				
			}
			else
			{
				out.println("DB Not Connected");
			}
		}
		catch(Exception Ex) {
			out.println("Error is " +Ex);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
