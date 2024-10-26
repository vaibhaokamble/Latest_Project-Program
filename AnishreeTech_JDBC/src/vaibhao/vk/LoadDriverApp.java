package vaibhao.vk;

import java.sql.*;
public class LoadDriverApp {

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		System.out.println("Loaded Successfull");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		if (conn != null) {
			System.out.println("Connected Successfull.....");
		}
		else {
			System.out.println("Not Connected......");
		}
	}

}
