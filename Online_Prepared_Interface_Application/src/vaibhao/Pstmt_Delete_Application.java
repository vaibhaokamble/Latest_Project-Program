package vaibhao;

import java.sql.*;

import java.util.*;

public class Pstmt_Delete_Application {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection;
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		
		
		if (connection!=null) {
			PreparedStatement pstmt ;
			
			Scanner v = new Scanner(System.in);
			System.out.println("enter the email");
			String email= v.nextLine();
			
			pstmt = connection.prepareStatement("delete from register where email = ?");
			
			pstmt.setString(1, email);
			
			int value = pstmt.executeUpdate();
			
			if (value>0) {
				System.out.println("Deleted query successfully.....");
			}
			else {
				System.out.println("some problem is there.........");
			}
			
		}
		else {
			System.out.println("Not connected.....");
		}

	}

}
