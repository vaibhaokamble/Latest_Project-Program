package vaibhao.vk;

import java.sql.*;

public class JDBC_Connection_App {

	public static void main(String[] args)throws Exception {
	
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(d);
		
		System.out.println("Successfully Install Driver.....");
	
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		
		if (connection!=null) {
			
//			System.out.println("Database is Connected");
			
			Statement statement = connection.createStatement();
			
			int value = statement.executeUpdate("insert into demoemployee values('0','vaibhuuu','123123','111111')");
			
			if (value>0) {
				System.out.println("Data insert Success");
			}
			else {
				System.out.println("Some Problem is There");
			}
		}
		else {
			System.out.println("Database is not connected******");
		}
		
	}

}
