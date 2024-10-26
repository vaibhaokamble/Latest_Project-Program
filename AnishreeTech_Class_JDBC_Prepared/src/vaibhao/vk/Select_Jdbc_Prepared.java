package vaibhao.vk;

import java.util.*;
import java.sql.*;

public class Select_Jdbc_Prepared {

	public static void main(String[] args) throws Exception {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(d);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree", "vaibhaovk", "vaibhao");
		
		if (conn != null) {
		
			Scanner v = new Scanner(System.in);
			
			System.out.println("Enter the name");
			
			String name = v.nextLine();
			
			PreparedStatement stmt = conn.prepareStatement("select *from demo where name=?");
			
			stmt.setString(1, name);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) 
			{
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			} 
			else 
			{
				System.out.println("Record not found");
			}
		} 
		else 
		{
			System.out.println("Not Connected");
		}
	}

}
