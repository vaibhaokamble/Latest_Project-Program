package vaibhao.vk;

import java.sql.*; //step 1
public class ConnectionApplication {

	public static void main(String[] args) throws Exception { //step 2
		
		com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();  //step 3
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		//step 4
		if (connection!=null) {
			System.out.println("Connected Successfully.....");
		}
		else {
			System.out.println("Not Connected......");
		}
	}

}
