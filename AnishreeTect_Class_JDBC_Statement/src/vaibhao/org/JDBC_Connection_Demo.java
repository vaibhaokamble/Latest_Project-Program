package vaibhao.org;

import java.sql.*;


public class JDBC_Connection_Demo {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(d);
		
		System.out.println("Register Driver..........");
		
	}

}
