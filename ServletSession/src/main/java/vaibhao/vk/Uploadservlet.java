package vaibhao.vk;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/uploadserv")
public class Uploadservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Your specific directory path for saving files
	private static final String UPLOAD_DIRECTORY = "C:\\Users\\vaibh\\eclipse-workspace\\ServletSession\\src\\main\\webapp\\uploads";
	
	// File upload size settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Uploadservlet() {
		super();
	}

	/**
	 * Handles the GET request, showing the upload form.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setting content type for HTML response
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Creating a simple HTML form for file upload
		out.println("<html>");
		out.println("<head><title>File Upload</title></head>");
		out.println("<body>");
		out.println("<h2>Upload a File</h2>");
		out.println("<form method='post' action='" + request.getContextPath() + "/uploadserv' enctype='multipart/form-data'>");
		out.println("<input type='file' name='file' required/>");
		out.println("<input type='submit' value='Upload'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * Handles the POST request, processing the file upload.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Check if the request contains multipart content
		if (!ServletFileUpload.isMultipartContent(request)) {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("<html><body><p>Error: Form must have enctype=multipart/form-data.</p></body></html>");
			writer.flush();
			return;
		}

		// Configuring the upload settings
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// Set memory threshold - beyond which files are stored on disk
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// Set temporary directory for storing files
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set maximum file size allowed
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// Set maximum request size (includes file + form data)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// Use the specific directory path for file storage
		String uploadPath = UPLOAD_DIRECTORY;
		
		// Create the directory if it doesn't exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs(); // Creates directory and any missing parent directories
		}

		try {
			// Parse the request's content to extract file data
			List<FileItem> formItems = upload.parseRequest(request);

			if (formItems != null && formItems.size() > 0) {
				// Iterate over form items
				for (FileItem item : formItems) {
					// Check if the item is a file
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						// Save file to the specified directory
						String filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);

						// Save the file on disk
						item.write(storeFile);

						// Response to client on successful upload
						response.setContentType("text/html");
						PrintWriter writer = response.getWriter();
						writer.println("<html><body><h3>File '" + fileName + "' has been uploaded successfully to: " + uploadPath + "</h3></body></html>");
						writer.flush();
						return;
					}
				}
			}
		} catch (Exception ex) {
			// Error handling during file upload
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("<html><body><h3>Error during file upload: " + ex.getMessage() + "</h3></body></html>");
			ex.printStackTrace();
			writer.flush();
		}
	}
}
