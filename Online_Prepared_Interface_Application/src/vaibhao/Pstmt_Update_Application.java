package vaibhao;

import java.sql.*;
import java.util.Scanner;

public class Pstmt_Update_Application {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection conn;
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		
		if (conn!=null) {
			PreparedStatement pstmt ;
			
			Scanner v = new Scanner(System.in);
			
			System.out.println("enter your name");
			String name= v.nextLine();
		
			System.out.println("enter your email");
			String email= v.nextLine();
			
			System.out.println("enter your contact");
			String contact= v.nextLine();
			
			System.out.println("enter your id");
			int id= v.nextInt();
			
			pstmt=conn.prepareStatement("update register set name=?, email=?,contact=? where rid = ?");
			
			pstmt.setString(1, name);
			pstmt.setString(2,email);
			pstmt.setString(3, contact);
			pstmt.setInt(4, id);
			
			int value = pstmt.executeUpdate();
			
			if (value>0) {
				System.out.println("Update Successfully..........");
			}
			else {
				System.out.println("Some problem is there");
			}
		}
		else {
			System.out.println("Database not connected");
		}

	}

}
