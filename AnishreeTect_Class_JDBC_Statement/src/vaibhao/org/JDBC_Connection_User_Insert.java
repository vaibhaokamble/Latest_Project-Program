package vaibhao.org;

import java.sql.*;

import java.util.*;

public class JDBC_Connection_User_Insert {

	public static void main(String[] args) throws Exception  {
		
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(d);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		
		if(conn!=null) {
			Statement stmt = conn.createStatement();
			
			Scanner v = new Scanner(System.in);
			
			System.out.println("Enter the name");
			String name = v.nextLine();
			
			System.out.println("Enter the conact");
			String contact = v.nextLine();
			
			//SQL Injuction
			int value = stmt.executeUpdate("insert into demo values ('"+0+"','"+name+"','"+contact+"')");
			
			if(value>0)
			{
				System.out.println("Inserted User Values..........");
			}
			else
			{
				System.out.println("Failed...........");
			}
			
			
		}
		else
		{
			System.out.println("Database is not connected");
		}

	}

}
