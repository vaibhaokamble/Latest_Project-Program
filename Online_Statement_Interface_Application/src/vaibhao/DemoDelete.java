package vaibhao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DemoDelete {

	public static void main(String[] args) {

		Connection conn=null;
		Statement stmt=null;
		
		try {
			com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
			if (conn!=null) {
				Scanner v= new Scanner(System.in);
				
				stmt=conn.createStatement();
			
				System.out.println("Enter the email");
				String e = v.nextLine();
				
				int value= stmt.executeUpdate("delete from register where email='"+e+"'");
				
				if (value>0) {
					System.out.println("Recored deleted");
				}
				else {
					System.out.println("Some problem is there");
				}
			}
			else {
				System.out.println("Not connected");
			}
		} catch (Exception e) {
			System.out.println("error is "+e);
		}

	}

}
