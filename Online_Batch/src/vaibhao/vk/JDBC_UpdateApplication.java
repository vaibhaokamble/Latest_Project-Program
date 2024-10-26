package vaibhao.vk;

import java.sql.*;

public class JDBC_UpdateApplication {

	public static void main(String[] args) {
		
		Connection conn= null;
		Statement stmt= null;
		
		try {
			com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
			
			if (conn!=null) {
				stmt = conn.createStatement();
				
				int value= stmt.executeUpdate("update register set name = 'divya' where rid= '6' ");
				
				if (value>0) {
					System.out.println("Record Updated Successfully........");
				}
				else {
					System.out.println("Some problem is there");
				}
			}
			else {
				System.out.println("Not Connected");
			}
			
		} catch (Exception e) {
			System.out.println("Error is " +e);
		}

	}

}
