package vaibhao;

import java.sql.*;
import java.util.Scanner;


public class Pstmt_Application {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		
		if (connection!=null) {
			PreparedStatement pstmt;
			
			Scanner v = new Scanner(System.in);
			
			System.out.println("Enter the name");
			String name=v.nextLine();
			
			System.out.println("Enter the email");
			String email=v.nextLine();
			
			System.out.println("Enter the contact");
			int contact=v.nextInt();
			
			pstmt=connection.prepareStatement("insert into register values('0',?,?,?)");
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setInt(3, contact);
			
			int value= pstmt.executeUpdate();
			
			if (value>0) {
				System.out.println("Values Insert Successfully...........");
			}
			else {
				System.out.println("Some problem is there");
			}
		}
		else {
			System.out.println("not connected");
		}

	}

}
