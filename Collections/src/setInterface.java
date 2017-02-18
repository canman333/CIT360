

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.TabSet;


public class setInterface {

	public static void main(String[] args) {
		
		//Declare an array and a set
		List<String> myArrayList = new ArrayList<String>();
		Set<String> mySet = new HashSet<String>();
		
		//Call the printAnimals method
		printAnimals(myArrayList, mySet);
		
		//Call the testSet method for testing
		testSet(mySet);

	}
	
	//populates an array and set based on user input
	public static void populate (List<String> myArrayList, Set<String> mySet){
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 7; i++){
			System.out.println("Please enter 7 animals");
			String arrayAnimal = scanner.next();
			
			//Bad code when you want duplicate elements stored and displayed
			myArrayList.add(arrayAnimal);
			
			//Good code when you want to display all elements the user inputs to the program even duplicates
			mySet.add(arrayAnimal);
		}
		
	}
	
	//print out all elements added by the user
	public static void printAnimals(List<String> myArrayList, Set<String> mySet){
	
	//Call the populate method first to populate our array and set
	populate(myArrayList, mySet);
		
	System.out.print("From my set:        ");
	for (String loop : mySet){
		System.out.print(loop + " ");
		}
	
	//Formatting, need a new line
	System.out.println();
		
	System.out.print("From my array:      ");
	for (String loop : myArrayList){
		System.out.print(loop + " ");
		}
		
	}
	
	public static void testSet(Set<String> mySet){
		System.out.println();
		System.out.print("From my test set:        ");
		for (String loop : mySet){
			System.out.print(loop + " ");
			}
		System.out.println();
		
		//happy path
		mySet.add("Pig");
		
		System.out.println("-----------------------------------------------------------------------------------------");
		//nasty path: you must only add values of the same type to the set
		try{
		//mySet.add(1);
		System.out.println("Nasty Path: you must only add values of the same type to the set");
		}
		catch(Exception e){
			System.out.println("Nasty Path: you must only add values of the same type to the set");
		}
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------");
		
		//nasty path: Sets do not add duplicates, it will only add duplicate values once
		try{
		mySet.add("Pig");
		mySet.add("Pig");
		System.out.println("Nasty Path: Sets do not add duplicates, it will only add duplicate values once");
		System.out.print("From my set after adding Pig twice to the set:        ");
		for (String loop : mySet){
			System.out.print(loop + " ");
			}
		System.out.println();
		}
		catch(Exception e){
			System.out.println("Nasty Path: Sets do not add duplicates, it will only add duplicate values once");
		}
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------");
		
		//nasty path: add null to the set
		try{
		mySet.add(null);
		System.out.println("Nasty Path: add null to the set");
		System.out.println("This will work, but it's not good to do");
		System.out.println("Print out set values: " + mySet.toString());
		}
		catch(Exception e){
			System.out.println("Nasty Path: add null to the set");
		}
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------");
		
		//nasty path: remove from a non-existent object of the set
		try{
		mySet.remove("TEST");
		System.out.println("Nasty Path: remove from a non-existent object of the set");
		}
		catch(Exception e){
			System.out.println("Nasty Path: remove from a non-existent index of the set");
		}
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------");
		
		//nasty path: add an empty string to mySet
		try{
		mySet.add("");
		System.out.println("Nasty Path: add an empty string to mySet");
		System.out.println("Works, but not good to do");
		for (String loop : mySet){
			System.out.print(loop + " ");
			}
		System.out.println();
		}
		catch(Exception e){
			System.out.println("Nasty Path: add an empty string to mySet");
		}
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------");
		
		
	}
}
