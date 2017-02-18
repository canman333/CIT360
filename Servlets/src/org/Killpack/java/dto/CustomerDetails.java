package org.Killpack.java.dto;
/*
 * This will be our model class
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
 * Java Annotations
 * 1.) Map class to database table
 * 2.) Map fields to database columns
 */

// @Entity tells Hibernate to treat this class as an Entity class
//Entity class is a java class that is mapped to a database tables
//@Table(name = "CustomerDetails" to map the the name of the class to table. If the class is the same name as the table @Table
//is not necessary
@Entity
public class CustomerDetails {

	//@Id tells the customerId will be the Primary key of the object
	@Id
	@Column(name = "id")
	public int customerId;
	
	@Column(name="first_name")
	public String firstName;
	
	@Column(name="last_name")
	public String lastName;
	
	@Column(name="phone_number")
	public int phoneNumber;
	
	public int getId(){
		return customerId;
	}
	
	public void setId(int customerId){
		this.customerId = customerId;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}	
		
	public String getlastName(){
			return lastName;
	}
		
	public void setLastName(String lastName){
			this.lastName = lastName;		
	}
	
	public int getNumber(){
		return phoneNumber;
	}
	
	public void setNumber(int phoneNumber){
		this.phoneNumber = phoneNumber;		
	}

	@Override
	public String toString() {
		return "CustomerDetails [customerId=" + customerId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
}