package vaibhao.vk;

import java.util.*;

import java.sql.*;

public class JDBC_Delete_App {

	public static void main(String[] args)throws SQLException {
		  com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
		  DriverManager.registerDriver(d);
		  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		  if(conn!=null) {
			  Scanner xyz  = new Scanner(System.in);
			  System.out.println("enter id of player");
			  int id=xyz.nextInt();
			  Statement stmt=conn.createStatement();
			  
			  int value=stmt.executeUpdate("delete from player where pid="+id);
			  if(value>0) {
				  System.out.println("Record Deleted  Success......");
			  }
			  else {
				  System.out.println("Some problem is there................");
			  }
		  }
		  else {
			  System.out.println("Database is not connected");
		  }
		}

}
