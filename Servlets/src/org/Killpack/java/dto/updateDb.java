package org.Killpack.java.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class updateDb {

	
	//------------------------------------------Set up database to use-------------------------------------------------//
		
	public static void database(long id, String firstName, String lastName, long phoneNumber){
	dbConnect.connectDatabase();
		
		//Cast to integer (needs to be the same type as the database type)
	    int customerId = (int) id;
	    int phoneNum = (int) id;
	    
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
}
