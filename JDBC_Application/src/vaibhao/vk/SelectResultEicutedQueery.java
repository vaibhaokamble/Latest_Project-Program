package vaibhao.vk;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.jdbc.Driver;
public class SelectResultEicutedQueery {

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","vaibhaovk","vaibhao");
		if (connection!=null) {
			PreparedStatement pstm= connection.prepareStatement("select * from employee");
			ResultSet rSet = pstm.executeQuery();
			while(rSet.next()) {
				System.out.println(rSet.getInt(1)+"\t"+rSet.getString(2)+"\t"+rSet.getInt(3));
			}
		}
		else {
			System.out.println("Not connected.....");
		}
	}
}
