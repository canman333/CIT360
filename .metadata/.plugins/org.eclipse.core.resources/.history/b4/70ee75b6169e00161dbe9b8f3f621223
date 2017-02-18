package org.Killpack.java.dto;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.Killpack.java.dto.CustomerDetails;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 * Servlet implementation class ServlettExample
 * @param <JSONInputStream>
 */
//the URL tells Tomcat to run the java class when /ServlettExample is accessed
@WebServlet("/ServlettExample")
public class ServlettExample<JSONInputStream> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//default method is the doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("application/json");
	
	//Create a PrintWriter to write to Servlett
	PrintWriter writer = response.getWriter();
	
	//make request to get my json and store it in string
	String myJson = request.getParameter("json");
	
	//Create json object and json parser
	JSONObject object = new JSONObject();
	JSONParser parse = new JSONParser();
	
	//declare variables
	long id = 0;
	String firstName = null;
	String lastName = null;
	long phoneNumber;
	
	try {
		//parse the json to a JSONObject
		object = (JSONObject) parse.parse(myJson);
		
		//Grab the value from the root key
		String root = (String) object.get("root");
		
//----------JSON TO BE STORED IN DATABASE---------------------------------------//
		
		//request to get json store it in string variable
		String dataDb = request.getParameter("jsonCustomer");
		
		//create JSONObject
		JSONObject object1 = new JSONObject();
		//parse json string to JSONObject
		object1 = (JSONObject) parse.parse(dataDb);
		//grab values from JSON keys and store them in variables
		id = (long) object1.get("id");
		firstName = (String) object1.get("firstName");
		lastName = (String) object1.get("lastName");
		phoneNumber = (long) object1.get("phoneNumber");
		//Print to servlet values of the json
		writer.println("value from the doGet method JSON: " + root);
		writer.println();
		writer.println("CustomerDetails id: " + id); 
		writer.println("CustomerDetails first_name: " + firstName); 
		writer.println("CustomerDetails last_name: " + lastName);
		writer.println("CustomerDetails phone_number: " + phoneNumber);
				
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	//------------------------------------------Set up database to use-------------------------------------------------//
	// JDBC driver name and database URL
    final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    final String DB_URL="jdbc:mysql://localhost:3306/Customer?useSSL=false";

    //  Database credentials
    final String USER = "hbstudent";
    final String PASS = "hbstudent";
  
    //Cast to integer (needs to be the same type as the database type)
    int customerId = (int) id;
    int phoneNum = (int) id;
    try{
    // Register JDBC driver
    Class.forName("com.mysql.jdbc.Driver");

    // Open a connection
    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    
    //create sessionFactory
    SessionFactory sessionFactory = 
    		new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CustomerDetails.class).buildSessionFactory();
    
    //Open new session of the sessionFactory object
    Session session = sessionFactory.getCurrentSession();
  	session = sessionFactory.getCurrentSession();
	session.beginTransaction();
    
	//create object from CustomerDetails class and set its attributes
    CustomerDetails customer = new CustomerDetails();
	customer.setId(customerId);
	customer.setFirstName(firstName);
	customer.setLastName(lastName);
	customer.setNumber(phoneNum);
	
	//Save the customer object to database
	session.save(customer);
	
	//Need to commit and close transaction
	session.getTransaction().commit();
			
		}

		catch (HibernateException exception) {
			System.out.println("Problem creating session factory");
			exception.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}

		writer.flush();
		writer.close();
	}
		
		//Post method to pass parameters
		//to create a post request we need an html form (dataFile.html)
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			
			//Create a PrintWriter to write to Servlett
			PrintWriter write = response.getWriter();
			
			//passing parameters to a servlett
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			Long number = Long.parseLong(request.getParameter("number"));
			
			//stores the status of the customer (preferred or regular)
			String status = request.getParameter("status");
			
			//Create session to save data in browser
			HttpSession session = request.getSession();
			
			//Set values to the session
			session.setAttribute("sessionFirst", firstName);
			session.setAttribute("sessionLast", lastName);
			session.setAttribute("sessionAddress", address);
			session.setAttribute("sessionCity", city);
			session.setAttribute("sessionState", state);
			session.setAttribute("sessionNumber", number);
			session.setAttribute("sessionStatus", status);
			
			//print out results of the form for verification
			write.println("<h2>Customer created successful!!!</h2> <br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<h3>Printing out form results for verification......</h3> <br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("Customer's First Name is " + (String) session.getAttribute("sessionFirst"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("Customer's Last Name is " + (String) session.getAttribute("sessionLast"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("Customer's Street Address is " + (String) session.getAttribute("sessionAddress"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("City is " + (String) session.getAttribute("sessionCity"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("State is " + (String) session.getAttribute("sessionState"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("Customer's Phone Number is " + (long) session.getAttribute("sessionNumber"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");
			write.println("<br>");
			write.println("Customer is a " + (String) session.getAttribute("sessionStatus"));
			write.println("<br>");
			write.println("----------------------------------------------------------------------------------------------------");		
			
	}

}
