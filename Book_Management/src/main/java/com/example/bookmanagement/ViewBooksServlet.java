package com.example.bookmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewBooks")
public class ViewBooksServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.getAllBooks();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Books List</h2>");
        out.println("<table border='1'><tr><th>ID</th><th>Title</th><th>Author</th><th>Publisher</th><th>Price</th><th>Actions</th></tr>");
        for (Book book : books) {
            out.println("<tr><td>" + book.getId() + "</td><td>" + book.getTitle() + "</td><td>" + book.getAuthor() + "</td><td>" + book.getPublisher() + "</td><td>" + book.getPrice() + "</td>"
                    + "<td><a href='updateBook.html?id=" + book.getId() + "'>Update</a> | <a href='deleteBook?id=" + book.getId() + "'>Delete</a></td></tr>");
        }
        out.println("</table>");
        out.println("<br><a href='index.html'>Back to Home</a>");
    }
}
