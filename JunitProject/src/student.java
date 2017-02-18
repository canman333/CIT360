
public class student {

	int studentId;
	String firstName;
	String lastName;
	
	public student(int studentId, String firstName, String lastName){
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getStudentId(){
		return studentId;
	}
	
	public void setStudentId(int studentId){
		this.studentId = studentId;
	}
	
	public String getfirstName(){
		return firstName;
	}
	
	public void setfirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getlastName(){
		return lastName;
	}
	
	public void setlastName(String lastName){
		this.lastName = lastName;
	}
}
