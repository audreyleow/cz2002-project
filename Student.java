import java.io.Serializable;
public class Student extends User implements Serializable{
	
	/*
	 * matriculation number of this student
	 */
	private String matricNo;
	
	/*
	 * email of this student 
	 */
	private String email;
	
	/*
	 * student records of this student
	 */
	private StudentRecords studentRecords;
	
	/**
	 * Constructor for a student 
	 * 
	 * @param userName
	 * @param pwd
	 * @param name
	 * @param gender
	 * @param nationality
	 * @param matricNo
	 * @param email
	 * @param studentRecords
	 */
	public Student(String userName, String pwd, String name, String gender, String nationality, String matricNo, String email, StudentRecords studentRecords) {
		super(userName, pwd, name, gender, nationality);
		this.matricNo = matricNo;
		this.email = email;
		this.studentRecords = studentRecords;
	}
	
	/**
	 * Gets the matriculation number for this student
	 * @return matriculation number
	 */
	public String getMatricNo() {
		return matricNo;
	}
	
	/**
	 * sets the matriculation number for new student
	 * @param matricNo
	 */
	public void setMatricNo(String matricNo) {
		this.matricNo = matricNo;
	}
	
	/**
	 * gets the email of this student
	 * @return email of student
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * sets the email of new student
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * gets the student records of this student which includes their number of AUs registered, lists of courses registered, list of courses that are on waitlist
	 * @return student records of this student
	 */
	public StudentRecords getStudentRecords() {
		return studentRecords;
	}
	
	/**
	 * sets the student records of new student
	 * @param studentRecords
	 */
	public void setStudentRecords(StudentRecords studentRecords) {
		this.studentRecords = studentRecords;
	}
	/**
	 * Overrides student if both are equivalent of each other
	 */
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
