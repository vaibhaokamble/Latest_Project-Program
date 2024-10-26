package vaibhao.vk;

import java.util.*;

import java.sql.*;

public class JDBC_Update_App {
	public static void main(String[] args) {
		try {
			com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree", "vaibhaovk", "vaibhao");
			if (conn != null) {
				Scanner xyz = new Scanner(System.in);
				System.out.println("enter id name and run of player");
				int id = xyz.nextInt();
				String name = xyz.next();
				int run = xyz.nextInt();
		Statement stmt = conn.createStatement();
int value = stmt.executeUpdate("update player set name='" + name + "',run=" + run + " where pid=" + id);
				if (value!=0) {
					System.out.println("Record Updated Success......");
				} else {
					System.out.println("Some problem is there................");
				}
			} else {
				System.out.println("Database is not connected");
			}
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
		}
	}

}
