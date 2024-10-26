package vaibhao.vk;

import java.util.*;
import java.sql.*;

public class UpdateApplication {
    public static void main(String[] args) throws Exception {
        // Registering the MySQL Driver
        com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(d);
        
        // Establishing the connection to the database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oct2023", "vaibhaovk", "vaibhao");

        if (conn != null) {
            // Accepting input from the user
            Scanner xyz = new Scanner(System.in);
            System.out.println("Enter id, name, email, and salary:");
            
            int id = xyz.nextInt();  // Read ID as an integer
            xyz.nextLine();  // Consume newline after the int
            String name = xyz.nextLine();  // Read name as a string
            String email = xyz.nextLine();  // Read email as a string
            int salary = xyz.nextInt();  // Read salary as an integer

            // Preparing the SQL statement
            PreparedStatement stmt = conn.prepareStatement("UPDATE register SET name=?, email=?, salary=? WHERE id=?");

            // Setting the values for the prepared statement
            stmt.setString(1, name);  // Set name
            stmt.setString(2, email);  // Set email
            stmt.setInt(3, salary);  // Set salary
            stmt.setInt(4, id);  // Set ID

            // Executing the update
            int value = stmt.executeUpdate();

            // Checking if the update was successful
            if (value > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("Some problem occurred.");
            }
        } else {
            System.out.println("Not Connected to the database.");
        }
    }
}
