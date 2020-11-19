import java.io.Serializable;
public class Student extends User implements Serializable{
	
	private String matricNo;
	private String email;
	private StudentRecords studentRecords;
	
	public Student(String userName, String pwd, String name, String gender, String nationality, String matricNo, String email, StudentRecords studentRecords) {
		super(userName, pwd, name, gender, nationality);
		this.matricNo = matricNo;
		this.email = email;
		this.studentRecords = studentRecords;
	}

	public String getMatricNo() {
		return matricNo;
	}
	
	public void setMatricNo(String matricNo) {
		this.matricNo = matricNo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public StudentRecords getStudentRecords() {
		return studentRecords;
	}
	
	public void setStudentRecords(StudentRecords studentRecords) {
		this.studentRecords = studentRecords;
	}
	@Override
	public boolean equals(Object other) {
		 if (other == this) { 
	            return true; 
	        } 
	     if (!(other instanceof Student)) { 
	            return false; 
	        }        
	      Student that = (Student) other;     
	      return that.matricNo == this.matricNo;
	}
}
