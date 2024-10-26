package vaibhao.vk;

import java.io.Reader;
import java.sql.*;

public class SelectTextFile {

	public static void main(String[] args) throws Exception{
		
		com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		
		if (connection!=null) {
			PreparedStatement pstmt=connection.prepareStatement("select * from textfile");
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Reader r= rs.getCharacterStream("filedata");
				
				int data;
				
				while((data=r.read())!= -1) {
					char ch = (char) data;
					System.out.print(ch);
				}
			}
		}
		else {
			System.out.println("Database is not connected");
		}
		

	}

}
