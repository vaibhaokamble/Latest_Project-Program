package vaibhao;

import java.sql.*;

public class LoadingDriverApplication {

	public static void main(String[] args) throws Exception {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eclipse", "vaibhaovk", "vaibhao");
		if (conn != null) {
			System.out.println("Database is connected");
		} else {
			System.out.println("Database is not connected");
		}
	}

}