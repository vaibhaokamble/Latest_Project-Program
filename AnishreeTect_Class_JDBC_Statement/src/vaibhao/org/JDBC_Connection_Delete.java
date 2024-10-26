package vaibhao.org;

import java.util.*;

import java.sql.*;

public class JDBC_Connection_Delete {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		
		if(conn!=null)
		{
			Statement stmt = conn.createStatement();
			
			Scanner v = new Scanner(System.in);
			
			System.out.println("Enter the id");
			
			int id = v.nextInt();
			
			int value = stmt.executeUpdate("delete from demo where id= "+id);
			
			if(value>0)
			{
				System.out.println("Value Deleted.......");
			}
			else
			{
				System.out.println("Value Not Deleted");
			}
		}
		else
		{
			System.out.println("Database is not connected");
		}
		
	}

}
