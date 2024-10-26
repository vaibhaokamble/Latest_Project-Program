package vaibhao;

import java.util.*;
import java.sql.*;

public class UpdateApplication {

	public static void main(String[] args) throws Exception {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eclipse", "vaibhaovk", "vaibhao");
		if (conn != null) {
			Scanner xyz = new Scanner(System.in);
			System.out.println("Enter name contact and email");
			String name = xyz.nextLine();
			String contact = xyz.nextLine();
			String email = xyz.nextLine();
			PreparedStatement stmt = conn.prepareStatement("update register set name=?,contact=? where email=?");
			stmt.setString(1, name);
			stmt.setString(2, contact);
			stmt.setString(3, email);
			int value = stmt.executeUpdate();
			if (value > 0) {
				System.out.println("Record updated success");
			} else {
				System.out.println("Some problem is there");
			}
		} else {
			System.out.println("Not Connected");
		}
	}

}