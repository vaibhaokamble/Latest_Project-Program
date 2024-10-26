package vaibhao;

import java.sql.*;

public class Demo_Select_App {

	public static void main(String[] args) throws Exception {


		com.mysql.cj.jdbc.Driver driver= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		Connection conn;
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		
		if (conn!=null) {
			Statement stmt=conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from register");
			
			while (rs.next()) {
			System.out.println(rs.getInt(1)+ "\t" + rs.getString(2)+"\t"+ rs.getString(3)+"\t" + rs.getString(4));	
			}
			
		}
		else {
			System.out.println("Database is not COnnected");
		}
		
	}

}
