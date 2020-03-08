package mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class NehsPizzaApplication {
	public static void main(String[] args) {
		connectionCheck();		//remove later
		SpringApplication.run(NehsPizzaApplication.class, args);
	}
	
	
	//remove later
	public static void connectionCheck() {
		String URL = "jdbc:mysql://localhost:3306/pizzadb";
		String USER = "root";
		String PASS = "root";
		Connection conn = null;
		try {
			//Class.forName("mysql.driver.");
			System.out.println("Connecting to Database!");
			conn = DriverManager.getConnection(URL, USER, PASS);
			
			System.out.println("connection established");
		} catch (Exception e) {
			System.out.println("DB not connected");
			e.printStackTrace();
		} finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					//ignore
				}
			}
		
	}
	
}
