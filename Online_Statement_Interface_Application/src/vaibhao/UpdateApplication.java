package vaibhao;

import java.sql.*;
import java.util.*;

public class UpdateApplication {

	public static void main(String[] args) throws Exception {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online", "vaibhaovk", "vaibhao");
		if (conn != null) {
			Scanner v = new Scanner(System.in);
			System.out.println("Enter the name");
			String name = v.nextLine();
			System.out.println("Enter the contact");
			String contact = v.nextLine();
			System.out.println("Enter the email");
			String email = v.nextLine();
			Statement stmt = conn.createStatement();
			int value = stmt.executeUpdate(
					"update register set name='" + name + "',contact='" + contact + "' where email='" + email + "'");
			if (value > 0) {
				System.out.println("Record Update Successful");
			} else {
				System.out.println("Some Problem Is There");
			}
		} else {
			System.out.println("database is not Connected");
		}

	}

}