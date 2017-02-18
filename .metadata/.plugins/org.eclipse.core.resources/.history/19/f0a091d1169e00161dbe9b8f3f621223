package org.Killpack.java.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class dbConnect {
	
	

	//------------------------------------------Set up database to use-------------------------------------------------//
		
	
	
	public static void connectDatabase(){
		// JDBC driver name and database URL
	    final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	    final String DB_URL="jdbc:mysql://localhost:3306/Customer?useSSL=false";

	    //  Database credentials
	    final String USER = "hbstudent";
	    final String PASS = "hbstudent";
	  
	    try{
	    // Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    // Open a connection
	    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    }
	     catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}

}}

