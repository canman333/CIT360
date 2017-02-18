package JSON_QCJSON;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONExercise {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// declare variables
		Boolean testBoolean;
		String testEmpty;
		String test;
		String username;
		String password;
		String root = "Admin";

		// add variable input
		username = "FoxTrot";
		password = "tengo";

//--------------------------------------------------Create JSON Objects and JSON Array-----------------------------------------//
		
		//Create a JSON object
		JSONObject credential = new JSONObject();
		
		//add key value pairs to credential object
		credential.put("root", root);
		
		//create a JSON object
		JSONObject cred = new JSONObject();
		
		//Add String keys and value pairs, which are my variables that hold my assigned values
		cred.put("password", password);
		cred.put("username", username);
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		// Nasty Path: add null to JSON Object
		try {
			test = null;
			cred.put("test", test);
			System.out.println("Nasty Path: Add null to JSON Object");
			System.out.println("null gets added into the object");
		} catch (Exception ex) {
			System.out.println("Nasty Path: Add null to JSON Object");
		}
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		// Happy Path: add boolean
		try {
			testBoolean = false;
			cred.put("testBoolean", testBoolean);
			System.out.println("Happy Path: Test Boolean");
			System.out.println("Boolean adds succesfully");
		} catch (Exception ex) {
			System.out.println("Happy Path: Test Boolean");
		}
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		// Nasty Path: add empty string to JSON Object
		try {
			testEmpty = "";
			cred.put("testEmpty", testEmpty);
			System.out.println("Nasty Path: add empty string to JSON Object");
			System.out.println("Empty string adds successfully into object");
		} catch (Exception ex) {
			System.out.println("Nasty Path: add empty string to JSON Object");
		}
		System.out.println("----------------------------------------------------------------------------------------------------");
		
		//create a JSON Array and add the object cred with its key values to it
		JSONArray security = new JSONArray();
		security.add(cred);
		
		//add array to the credential object
		credential.put("security", security);

		//prints out json contents
		System.out.println("Happy Path: Print out contents of our JSON");
		System.out.println(credential.toString());
		
//-----------------------------------------------------------------Create File to hold JSON---------------------------------------//
		
		//create a file
		File file = new File("confidential.json");
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		//nasty path: won't write anything to the file
		try {
			PrintWriter write = new PrintWriter(file);
			write.print(credential.toString());
			System.out.println("Nasty Path: Need to close the print writer or won't write to file");
		} catch (FileNotFoundException e) {
			System.out.println("Nasty Path: Need to close the print writer or won't write to file");
		}
		System.out.println("----------------------------------------------------------------------------------------------------");
		
		
		//happy path: You have to close the printwriter for it to write to the file otherwise it won't
		try {
			PrintWriter write = new PrintWriter(file);
			write.print(credential.toString());
			write.close();
			System.out.println("Happy Path: Print writer closed, print JSON contents to file SUCCESSFULL!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------------------------------------------------------------------------------------------");
	
//------------------------------------------------------------------------------Read JSON contents from file--------------------------//
		
		//reads the file
		//reading the file not from the console anymore
		try {
			input = new Scanner(file);
			//A String Builder allows a string to append to an existing one or insert into one
			StringBuilder build = new StringBuilder();
			//only has one line in the file created but has next line just in case so whole file is read
			while (input.hasNextLine()){
				build.append(input.nextLine());
			}
			System.out.println("Happy Path: Print out contents of the file");
			System.out.println(build.toString());
			System.out.println("----------------------------------------------------------------------------------------------------");
			
			//parse json string
			JSONParser myParse = new JSONParser();
			
			//create object to store root object parse string to object
			JSONObject objsecure = (JSONObject) myParse.parse(build.toString());
			
			try{
			//nasty path: will print out null
			String user = (String) objsecure.get("username");
			System.out.println("Nasty Path: Try to access a key within the object stored in JSONArray");
			System.out.println("This will print out null only can access the keys available to root object");
			System.out.println("Value: " + user);
			}catch(Exception ex){
				System.out.println("Nasty Path: Try to access a key within the object stored in JSONArray");
				System.out.println("This will print out null only can access the keys available to root object");
			}
			System.out.println("----------------------------------------------------------------------------------------------------");
			
			//Happy Path: Print out root object key value pair
			System.out.println("Happy Path: Print out root object key value pair: " + objsecure.get("root").toString());
			System.out.println("----------------------------------------------------------------------------------------------------");
			
			//Create JSONArray to hold JSONArray from file
			JSONArray myArray = (JSONArray) objsecure.get("security");
			
			//Create JSONObject to get the JSONobject within the JSONarray at index 0
			JSONObject testObj = (JSONObject) myArray.get(0);
			
			//Create string and store the username 
			String user = (String) testObj.get("username");
			
			//Happy Path: Print out the username
			System.out.println("Happy Path: username from file: " + user);
			System.out.println("----------------------------------------------------------------------------------------------------");
			
			//cycle through the array and print out values
			for (int i = 0; i < myArray.size(); i++){
				JSONObject myArray2 = (JSONObject) myArray.get(i);
				String usernamein = (String) myArray2.get("username");
				String passwordin = (String) myArray2.get("password");
				String testin = (String) myArray2.get("test");
				String testEmptyin = (String) myArray2.get("testEmpty");
				Boolean testBooleanin = (Boolean) myArray2.get("testBoolean");
				System.out.println("Happy Path: Username: " + usernamein + " Password: " + passwordin + " Boolean: " + testBooleanin);
				System.out.println("Nasty Path: test: " + testin + " empty: " + testEmptyin);
			}
			System.out.println("----------------------------------------------------------------------------------------------------");
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

 }
