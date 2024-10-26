package vaibhao.vk;

import java.io.*;
import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBC_Properties_Application {

	public static void main(String[] args) throws Exception {
		
		InputStream inf = new FileInputStream("D:\\NEW ECLIPSE\\JDBC_Maven_Properties\\src\\main\\resources\\test.properties");
		
		Properties p = new Properties();
		
		p.load(inf);
		
		System.out.println("File Load Successfull.............");
		
		String  driverClassName = p.getProperty("driver");
		
		String urlname = p.getProperty("url");
		
		String username = p.getProperty("username");
		
		String password = p.getProperty("password");
		
		Class.forName(driverClassName);
		
		Connection con = DriverManager.getConnection(urlname,username,password);
		
		if(con!=null) {
			System.out.println("Connected...........");
		}
		else {
			System.out.println("Not Connected");
		}
		
	}

}
