//Steps to using the Hibernate API
/*
* 1.) Create a session factory (one object per application, it creates sessions, you get a session from the session 
* factory to save something to the database
* 2.) Create sessions from the session factory
* 3.) Use the session to save model objects
* 
* Additional Notes: to get rid of rows in a database and reset counter to one issue truncate [datbase] [table] in mysql
*/
package org.Killpack.hibernate;



import org.Killpack.java.dto.CustomerDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;
import java.util.*;

public class HibernateTest {

	public static void main(String[] args) {
		
		//Create session factory object
		//Configuration goes to our XML configuration and calls the configure method the build session factory returns a session object
		SessionFactory sessionFactory = 
		new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CustomerDetails.class).buildSessionFactory();
		
		//Open new session of the sessionFactory object
		Session session = sessionFactory.getCurrentSession();
			
			//Happy Path: Create Customer object of id 1
			CustomerDetails customer = new CustomerDetails();
			customer.setId(1);
			customer.setFirstName("Casey");
			customer.setLastName("Killpack");
			customer.setNumber(2085553434);
			
			//nasty path: no negative numbers for id
			//Create another Customer object to test a negative id 
			CustomerDetails customer2 = new CustomerDetails();
			//nasty path: Not good practice to assign a negative id
			customer2.setId(-100);
			customer2.setFirstName("Negative");
			customer2.setLastName("Nancey");
			customer2.setNumber(2082245599);
			
			//Happy Path
			//Create another Customer object using the id of 2
			CustomerDetails customer3 = new CustomerDetails();
			customer3.setId(2);
			customer3.setFirstName("Billy");
			customer3.setLastName("Joe");
			customer3.setNumber(2086773424);
			
			//nasty path
			//Create another Customer object with duplicate id in database
			CustomerDetails customer4 = new CustomerDetails();
			//nasty path: duplicate id's are not possible in the database. The database will automatically increment the id
			//to a unique id
			customer4.setId(2);
			customer4.setFirstName("Juan");
			customer4.setLastName("Avila");
			customer4.setNumber(2086799424);
			
			//Create another Customer object for deletion
			CustomerDetails customer6 = new CustomerDetails();
			customer6.setId(50);
			customer6.setFirstName("delete");
			customer6.setLastName("remove");
			customer6.setNumber(2089999999);
			
			//Create another Customer object for deletion
			CustomerDetails customer7 = new CustomerDetails();
			customer7.setId(51);
			customer7.setFirstName("another_delete");
			customer7.setLastName("another_remove");
			customer7.setNumber(2089998888);
			
		//Happy Path: Create a transaction
		session.beginTransaction();
		
		//save customer objects to be committed to the database
		session.save(customer);
		
		try{
		//nasty path: negative id
		session.save(customer2);
		}
		catch(Exception ex){
			System.out.println("Error, cannot create object with negative id");
		}
		
		session.save(customer3);
		
		try{
		//nasty path: duplicate id
		session.save(customer4);
		}
		catch(Exception ex){
			System.out.println("Error, Cannot create object with duplicate id!");
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println();
		}
		
		session.save(customer6);
		session.save(customer7);
		
		//Need to commit and close transaction
		session.getTransaction().commit();
	
		
//-----------------------------------------------------------------------------------------------------------------------------//
		/* Retrieving object from database
		*  To retrieve an object from the database you retrieve it by it's id
		*/
		
		//Get a new session and start a transaction
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//Happy Path
		//retrieve student based on the id: primary key arguments are the class and the object id
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("Retrieving object with customer id of " + customer.getId());
		CustomerDetails myCustomer = session.get(CustomerDetails.class, customer.getId());
		
		//Print out object retrieved from the database in java
		System.out.println(myCustomer);
		System.out.println("--------------------------------------------------------------------------------------------------");
		
		try{
		//nasty path: Retrieving wrong primary key from object that does not exist
		System.out.println("Retrieving another object with customer id of 74");
		CustomerDetails testCustomer = session.get(CustomerDetails.class, 74);
		System.out.println(testCustomer);
		System.out.println("--------------------------------------------------------------------------------------------------");
		}
		catch(Exception ex){
			System.out.println("Error, customer id does not exist in database");
		}
		
