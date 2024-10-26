package vaibhao.vk;

import java.util.*;

import java.sql.*;

public class Update_Jdbc_Prepared {

	public static void main(String[] args) throws Exception {

		com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		
		if(conn!=null)
		{
			Scanner v = new Scanner(System.in);
			
			
			System.out.println("Enter id");
			int id = v.nextInt();
			v.nextLine();
			
			System.out.println("Enter name");
			String name = v.nextLine();
			
			
			System.out.println("Enter contact");
			String contact = v.nextLine();
		
			PreparedStatement pstmt = conn.prepareStatement("update demo set name = ? , contact= ? where id = ?");
			
		
	
			pstmt.setString(1, name);
		
			pstmt.setString(2, contact);
			
			pstmt.setInt(3, id);
			
			
			int values = pstmt.executeUpdate();
			
			if(values>0)
			{
				System.out.println("Your Data Updated.......");
			}
			else
			{
				System.out.println("Not Updated.....");
			}
		}
		else
		{
			System.out.println("Database is not Connected");
		}

	}

}
