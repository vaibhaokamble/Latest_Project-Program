package vaibhao.vk;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBC_Connector {

	public static void main(String[] args) throws Exception {
		
		InputStream inf = new FileInputStream("D:\\NEW ECLIPSE\\Maven_JDBC_Application\\src\\main\\resources\\test.properties");
		
//		InputStream inf = new FileInputStream("test.properties");
		
		Properties p = new Properties();
		
		p.load(inf);
		
		System.out.println("File load................");
		
		String  driverClassName = p.getProperty("driver");
		
		String urlname = p.getProperty("url");
		
		String username = p.getProperty("username");
		
		String password = p.getProperty("password");
		
		Class.forName(driverClassName);
		
		Connection conn = DriverManager.getConnection(urlname, username, password);
		
		if(conn!=null) {
			System.out.println("Successfully Connected............");
		}
		else {
			System.out.println("Not Connected.........");
		}
		
	}

}
