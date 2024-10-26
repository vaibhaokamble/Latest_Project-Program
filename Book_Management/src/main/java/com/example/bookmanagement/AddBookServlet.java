package com.example.bookmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Create a PrintWriter to write the HTML response
        PrintWriter out = response.getWriter();

        // HTML form for adding a book
        out.println("<html><body>");
        out.println("<h1>Add a New Book</h1>");
        out.println("<form action='addBook' method='post'>");
        out.println("Title: <input type='text' name='title' required><br>");
        out.println("Author: <input type='text' name='author' required><br>");
        out.println("<input type='submit' value='Add Book'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve book details from the request parameters
        String title = request.getParameter("title");
        String author = request.getParameter("author");

        // Validate the book details (Optional but recommended)
        if (title == null || title.isEmpty() || author == null || author.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid book details");
            return;
        }

        // Logic to store the book in a database or list (Placeholder comment)
        // Example: BookDAO.addBook(new Book(title, author));

        // Set response content type
        response.setContentType("text/html");

        // Create a PrintWriter to write the response
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Book Added Successfully</h1>");
        out.println("<p>Title: " + title + "</p>");
        out.println("<p>Author: " + author + "</p>");
        out.println("<a href='addBook'>Add Another Book</a>");
        out.println("</body></html>");
    }
}
