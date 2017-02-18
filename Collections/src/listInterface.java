import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class listInterface {
			
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberAmount;
		
		//Declare a LinkedList of Integer types
		List<Integer> myLinkedList = new LinkedList<Integer>(); 
		
		//Declare an ArrayList of Integer types
		List<Integer> myArrayList = new ArrayList<Integer>();
		
		//Create another ArrayList for nasty path testing
		List<Integer> testArray = new ArrayList<Integer>();
		
		System.out.println("Please enter the amount of numbers you want to store: ");
		System.out.println("NOTE: NEEDS TO BE AT LEAST MORE THAN 500,000 NUMBERS but less than 600,000 THAT YOU WANT TO STORE.");
		
		//retrieve input from user and store in numberAmount variables
		numberAmount = scanner.nextInt();
		
		//fill array list and linked list from the size specified from the user
		for(int i = 0; i < numberAmount; i++){
			myArrayList.add(i);
			myLinkedList.add(i);
		}
		
		//check to make sure the array and linked list were created successfully
		if (myArrayList.size() == numberAmount && myLinkedList.size() == numberAmount){
		System.out.println("Array List and Linked List CREATED with " + numberAmount + " elements.");
		}
		else
			System.out.println("THERE WAS AN ERROR, ABORT!!!! ABORT!!!!");
		
		//some formatting to make things look nicer
		for(int i = 0; i < 100; i++){
			System.out.print(".");
		}
		System.out.println();
		System.out.println("Removing the first 1,000 elements from an array list");
		
		//Bad code takes longer to remove from the beginning of an array list than a linked list.
		long aStart = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++){
			myArrayList.remove(i);
		}
		long aEnd = System.currentTimeMillis();
		
		//Print out the amount of time it takes to remove the first 50 elements
		System.out.println("Nasty Path: Amount of time to remove the first 50 elements of an array list: " + (aEnd - aStart) + " milliseconds");
		
		//Better code, a lot quicker in removing elements from the beginning of a list.
		long lstart = System.currentTimeMillis();
		for(int i = 0; i < 50; i++){
			myLinkedList.remove(i);
		}
		long lend = System.currentTimeMillis();
		
		//Print out the amount of time it takes to remove the first 50 elements
		System.out.println("Happy Path: Amount of time to remove the first 50 elements of a Linked list: " + (lend - lstart) + " milliseconds");

		//-------------adding to the ArrayList------------------//
		System.out.println();
		
		
		//Happy Path
		System.out.println("Adding to the testArray ArrayList");
		testArray.add(1);
		testArray.add(2);
		testArray.add(3);
		
		//print out testArray
		System.out.println("--------------------------------------------------------------------------------------");		
		for (int i = 0; i < testArray.size(); i++){
			System.out.println("Happy Path: Integer " + testArray.get(i) + " added to testArray");
		}
		System.out.println("--------------------------------------------------------------------------------------");		
		System.out.println("--------------------------------------------------------------------------------------");
		
		//Nasty Path: add element to a nonexistent index of the testArray
		try{
			testArray.add(20, 20);
		}
		catch(Exception ex){
			System.out.println("Nasty Path: Can't add element to a specified non-existent index");
		}
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------");
		
		//Nasty Path: Cannot add a string to an ArrayList with type integer
		try{
			//testArray.add(1, "A");
			System.out.println("Nasty Path: Cannot add a string to an ArrayList with type integer");
		}
		catch(Exception e){
			System.out.println("Nasty Path: Cannot add a string to an ArrayList with type integer");
		}
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------");
		
		//Nasty Path: adding a negative index to the array
		try{
			testArray.add(-1,20);
			for (int i = 0; i < testArray.size(); i++){
				System.out.print(testArray.get(i));
			}
		}
		catch(Exception e){
			System.out.println("Nasty Path: Adding a negative index to array");
		}
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------");
		
		//Nasty Path: add null to the array list
		try{
			testArray.add(null);
			System.out.println("Nasty Path: Adding a null value to an array");
		}
		catch(Exception ex){
			System.out.println("Nasty Path: Adding a null value to an array");
		}
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------");
		
		// Nasty Path: does not replace value at specified index, instead it adds an index and shifts elements up one
		try{
			testArray.add(1, 200);
			System.out.println("Elements in array after inserting into index 1");
			for (int i = 0; i < testArray.size(); i++){
				System.out.println(" " + testArray.get(i));
				}
		}
		catch(Exception e){
			System.out.println("Does not work!");
		}
		System.out.println("--------------------------------------------------------------------------------------");
		
	}

}


