import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import javax.swing.text.TabSet;


public class treeInterface {

	public static void main(String[] args) {
		
		// Tree orders things in natural order, Set does not allow for duplicates
		//Declare a TreeSet
		//TreeSet's are also not indexed unlike a list
		TreeSet<Integer> myTree = new TreeSet<Integer>();
		List<Integer> myArrayList = new ArrayList<Integer>();
		
		//Add integers to treeSet
		myTree.add(3);
		myTree.add(7);
		myTree.add(8);
		myTree.add(7);
		myTree.add(6);
		myTree.add(2);
		myTree.add(2);
		myTree.add(4);
		myTree.add(1);
		myTree.add(5);
		myTree.add(5);
		
		//Add integers to my list
		myArrayList.add(3);
		myArrayList.add(7);
		myArrayList.add(8);
		myArrayList.add(7);
		myArrayList.add(6);
		myArrayList.add(2);
		myArrayList.add(2);
		myArrayList.add(4);
		myArrayList.add(1);
		myArrayList.add(5);
		myArrayList.add(5);
	
		
		//Call procedure to print out TreeSet
		orderNoDuplicates(myTree);
		
		//Call procedure to find the number five in the array list and tree set. Return true if found, false if not found
		findNumber(myTree, myArrayList);
		
		testTree(myTree, myArrayList);
	}

	
	//Method prints out elements in my TreeSet
	public static void orderNoDuplicates(TreeSet<Integer> myTree){
		System.out.print("From my TreeSet:        ");
		for (Integer loop : myTree){
			System.out.print(loop + " ");
			}
		System.out.println();
	}
	
	//Method to find the number 5
	public static void findNumber(TreeSet<Integer> myTree, List<Integer> myArrayList){
		
			//Print out True if the number is found in the set or false if not found
		    //Good code for finding elements quick
			System.out.println("-----------------------------------------------------------------------------------");
		    System.out.println("Happy Path: check to see if treeSet has the number five. This is good code "
		    		+ "for searching for an element quickly");
			System.out.println("Return true if found: " + myTree.contains(5));
			System.out.println("-----------------------------------------------------------------------------------");
			
			//Print out True if the number is found in the set or false if not found
			//Bad cod for finding elements much slower than a treeset
			System.out.println("Nasty Path: check to see if ArrayList has the number five. This is bad code "
		    		+ "for searching for an element, not as quick as searching with a treeSet");
			for (int i = 0; i < myArrayList.size(); i++){
				if(myArrayList.get(i) == 5){
					break;
					
		} 
				else
					continue;
					
	}System.out.println("Return true if found: true");
	System.out.println("-----------------------------------------------------------------------------------");
}
	
	public static void testTree(TreeSet<Integer> myTree, List<Integer> myArrayList){
		
		//nasty path: add null to a treeSet
		try{
			myTree.add(null);
		}
		catch(Exception e){
			System.out.println("Nasty Path: cannot add null to a treeSet");
		}
		System.out.println("-----------------------------------------------------------------------------------");
		
		//nasty path: add a string to a treeSet of integer type
		try{
			//myTree.add("Test");
			System.out.println("Nasty Path: cannot add a string to a treeSet of integer type");
		}
		catch(Exception e){
			System.out.println("Nasty Path: cannot add a string to a treeSet of integer type");
		}
		System.out.println("-----------------------------------------------------------------------------------");
		
		//nasty path: remove non-existent value from treeSet
		try{
			myTree.remove(30);
			System.out.println("Nasty Path: remove non-existent value from treeSet");
		}
		catch(Exception e){
			System.out.println("Nasty Path: remove non-existent value from treeSet");
		}
		System.out.println("-----------------------------------------------------------------------------------");
			
	}
}