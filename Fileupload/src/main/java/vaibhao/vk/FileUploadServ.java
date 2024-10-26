package vaibhao.vk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.io.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileUploadServ
 */
@WebServlet("/upload")
public class FileUploadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		long maxFileSize = 1024 * 1024 * 1024;
		String path = request.getRealPath("/");
		out.println(path);

		boolean b = ServletFileUpload.isMultipartContent(request);

		if (b) {
			out.println("Success..........");

			DiskFileItemFactory factory = new DiskFileItemFactory();

			ServletFileUpload fileupload = new ServletFileUpload(factory);

			fileupload.setSizeMax(maxFileSize);

			try {
				List fileList = fileupload.parseRequest(request);

				Iterator iterator = fileList.iterator();

				while (iterator.hasNext()) {
					FileItem fileItem = (FileItem) iterator.next();

					if (!fileItem.isFormField()) {
						String fieldName = fileItem.getFieldName();
						String filename = fileItem.getName();
						String fileContent = fileItem.getContentType();
						long size = fileItem.getSize();

						out.println("<h1> Field name is &nbsp;" + fieldName + " </h1>");

						out.println("<h1> File Name is  " + filename + " </h1>");

						out.println("<h1> File Content is &nbsp;  " + fileContent + " </h1>");

						out.println("<h1> File Size is &nbsp;  " + size+ " </h1>");
						
						
						File storeFile = new File(path+"img\\"+filename);
						
						fileItem.write(storeFile);
						
						out.println("Uploading Success...........");
					}

				}
			} catch (Exception ex) {
				out.println("Error is" + ex);
			}

		} else {
			out.println("Failed........");
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
