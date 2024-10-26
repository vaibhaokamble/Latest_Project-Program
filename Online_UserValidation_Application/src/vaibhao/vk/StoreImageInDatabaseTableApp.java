package vaibhao.vk;

import  java.sql.*;
import  java.io.*;
public class StoreImageInDatabaseTableApp {

	public static void main(String[] args)throws SQLException,IOException,ClassNotFoundException {
		 com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
		 DriverManager.registerDriver(d);
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		 if(conn!=null) {
			 File f = new File("D:\\Online\\a.png");
			 FileInputStream finf=new FileInputStream(f);
			 PreparedStatement stmt=conn.prepareStatement("insert into storageImage values('0',?)");
			 stmt.setBinaryStream(1, finf,f.length());
			 int value=stmt.executeUpdate();
			 if(value>0) {
				 System.out.println("Image save in database table");
			 }
			 else {
				 System.out.println("Some problem is there............");
			 }
		 }
	}
}
