package vaibhao.vk;

import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class OnlineStoreFileApplication {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver driver= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		
		if (conn!=null) {
			File f =  new File("D:\\Online\\demo1.txt");
			FileReader fr= new FileReader(f);
			PreparedStatement pstmt = conn.prepareStatement("insert into storetextfile values ('0', ?)");
			
			pstmt.setCharacterStream(1, fr, f.length());
			
			int value= pstmt.executeUpdate();
			
			if (value>0) {
				System.out.println("Text file is save in databases........");
			}
			else {
				System.out.println("Text file not save or Failed............");
			}
		}
		else {
			System.out.println("Database is not connected");
		}
		


	}

}
