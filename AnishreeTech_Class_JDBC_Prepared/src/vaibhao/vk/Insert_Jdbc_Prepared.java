package vaibhao.vk;

import java.sql.*;

import java.util.*;

public class Insert_Jdbc_Prepared {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(d);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		
		if(conn!=null) 
		{
			Scanner v = new Scanner(System.in);
			
			System.out.println("Enter the id");
			int id = v.nextInt();
			v.nextLine();
			
			System.out.println("Enter the name");
			String name = v.nextLine();
			
			System.out.println("Enter the contact");
			String contact = v.nextLine();
			
			PreparedStatement pstmt= conn.prepareStatement(" insert into demo values (?,?,?)");
			
			pstmt.setInt(1, id);
			
			pstmt.setString(2, name);
			
			pstmt.setString(3, contact);
			
			int value = pstmt.executeUpdate();
			
			if(value>0)
			{
				System.out.println("Value Added Successfull......");
			}
			else
			{
				System.out.println("Some Problem is there");
			}
		}
		else
		{
			System.out.println("Databse is not connected");
		}
		
	}

}
