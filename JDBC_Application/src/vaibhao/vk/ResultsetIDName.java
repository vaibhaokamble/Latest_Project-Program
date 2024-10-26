package vaibhao.vk;
import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ResultsetIDName {

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost;3306/practice","vaibhaovk","vaibhao");
		if (connection!=null) {
			Scanner v= new Scanner(System.in);
			System.out.println("Enter employee id");
			int id=v.nextInt();
			System.out.println("Enter employee name");
			String name=v.nextLine();
			PreparedStatement pstm=connection.prepareStatement("select salary from employee where  id=? and name=?");
			pstm.setInt(1, id);
			pstm.setString(2, name);
			ResultSet rSet=pstm.executeQuery();
			if (rSet.next()) {
				System.out.println("Employee Salary is : "+rSet.getInt(1));
			}
			else {
				System.out.println("There is no employee found");
			}
		}
		else {
			System.out.println("NO database connected");
		}
	}
}
