package vaibhao.org;

import java.util.*;

import java.sql.*;

public class JDBC_Connection_Update {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		
		if(conn!=null)
		{
			Statement stmt = conn.createStatement();
			
			Scanner v = new Scanner(System.in);
			
			System.out.println("Enter the id name contact");
			
			int id = v.nextInt();
			
			
			String name = v.next();
			
			
			String contact = v.next();
			
			int value = stmt.executeUpdate("update demo set name='"+name+"' , contact='"+contact+"' where id ='"+id+"' ");
			
			if(value>0)
			{
				System.out.println("Value Updated.......");
			}
			else
			{
				System.out.println("Value Not Updated");
			}
		}
		else
		{
			System.out.println("Database is not connected");
		}
		
	}

}
