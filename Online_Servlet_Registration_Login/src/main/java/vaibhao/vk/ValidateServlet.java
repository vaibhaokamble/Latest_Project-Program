package vaibhao.vk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ValidateServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		   response.setContentType("text/html");
		   PrintWriter out=response.getWriter();
		   String un=request.getParameter("username");
		   String up=request.getParameter("password");
		   try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/online", "vaibhaovk", "vaibhao");
			  if(conn!=null) {
				PreparedStatement stmt=conn.prepareStatement("select *from login where username=? and password=?");
			    stmt.setString(1,un);
			    stmt.setString(2, up);
			   ResultSet rs=stmt.executeQuery();
			   if(rs.next()) {
				   out.println("<h1>Welcome user in application</h1>");
			   }
			   else {
				   out.println("<h1>Invalid username and password</h1>");
			   }
			  }
			  else {
				  out.println("<h1>DB Not Conencted</h1>");
			  }
		   }
		   catch(Exception ex) {
			   out.println("error is "+ex);
		   }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
