package vaibhao.vk;

import java.util.*;

import java.sql.*;

public class Delete_Jdbc_Prepared {

	public static void main(String[] args) throws Exception {

		com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		
		if(conn!=null)
		{
			Scanner v = new Scanner(System.in);
			
			System.out.println("Enter the id what you delete the data");
			int id = v.nextInt();
			
			
			PreparedStatement pstmt = conn.prepareStatement("delete from demo where id = ? ");
			
			pstmt.setInt(1, id);
			
			int values = pstmt.executeUpdate();
			
			if(values>0)
			{
				System.out.println("Your Data Deleted.......");
			}
			else
			{
				System.out.println("Not Deleted.....");
			}
		}
		else
		{
			System.out.println("Database is not Connected");
		}

	}

}
