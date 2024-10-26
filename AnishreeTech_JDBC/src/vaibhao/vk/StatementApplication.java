package vaibhao.vk;
import java.sql.*;
public class StatementApplication {

	public static void main(String[] args) throws Exception {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		if (conn !=null) {
			Statement stmt= conn.createStatement();
			
			int value=stmt.executeUpdate("insert into register values ('0','vaibhaovk','vaibhaovk@gmail.com','9823844512')");
			
			if (value>0) {
				System.out.println("Recored Save");
			}
			else {
				System.out.println("Some problem is there");
			}
		}
		else {
			System.out.println("Not Connected......");
		}
	}

}
