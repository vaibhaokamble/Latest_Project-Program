package vaibhao.vk;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
public class DemoApp {

	public static void main(String[] args) throws Exception {

		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "vaibhaovk", "vaibhao");
		if (conn != null) {
			PreparedStatement stmt;
			Scanner xyz = new Scanner(System.in);
			System.out.println("Enter the name");
			String name = xyz.nextLine();
			System.out.println("Enter the email");
			String email = xyz.nextLine();
			System.out.println("Enter the contact");
			String contact = xyz.nextLine();
			stmt = conn.prepareStatement("insert into register values('0',?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, contact);
			int val = stmt.executeUpdate();
			if (val > 0) {
				System.out.println("Record Save Success.................");
			} else {
				System.out.println("Some problem is there..........................");
			}
		} else {
			System.out.println("Not Connected");
		}
	}
}
