package vaibhao.vk;

import java.util.*;

import java.sql.*;

public class Fetch_Player_Data {
	public static void main(String[] args) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		if(conn!=null) {
			Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery("select * from player ");
			while(rs.next()) {
				int pid=rs.getInt(1);
				String pname=rs.getString(2);
				int run =rs.getInt(3);
			System.out.println(pid+"\t"+pname+"\t"+run);
			}
		}
		else {
			System.out.println("Database is not connected");
		}
	}

}
