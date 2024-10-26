package vaibhao.vk;

//step 1
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_ConnectionApplication {

	//step2 throws Exception or Try and Catch and Finally
	public static void main(String[] args) throws Exception {
		
		
		com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		
		if (conn != null) {
			System.out.println("database is connected");
			//step3
			//statement interface
			Statement stmt= conn.createStatement();
			
			int value=stmt.executeUpdate("insert into register  values ('0','kunal','kunal@gmail.com')");
			//step4
			if (value>0) {
				System.out.println("Save Recored........");
			}
			else {
				System.out.println("Some Problem is there");
			}
//			System.out.println("some error");
		}

	}

}
