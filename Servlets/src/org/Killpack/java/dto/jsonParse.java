package org.Killpack.java.dto;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonParse {
	
	static //Create json object and json parser
	JSONObject object = new JSONObject();
	static JSONParser parse = new JSONParser();
	static String root;
			 //declare variables
			static long id = 0;
			static String firstName = null;
			static String lastName = null;
			static long phoneNumber = 0;
	
	
	public static String json (String json){
		
		try {
			//parse the json to a JSONObject
			object = (JSONObject) parse.parse(json);
			
			//Grab the value from the root key
			root = (String) object.get("root");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
	
	}
	
	//Database JSON values to be parsed
	public static long dbJsonId(String json){
		//----------JSON TO BE STORED IN DATABASE---------------------------------------//
		try{
		//create JSONObject
		JSONObject object1 = new JSONObject();
		//parse json string to JSONObject
		object1 = (JSONObject) parse.parse(json);
		//grab values from JSON keys and store them in variables
		id = (long) object1.get("id");
		}catch(ParseException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public static String dbJsonFirst(String json){
		//----------JSON TO BE STORED IN DATABASE---------------------------------------//
		try{
		//create JSONObject
		JSONObject object1 = new JSONObject();
		//parse json string to JSONObject
		object1 = (JSONObject) parse.parse(json);
		//grab values from JSON keys and store them in variables
		firstName = (String) object1.get("firstName");
		}catch(ParseException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return firstName;
	}
	
	public static String dbJsonLast(String json){
		//----------JSON TO BE STORED IN DATABASE---------------------------------------//
		try{
		//create JSONObject
		JSONObject object1 = new JSONObject();
		//parse json string to JSONObject
		object1 = (JSONObject) parse.parse(json);
		//grab values from JSON keys and store them in variables
		lastName = (String) object1.get("lastName");
		}catch(ParseException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastName;
	}
	
	public static long dbJsonPhone(String json){
		//----------JSON TO BE STORED IN DATABASE---------------------------------------//
		try{
		//create JSONObject
		JSONObject object1 = new JSONObject();
		//parse json string to JSONObject
		object1 = (JSONObject) parse.parse(json);
		//grab values from JSON keys and store them in variables
		phoneNumber = (long) object1.get("phoneNumber");
		}catch(ParseException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phoneNumber;
	}
}
