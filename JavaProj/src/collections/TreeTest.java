package collections;

import java.util.*;

public class TreeTest {
	public static void main(String[] args){
		BooksInLibrary();
	}
	
	public static void BooksInLibrary(){
		//Book treeSet
		TreeSet<String> books = new TreeSet<String>();
		//Books
		books.add("Mistborn: The Final Empire");
		books.add("Mistborn: The Well of Ascension");
		books.add("Mistborn: The Hero of Ages");
		books.add("Way of Kings");
		books.add("Words of Radiance");
		books.add("The Rithmatist");
		
		Iterator<String> bookIterator = books.iterator();
		while(bookIterator.hasNext()){
			System.out.println(bookIterator.next() + "\n");
		}
	}
}
