package vaibhao.vk;

import java.sql.*;

import java.io.*; 	

public class StoreFileInDBTableApplication {
	public static void main(String[] args)throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		if(conn!=null) {
			 File f = new File("D:\\online\\demo.txt");
			 FileReader fr=  new FileReader(f);
			 PreparedStatement stmt=conn.prepareStatement("insert into storeTextFile values('0',?)");
			 stmt.setCharacterStream(1, fr,f.length());
			 int value=stmt.executeUpdate();
			 if(value>0) {
				 System.out.println("text file save in database table");
			 }
			 else {
				 System.out.println("text file not save in database table");
			 }
			}
			else {
				System.out.println("Database  is not connected");
			}

	}

}
