package vaibhao.vk;

import java.sql.*;

public class LoadApplication {

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		System.out.println("Driver Loaded Successfully.......");
	}

}
