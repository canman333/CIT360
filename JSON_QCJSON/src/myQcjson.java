import org.quickconnectfamily.json.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Casey on 10/9/2016.
 */
public class myQcjson implements Serializable {

//qcjson another way to manipulate json data to java
    //assign values to variables
    String firstName = "Object-Santa";
    String lastName = "Object-Claus";
    int age = 0;

    //constructor allows to change the age variable
    public myQcjson(int a){

        this.age = a;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //create an object of the myQcjson class
        myQcjson obj = new myQcjson(25);
        System.out.println("Print out contents of the obj object");
        System.out.println(obj.firstName + " " + obj.lastName + " " + obj.age);
        System.out.println("------------------------------------------------------------------");

        //create another object
        myQcjson object = new myQcjson(50);

        //happy path: create an arrayList to store two objects
        ArrayList myArray = new ArrayList();
        myArray.add(0, obj);
        myArray.add(1, object);

        //create file for my valid json
        File file = new File("QCJSON_Valid.txt");

        //create file for my invalid json
        File badFile = new File("QCJSON_InValid.txt");

        //creates file stream
        try {
            //using the FileOutputStream we create a stream for our valid json
            FileOutputStream fileOut = new FileOutputStream(file);

            //using the FileOutputStream we create a stream for our invalid json
            FileOutputStream badFileOut = new FileOutputStream(badFile);

            //nasty path: PrintWriter does not work with a file created from the FileOutputStream
            try {
                PrintWriter writer = new PrintWriter(file);
                //nasty path: This will write nothing to the file
                writer.print(object);
                //nasty path: This will write nothing to the file
                writer.print(obj);
                System.out.println("Nasty Path: Cannot use PrintWriter to print to file when using FileOutputStream");
                System.out.println("Nothing wrote to file");
            }catch(Exception ex){
                System.out.println("Nasty Path: Cannot use PrintWriter to print to file when using FileOutputStream");
                System.out.println("Nothing wrote to file");
            }
            System.out.println("------------------------------------------------------------------");

            //happy path: this is similar to creating a printWriter, but is used when creating a file
            //from the FileOutputStream class
            JSONOutputStream jsonOut = new JSONOutputStream(fileOut);
            //for the invalid json
            JSONOutputStream badJsonOut = new JSONOutputStream(badFileOut);
            System.out.println("Happy Path: By using JSONOutputStream we can now write to file successfully");
            System.out.println("------------------------------------------------------------------");

            try {
                //nasty path: invalid json
                //prints object to file in json
                badJsonOut.writeObject(obj);
                //prints another object to file in json
                badJsonOut.writeObject(object);
                System.out.println("Nasty Path: Invalid JSON wrote to file. Need to nest JSONObjects in" +
                        " an array");

                //happy path: The two objects need to be nested in an array and can't be wrote seperately to a file,
                //like the above nasty path example otherwise it is not valid json and you will have a hard time reading
                // in the JSON data
                jsonOut.writeObject(myArray);
                System.out.println("Happy Path: Valid JSON wrote to file");

                //close the file write
                jsonOut.close();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------------------------------------------");

        //read json file into java
        try {
            //Create file input streams
            FileInputStream read = new FileInputStream(file);
            FileInputStream badRead = new FileInputStream(badFile);

            //create JSONInputStreams
            JSONInputStream readIn = new JSONInputStream(read);
            JSONInputStream badReadIn = new JSONInputStream(badRead);

            //happy path: create array list to read in JSON array
            ArrayList contain = new ArrayList();
            contain = (ArrayList) readIn.readObject();

            //nasty path: you can not access the key value pairs if you stick the JSON Object in an object
            try {
                Object containObject = contain.get(1);
                containObject = contain.get(1);
                //nasty path
                //System.out.println(containObject.age);
                //System.out.println(containObject.get("age"));
                System.out.println("Nasty Path: Assign the second object in the array to an object");
                System.out.println("We cannot access the key value pairs, need to use a hash map, not assign" +
                        "it to an object");
            }catch(Exception ex){
                System.out.println("Nasty Path: Assign the second object in the array to an object");
                System.out.println("We cannot access the key value pairs, need to use a hash map, not assign" +
                        "it to an object");
            }
            System.out.println("-----------------------------------------------------------------");

            System.out.println("Reading out obj in Java from JSON");
            System.out.println("-----------------------------------------------------------------");
            //happy path: read obj from the file
            //you want to put your json objects in a hash map because the JSONObject has key value pairs
            HashMap map = (HashMap) contain.get(0);

            try {
                //nasty path: You cannot use int throws an error
                int age = (int) map.get("age");
            }catch(Exception ex){
                System.out.println("Nasty Path: Cannot cast to an int, need to use long");
            }
            System.out.println("-----------------------------------------------------------------");

            System.out.println("Happy Path: Display QCJSON from first object called obj into java");
            long age = (long) map.get("age");
            String first = (String) map.get("firstName");
            String last = (String) map.get("lastName");
            System.out.println("obj-firstName: " + first);
            System.out.println("obj-lastName: " + last);
            System.out.println("obj-age: " + age);
            System.out.println("-----------------------------------------------------------------");

            System.out.println("Happy Path: Display QCJSON from second object called object into java");
            //happy path: read object from the file
            HashMap map2 = (HashMap) contain.get(1);
            long age2 = (long) map2.get("age");
            String first2 = (String) map2.get("firstName");
            String last2 = (String) map2.get("lastName");
            System.out.println("object-firstName: " + first2);
            System.out.println("object-lastName: " + last2);
            System.out.println("object-age: " + age2);
            System.out.println("-----------------------------------------------------------------");

            System.out.println("Happy Path: Convert obj back to json using the stringify method");
            //stringify method converts an object back to json. It's very helpful because instead of using the string builder
            //you can use stringify to build your strings

            //not json
            System.out.println("This is not JSON: " + contain.get(0));

            String combine = JSONUtilities.stringify((Serializable) contain.get(0));
            System.out.println("This is JSON after using stringify method: " + combine);

            //close
            readIn.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------");

        //Stringify testing
        String value1 = "value1";
        String value2 = "";
        String value3 = "value3";
        HashMap testMap = new HashMap();
        testMap.put("test1", value1);
        testMap.put("test2", "");
        testMap.put("test3", value3);

        //Nasty Path: stringify HashMap that has a blank string for one of the key value pairs
        try {
            String hash = JSONUtilities.stringify(testMap);
            System.out.println("Nasty Path: stringify HashMap that has a blank string for one of the key value pairs");
            System.out.println(hash);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------");

        //Nasty Path: Pass null to the stringify method
        String testNull = null;
        try {
            String hash = JSONUtilities.stringify(testNull);
            System.out.println("Nasty Path: Pass null to the stringify method");
            System.out.println(hash);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------");

        //Nasty Path: Pass null within the parameter of the stringify method
        try {
            String hash = JSONUtilities.stringify(null);
            System.out.println("Nasty Path: Pass null within the parameter of the stringify method");
            System.out.println(hash);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------");
        
    }
}

