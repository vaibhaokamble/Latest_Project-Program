package vaibhao.vk;

import java.sql.*;

public class CallProApplication {

	public static void main(String[] args) throws Exception {
		com.mysql.cj.jdbc.Driver driver= new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		
		if (conn!=null) {
			CallableStatement cstmt = conn.prepareCall("{call saverrecord(?,?,?)}");
			
			cstmt.setString(1, "riya");
			cstmt.setString(2, "riya.com");
			cstmt.setString(3, "1111111");
			
			boolean vk = cstmt.execute();
			
			if (!vk) {
				System.out.println("Procedure Save.......");
			}
			else {
				System.out.println("Procedure Not Save......");
			}
		}
		else {
			System.out.println("Not connected..............");
		}
	}

}
