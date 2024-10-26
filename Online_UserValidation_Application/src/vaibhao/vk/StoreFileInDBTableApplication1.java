package vaibhao.vk;

import java.sql.*;
import java.io.*;
public class StoreFileInDBTableApplication1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online", "vaibhaovk", "vaibhao");
		if (conn != null) {
			 	PreparedStatement stmt = conn.prepareStatement("select *from storeTextFile");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Reader r = rs.getCharacterStream("filedata");
				int data;
				while ((data = r.read()) != -1) {
					char ch = (char) data;
					System.out.print(ch);
				}
			}
		} else {
			System.out.println("Database  is not connected");
		}
	}
}
