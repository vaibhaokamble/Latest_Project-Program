package vaibhao.vk;

import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.function.IntFunction;

public class File_Data {

	public static void main(String[] args) throws Exception {
	com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
	
	DriverManager.registerDriver(driver);
	
	Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
	
	if (connection!=null) {
		File file = new File("D:\\Online\\pointer.txt");
		
		FileReader fReader= new FileReader(file);
		
		PreparedStatement stmt = connection.prepareStatement("insert into storefile values('0',?,?)");
		
		stmt.setString(1, "introduction of pointer");
		
		int l =(int)file.length();
		
		stmt.setCharacterStream(2, fReader,l);
		
		int value = stmt.executeUpdate();
		
		if (value>0) {
			System.out.println("Save...........");
		}
		else {
			System.out.println("Failed.......");
		}
		
		
	}
	else {
		System.out.println("Not Connected");
	}
	}

}
