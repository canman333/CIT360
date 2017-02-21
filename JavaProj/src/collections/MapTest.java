package collections;

import java.util.*;

public class MapTest {
	public static void main(String[] args){
		System.out.println(Library());
	}
	
	public static Map<String, String> Library(){
		Map<String, String> Library = new HashMap<String, String>();
		
		Library.put("Fantasy", "Words Of Radiance");
		Library.put("Science Fiction", "Leviathan Awakens");
		Library.put("Fiction", "A Time to Kill");
		
		Library.remove("Fiction");
		
		return Library;
	}

}
