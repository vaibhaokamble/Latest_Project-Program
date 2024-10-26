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

@WebServlet("/reg")
public class RegSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegSer() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String n =request.getParameter("name");
		
		String e =request.getParameter("email");
		
		String c =request.getParameter("contact");
		
		String u =request.getParameter("username");
		
		String p =request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
					
			if(conn!=null) {
				PreparedStatement pstmt = conn.prepareStatement("insert into registration  values ('0',?,?,?,?,?)");
				
				pstmt.setString(1, n);
				
				pstmt.setString(2, e);
				
				pstmt.setString(3, c);
				
				pstmt.setString(4, u);
				
				pstmt.setString(5, p);
				
				int value = pstmt.executeUpdate();
				
				if(value>0){
					out.println("<h1> Registration Successs </h1>");
				}
				else
				{
					out.println("<h1> Failed.........</h1>");
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
