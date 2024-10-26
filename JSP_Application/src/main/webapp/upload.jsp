<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.*" %>
<%@ page import ="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Image Upload</title>
</head>
<body>
    <h1>Upload an Image</h1>
    <form action="upload.jsp" method="post" enctype="multipart/form-data">
        Select image to upload: <input type="file" name="file" accept="image/*" required />
        <input type="submit" value="Upload" />
    </form>

    <%
    // Check if the request is a file upload request
    if (ServletFileUpload.isMultipartContent(request)) {
        try {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Parse the request
            List<FileItem> items = upload.parseRequest(request);
            String uploadPath = application.getRealPath("") + File.separator + "uploads";

            // Create the upload directory if it does not exist
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir(); // Create the directory
            }

            // Process the uploaded items
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    // Get the uploaded file name
                    String fileName = item.getName();
                    if (fileName != null && !fileName.isEmpty()) {
                        File uploadedFile = new File(uploadDir, fileName);
                        item.write(uploadedFile); // Save the file to the server

                        // Provide feedback to the user
                        out.println("<h2>Image uploaded successfully: " + fileName + "</h2>");
                        out.println("<img src='uploads/" + fileName + "' alt='Uploaded Image' width='300'/>");
                    } else {
                        out.println("<h2>No file selected for upload.</h2>");
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
            out.println("<h2>Image upload failed: " + e.getMessage() + "</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Image upload failed: " + e.getMessage() + "</h2>");
        }
    }
    %>
</body>
</html>
