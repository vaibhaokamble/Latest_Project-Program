package vaibhao.vk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewStudent
 */
@WebServlet("/AddNewStudent")
public class AddNewStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher r = request.getRequestDispatcher("adminmaster.html");
        r.include(request, response);
        out.println("<form name='frm' action='' method='post'>");
        out.println("<br>");

        out.println("<div class='form-container'>");
        out.println("<form action='AddNewStudent' method='post'>");
        out.println("<div class='form-group'>");
        out.println("<input type='text' name='name' value='' placeholder='Enter the name' class='form-control'>");
        out.println("</div>");

        out.println("<div class='form-group'>");
        out.println("<input type='text' name='email' value='' placeholder='Enter the email' class='form-control'>");
        out.println("</div>");

        out.println("<div class='form-group'>");
        out.println("<input type='number' name='contact' value='' placeholder='Enter the contact' class='form-control'>");
        out.println("</div>");

        out.println("<div class='form-group'>");
        out.println("<input type='submit' name='s' value='Add New Student' class='btn btn-outline-primary'>");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
        out.println("</form>");
        
        String btn=request.getParameter("s");
        out.println(btn);
        if (btn!=null) {
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			
		}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
