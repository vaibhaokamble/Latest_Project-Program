package vaibhao.vk;

import java.sql.*;

import java.util.Scanner;


public class JDBC_Withname_App {

	public static void main(String[] args) throws Exception{

		com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		
		if (connection!=null) {
			
			Statement statement=connection.createStatement();
			
			Scanner v = new Scanner(System.in);
			
			System.out.println("Enter the Name");
			String name= v.nextLine();
			System.out.println("Enter the Contact");
			String contact= v.nextLine();
			System.out.println("Enter the Salary");
			String salary= v.nextLine();
			
			int value = statement.executeUpdate("insert into demoemployee values('0','name','contact','salary')");
			
			if (value>0) {
				System.out.println("Record Insert Successfully....");
			}
			else {
				System.out.println("Some Problem is There");
			}
		}
		else {
			System.out.println("Database is not connected");
		}
		
	}

}