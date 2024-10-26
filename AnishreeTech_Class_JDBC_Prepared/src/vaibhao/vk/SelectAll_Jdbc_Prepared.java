package vaibhao.vk;

import java.util.*;
import java.sql.*;

public class SelectAll_Jdbc_Prepared {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(d);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree", "vaibhaovk", "vaibhao");
		
		if (conn != null) {
		
			PreparedStatement stmt = conn.prepareStatement("select * from demo");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) 
			{
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3));
			}
		}
		else 
		{
			System.out.println("Not Connected");
		}

	}

}