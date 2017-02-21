package collections;

import java.util.*;

public class SetTest {

	public static void main(String[] args){
		hashTest();
		
	}
	
	public static Set<String> hashTest(){
		
		Set<String> iceCream = new HashSet<String>();
		iceCream.add("Chocolate");
		iceCream.add("Vanilla");
		iceCream.add("Peanut Butter");
		iceCream.add("Mint");
		
		System.out.println(iceCream);
		
		System.out.println("Who likes mint???? Not Me!");
		
		iceCream.remove("Mint");
		
		System.out.println(iceCream);
		
		return iceCream;
	}
}
