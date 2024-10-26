package vaibhao.org;

import java.sql.*;

public class JDBC_Connection_Insert {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver driver = new  com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		
		if(conn!=null) 
		{
			Statement stmt = conn.createStatement();
			
			int value = stmt.executeUpdate("insert into demo values ('0', 'akshat', '222')");
			
			if(value>0) 
			{
				System.out.println("Value Sucessfully Inserted");
			}
			else
			{
				System.out.println("Value is Not Insert......");
			}
		}
		else
		{
			System.out.println("Database is Not Connected");
		}

	}

}
