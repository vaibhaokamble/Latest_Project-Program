package vaibhao.vk;

//step1
import java.sql.*;
import java.util.Scanner;

public class Insert_Record_Application {

	public static void main(String[] args) {
		Connection connection=null;
		Statement stmt=null;
		//strp2
		try {
			com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/online","vaibhaovk","vaibhao");
			
			//step3
			if (connection!=null) {
				Scanner v = new Scanner(System.in);
				System.out.println("Enter Student name email and contact");
				String name= v.nextLine();
				String email= v.nextLine();
				String contact = v.nextLine();
				
				stmt=connection.createStatement();
				
				//step4
				int value=stmt.executeUpdate("insert into students  values('0', '"+name+"','"+email+"','"+contact+"')");
				
				if (value>0) {
					System.out.println("Record Save Successfully........");
				}
				else {
					System.out.println("Some problem is there.....");
				}
			}
			else {
				System.out.println("Not Connected");
			}
		} catch (Exception exp) {
			System.out.println("" +exp);
		}
	}
}