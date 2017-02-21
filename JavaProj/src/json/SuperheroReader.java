package json;

import java.io.File;

import javax.json.Json;
import javax.json.JsonReader;

public class SuperheroReader {
	public static void main(String args[]){
		File json = new File("jsonTest.json");
		JsonReader Batman = Json.createReader();
	}
}
