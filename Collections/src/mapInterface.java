

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class mapInterface {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Declare a hash map, linked hash map and tree map.
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<Integer, String>();
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		//Bad code hashMap should not be used to sort because although the results often print out sorted it does not guarantee any ordering
		//???????????WHEN WOULD HASHMAP BE BETTER TO USE THAN THE REST IF IT DOESNT GUARENTEE ANY SORTING
		//ANSWER TO ABOVE QUESTION - In our group meeting I was told that the HashMap is lighter on the application, quicker
		sortMap(hashMap);
		
		//Good code if you want the results of the map to be guaranteed to be sorted in their natural order
		sortMap(treeMap);
		
		//Sorts the map in the order the keys and values were put in
		sortMap(linkedMap);
		
		//Remove keys and values from hash map
		testMap(hashMap);
	}
	
	//Method to populate the map
	public static void populateMap (Map<Integer,String> map){
		map.put(1, "I");
		map.put(6, "Best!");
		map.put(2, "Love");
		map.put(4, "It's");
		map.put(3, "Java");
		map.put(5, "the");
	}
		//Method to print out map keys and values
		public static void sortMap (Map<Integer, String> map){
			
			//call populateMap method
			populateMap(map);
			
			//Loop through map and print out values
			for(Integer key: map.keySet()){
				String value = map.get(key);
				
				System.out.println(key + " " + value);
			}
		}
		
		public static void testMap(Map<Integer, String> map){
			
			System.out.println();
			System.out.println("Testing");
			
			System.out.println("-------------------------------------------------------------------------------------");
			//nasty path: Returns null because nothing has been put in for key 8
			try{
				System.out.println("Nasty Path: print out element from a non-existent key in the map");
				System.out.println(map.get(8));
			}
			catch (Exception ex){
				System.out.println("Nasty Path: there is no key of 8 in the map");
			}
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
			
			//nasty path: Never put null as a parameter in the hash map
			try {
				System.out.println("Nasty Path: adding null as a value in the hash map");
				map.put(6, null);
				System.out.println(map.get(8));
			}
			catch(Exception ex){
				System.out.println("Nasty Path: adding null as a value in the hash map");
			}
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
			
			//nasty path: adding a null key to the hash map
			try {
				System.out.println("Nasty Path: adding a null key to the hash map");
				map.put(null, "Test");
				System.out.println("Grab value from the null key. The value is: " + map.get(null));
				System.out.println("Works, but not goot to do");
			}
			catch(Exception ex){
				System.out.println("Nasty Path: adding a null key to the hash map");
			}
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
			
			//nasty path: Cannot put an Integer in for the value parameter of a hashmap that has string values
			try {
				//map.put(7, 7);
				System.out.println("Nasty Path: Cannot put an Integer in for the value parameter of a hashmap that has string values");
			}
			catch(Exception ex){
				System.out.println("Nasty Path: Cannot put an Integer in for the value parameter of a hashmap that has string values");
			}
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
			
			//nasty path: Hash Map does not do duplicate keys
			try {
				map.put(9, "Test1");
				map.put(9, "Test2");
				map.put(9, "Test3");
				System.out.println("Nasty Path: Hash Map does not do duplicate keys");
				System.out.println("Value after adding three values of the same key: " + map.get(9));
			}
			catch(Exception ex){
				System.out.println("Nasty Path: Hash Map does not do duplicate keys");
			}
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------");
			
		}
}