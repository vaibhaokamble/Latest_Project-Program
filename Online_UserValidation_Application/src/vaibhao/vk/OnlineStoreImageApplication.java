package vaibhao.vk;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
public class OnlineStoreImageApplication {

	public static void main(String[] args) throws Exception {
		
		com.mysql.cj.jdbc.Driver driver= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
		

		if (conn!=null) {
			File  f = new File("D:\\Online\\a.png");
			
			FileInputStream finf=new FileInputStream(f);
			
			PreparedStatement pstmt= conn.prepareStatement("insert into storageimage values('0',?)");
			
			pstmt.setBinaryStream(1, finf,f.length());
			
			int value = pstmt.executeUpdate();
			
			if (value>0) {
				System.out.println("image save Success..........");
			}else {
				System.out.println("some problem is there");
			}
		}
		else {
			System.out.println("not connected");
		}
	}

}
