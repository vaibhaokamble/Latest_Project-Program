package vaibhao.vk;

import java.sql.*;

import java.util.*;

public class StorePlayerApp {

	public static void main(String[] args)throws SQLException {
		  com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
		  DriverManager.registerDriver(d);
		  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		  if(conn!=null) {
			  Scanner xyz  = new Scanner(System.in);
			  System.out.println("enter id name and run of player");
			  int id=xyz.nextInt();
			  String name=xyz.next();
			  int run=xyz.nextInt();
			  Statement stmt=conn.createStatement();
			  int value=stmt.executeUpdate("insert into player values("+id+",'"+name+"',"+run+")");
			  if(value>0) {
				  System.out.println("Record Save Success......");
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
