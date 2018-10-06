package ca.mcgill.ecse321.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:postgresql://ec2-23-23-80-20.compute-1.amazonaws.com:5432/dab7909qv6f7sf";
		String user = "tkjwrcqywqrang";
		String pass = "535906b0fd563114de396931b3401eb924288cc4d3572f0297e7b77b4e5570c5";
		
		try {
			
			System.out.println("Connecting to database" + jdbcUrl);
			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection succesful!");
			
		} catch (Exception exc){
			exc.printStackTrace();
		}
		
		
	}

}
