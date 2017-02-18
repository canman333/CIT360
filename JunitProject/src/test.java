import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class test {
	
	student Billy;
	student Jane;
	student John;
	student Mario;
	student Maria;
	int compareSize;
	
	
	@Before
	public void beforetest() throws Exception{
		Billy = new student(1, "Billy", "Bob");
		Jane = new student(2, "Jane", "Smith");
		John = new student(3, "John", "Hanson");
		Mario = new student(4, "Mario", "Plumber");
		Maria = new student(5, "Maria", "Gonzalez");
	}
	
	@Test
	public void trueTest() {
		//create BillyTwin object for testing
		student BillyTwin = new student(6, "Billy", "Bob");
		
		// Test if condition is true between the Billy and BillyTwin object
		assertTrue(Billy.studentId != BillyTwin.studentId);
	}
	
	@Test
	public void falseTest() {
		//create BillyTwin object for testing
		student BillyTwin = new student(6, "Billy", "Bob");
		
		// Test if condition is false between the Billy and BillyTwin object
		assertFalse(Billy.studentId == BillyTwin.studentId);
	}

	/*
	 * Lastly, you must create a method of another class stores values in a private property that is one of the collection 
	 * types. You must then test that when the method is called the value is stored in the colletion. You must do this without 
	 * writing a getter for the value or the collection ( See the book for an example of how to temporarily make a private 
	 * property public). This instruction done in the first test unit below called equals()
	 */
	@Test
	public void equals() {
		//Check to see if the size of HashMap is correct after adding the Billy student
		testStudent billyStudent = new testStudent();
		billyStudent.addStudent(Billy);
		compareSize = billyStudent.getSize();
		assertEquals(1, compareSize);
		
		//Check to see if the size of the HashMap is correct after inputing all student objects
		testStudent compareAll = new testStudent();
		compareAll.addStudent(Billy);
		compareAll.addStudent(Jane);
		compareAll.addStudent(John);
		compareAll.addStudent(Mario);
		compareAll.addStudent(Maria);
		compareSize = compareAll.getSize();
		assertEquals(5, compareSize);
	}
	
	@Test
	public void notEquals() {
		//create objects for testing
		testStudent test = new testStudent();
		testStudent compare = new testStudent();
		
		// These two are seperate objects they are not equal
		assertNotEquals(test, compare);
	}
	
	@Test
	public void sameReference() {
		//create BillyTwin object for testing
		student BillyTwin = new student(1, "Billy", "Bob");
		
		//This will fail assertSame checks that two objects refer to the same object
		//assertSame(Billy, BillyTwin);
		
		//Now BillyTwin references Billy, Both Billy and BillyTwin reference the same Billy Object now
		BillyTwin = Billy;
		
		//This will pass
		assertSame(Billy, BillyTwin);
	}
	
	@Test
	public void noSameReference() {
		//create BillyTwin object for testing
		student BillyTwin = new student(1, "Billy", "Bob");
		
		//This will pass because the two objects have different references
		assertNotSame(Billy, BillyTwin);
		
	}
	
	/*
	 * Also you must create a unit test that calls a method of some other class which throws an exception and test that 
	 * an exception was thrown. Completed with the test below
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testError(){
		//Create object of the testStudent class
		testStudent test = new testStudent();
		//add my illegal argument
		test.addIllegalArg("Illegal");
		
	}
	
	//For testing purposes, to see what was going on in my first test with my compareSize variable
	@After
	public void print(){
	System.out.println(compareSize);
	}
	
}
