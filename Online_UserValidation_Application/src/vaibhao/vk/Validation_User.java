package vaibhao.vk;

import java.util.*;

import java.sql.*;

public class Validation_User {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver driver= new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		
		if (conn!=null) {
		Scanner v = new Scanner(System.in);
			
		System.out.println("Enter the username");
		String username= v.nextLine();
		
		System.out.println("Enter the password");
		String password= v.nextLine();
		
		PreparedStatement pstmt = conn.prepareStatement("select * from login where username=? and password = ?");
		
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		
		ResultSet rs= pstmt.executeQuery();
		
		if (rs.next()) {
			System.out.println("User Present in Database...........");
		}
		else {
			System.out.println("Invalid Id and Password");
		}
		}
		else {
			System.out.println("Not Connected Database....");
		}
	}

}
