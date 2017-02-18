import java.util.HashMap;
import java.util.HashSet;


public class testStudent {

	private HashMap <Integer, student> storeObj = new HashMap<Integer, student>();
	
	public void addStudent(student astudent){
		int studentKey = astudent.getStudentId();
		storeObj.put(studentKey, astudent);
		
	}
	
	public int getSize() {
        int studentTotal = storeObj.size();
        return studentTotal;
    }
	
	public void addIllegalArg(String id){
		student testArg = new student(id, "Test", "Arg");
	}
	
}
