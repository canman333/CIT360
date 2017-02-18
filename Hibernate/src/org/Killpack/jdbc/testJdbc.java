package org.Killpack.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

//This class tests the database connection
public class testJdbc {

	public static void main(String[] args) {
		
		//hb_student_tracker is the name of a database created in mysql
		//String jdbcUrl gets the JDBC connection URL
		String jdbcUrl = "jdbc:mysql://localhost:3306/Customer?useSSL=false";
		
		//username and password of user we created on the hb_student_tracker database
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try{
			System.out.println("Connecting to database: " + jdbcUrl);
			
			//pass in the JDBC with username and password to the method getconnection()
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			//Print out Connection Successful if we get connection to the database
			System.out.println("Connection Successful!");
			
		}
		catch (Exception ex){
			ex.printStackTrace();
		}

	}

}
