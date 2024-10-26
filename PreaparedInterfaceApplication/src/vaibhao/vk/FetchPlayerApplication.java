package vaibhao.vk;

import java.sql.*;

public class FetchPlayerApplication {
	public static void main(String[] args) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/anishree","vaibhaovk","vaibhao");
		if(conn!=null) {
			Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery("select *from employee where salary>80000 and salary>100000");
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int contact =rs.getInt(3);
				int salary =rs.getInt(4);
			System.out.println(id+"\t"+name+"\t"+ contact +"\t"+salary);
			}
		}
		else {
			System.out.println("Database is not connected");
		}
	}

}
