package vaibhao.vk;

import java.sql.*;

public class JDBC_DeleteApplication {

	public static void main(String[] args) {
		
		Connection conn= null;
		Statement stmt= null;
		
		try {
			com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
			
			if (conn!=null) {
				stmt = conn.createStatement();
				
				int value= stmt.executeUpdate("delete from register where rid='5' ");
				
				if (value>0) {
					System.out.println("Record Deleted Successfully........");
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
