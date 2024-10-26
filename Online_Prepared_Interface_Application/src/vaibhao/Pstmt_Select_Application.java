package vaibhao;
import java.sql.*;
public class Pstmt_Select_Application {

	public static void main(String[] args)  throws Exception{
		com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		Connection conn;
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		if (conn!=null) {
			PreparedStatement pstmt;
			pstmt=conn.prepareStatement("select * from register");
			ResultSet rs= pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
//				System.out.println(rs.getString("rid")+"\t"+rs.getString("email")+"\t"+rs.getString("name") +"\t"+rs.getInt("contact"));
			}
		}
		else {
			System.out.println("Not connected");
		}
		
	}

}
