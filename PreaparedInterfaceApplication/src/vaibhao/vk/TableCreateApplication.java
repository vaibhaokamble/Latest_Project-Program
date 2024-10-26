package vaibhao.vk;

import java.util.*;

import java.sql.*;


public class TableCreateApplication {

	public static void main(String[] args)throws Exception {
	 
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		if(conn!=null) {
			Statement stmt=conn.createStatement();
			int value=stmt.executeUpdate("create table empjdbc(name varchar(200),email varchar(200),contact varchar(200))");
			System.out.println(value);
		}
		else {
			System.out.println("Not Connected");
		}
	} 
}
