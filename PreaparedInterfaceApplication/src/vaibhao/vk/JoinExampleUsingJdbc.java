package vaibhao.vk;

import java.util.*;

import java.sql.*;

public class JoinExampleUsingJdbc {

	public static void main(String[] args)throws SQLException {
		 com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		 DriverManager.registerDriver(d);
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		 if(conn!=null) {
			 PreparedStatement stmt=conn.prepareStatement("select c.cname ,s.name,s.address,s.contact from course c inner join student s on c.cid=s.cid");
			 ResultSet rs=stmt.executeQuery();
			 while(rs.next()) {
				 System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				 
			 }
		 }
		 else {
			 System.out.println("Not Connected");
		 }
	}

}
