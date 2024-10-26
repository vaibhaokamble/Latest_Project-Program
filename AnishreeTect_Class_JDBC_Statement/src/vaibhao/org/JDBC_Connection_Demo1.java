package vaibhao.org;

import java.sql.*;

public class JDBC_Connection_Demo1 {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(d);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		
		if(conn!= null) {
			System.out.println("Database is Connected.......");
		}
		else
		{
			System.out.println("Database is Not Connected");
		}

	}

}