		//commit the transaction
		session.getTransaction().commit();
		
	
		
//-----------------------------------------------------------------------------------------------------------------------------//
		//Create query in Hibernate this is called Hql
		
		//Get a new session and start a transaction
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//Happy Path: query the customers, query all object in database from the CustomerDetails table
		List<CustomerDetails> theCustomers = session.createQuery("from CustomerDetails").list();
		
		//Happy Path: display all customer objects
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("Printing out query contents....");
		for (CustomerDetails tempCustomer : theCustomers){
			System.out.println("Object: " + tempCustomer);
		}
		System.out.println("--------------------------------------------------------------------------------------------------");
		
		//Happy Path: get all objects of the CustomerDetails class where Killpack is the last name
		List<CustomerDetails> theCustomers2 = session.createQuery("from CustomerDetails c "
				+ "where c.lastName='Killpack'").list();
				
		//Happy Path: display all objects of the CustomerDetails class where Killpack is the last name
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("Printing out query contents....");
		for (CustomerDetails tempCustomer2 : theCustomers2){
		System.out.println("Object: " + tempCustomer2);
		}
		System.out.println("--------------------------------------------------------------------------------------------------");
		
		try{
		//nasty path: bad formatting within the createQuery method. Forgot to put a space in between the c and where
		List<CustomerDetails> theCustomers3 = session.createQuery("from CustomerDetails c"
						+ "where c.lastName='Killpack'").list();
						
		//Happy Path: display all objects of the CustomerDetails class where Killpack is the last name
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("Printing out query contents from nasty path....");
		for (CustomerDetails tempCustomer3 : theCustomers3){
		System.out.println("Object: " + tempCustomer3);
		}
		System.out.println("--------------------------------------------------------------------------------------------------");
		
		//commit the transaction
		session.getTransaction().commit();
		}
		catch(Exception ex){
			System.out.println("Error in query format");
		}
			
		
		
//-----------------------------------------------------------------------------------------------------------------------------//
		//Update object
		
		//Get a new session and start a transaction
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//declare variable to hold a customer id number
		int customerId = 1;			
		
		//Happy Path: retrieve the object you want to update		
		CustomerDetails upCustomer = session.get(CustomerDetails.class, customerId);	
		System.out.println("update: " + upCustomer);
		
		//Happy Path: Use your setter in your object to update the first name
		upCustomer.setFirstName("UPDATED");
		
		//Happy Path: commit the transaction: Once commited the firstname with its updated value 
		//saved in memory commits to the database
		session.getTransaction().commit();
		
		//Happy Path: bulk update using queries
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//Happy Path: update firstname for all customers
		session.createQuery("update CustomerDetails set lastName='UPDATED'").executeUpdate();	
		
		session.getTransaction().commit();
		
		//nasty path: update a row with different datatype
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		try{
				
		//nasty path: Updated a column that should be a name not a number
		session.createQuery("update CustomerDetails set lastName=" + 23).executeUpdate();
		session.getTransaction().commit();	
		}
		catch(Exception ex){
			System.out.println("Error, can't insert a number in for a name");
		}
		
		
		
//------------------------------------------------------------------------------------------------------------------------------//
		//Deleting Objects
		
		//Get a new session and start a transaction
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//Happy Path: retrieve object for deletion
		CustomerDetails delCustomer50 = session.get(CustomerDetails.class, 50);
		
		//Happy Path: delete object with id of 1
		System.out.println("Deleting Customer " + delCustomer50);
		session.delete(delCustomer50);
		
		//Happy Path: delete object using query
		System.out.println("Deleting Customer id = 51");
		session.createQuery("delete from CustomerDetails where id=51").executeUpdate();
		
		try{
		//nasty path: delete an object that does not exist
		System.out.println("nasty path: deleting object that does not exist");
		session.createQuery("delete from CustomerDetails where id=52").executeUpdate();
		}
		catch(Exception ex){
			System.out.println("Object does not exist. Cannot delete!");
		}
		
		//Commit deletion
		session.getTransaction().commit();

		}	

}
