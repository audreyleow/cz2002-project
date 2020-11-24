import java.util.ArrayList;
import java.io.Serializable;
public class ClassIndex implements Serializable{
	/**
	 * Name of course
	 * Unique code of course
	 * index number of course
	 * number of empty slots of the index number
	 * list of lessons
	 * list of student on waiting list when index is fully registered
	 * list of student that are registered in the index
	 */
	private String courseName;
	private String courseCode;
	private int indexNum;
	private int classVacancy;
	private ArrayList<Lesson> lessonsList; 
	private ArrayList<Student> waitList;
	private ArrayList<Student> studentList;
	
	/**
	 * Constructor for a Class Index of a course
	 * @param courseName
	 * @param courseCode
	 * @param indexNum
	 * @param classVacancy
	 * @param lessonsList
	 * @param waitList
	 * @param studentList
	 */
	public ClassIndex(String courseName, String courseCode, int indexNum, int classVacancy, ArrayList<Lesson> lessonsList, ArrayList<Student> waitList, ArrayList<Student> studentList) {
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.indexNum = indexNum;
		this.classVacancy = classVacancy;
		this.lessonsList = lessonsList;
		this.waitList = waitList;
		this.studentList = studentList;
	}
	
	/**
	 * Gets the course code for the class index
	 * @return course code of class index
	 */
	public String getCourseCode() {
		return courseCode;
	}
	
	/**
	 * Sets the course code 
	 * @param courseCode course code 
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	/**
	 * Gets the course name for the class index
	 * @return name of the course
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * Gets the index number 
	 * @return index number
	 */
	public int getIndexNum() {
		return indexNum;
	}
	
	/**
	 * Gets the number of empty slots for the class
	 * @return number of empty slots 
	 */
	public int getClassVacancy() {
		return classVacancy;
	}
	
	/**
	 * Gets the list of lessons 
	 * @return list of lessons
	 */
	public ArrayList<Lesson> getLessonsList() {
		return lessonsList;
	}
	
	/**
	 * Gets the students on the waiting list
	 * @return students on waiting list
	 */
	public ArrayList<Student> getWaitList() {
		return waitList;
	}
	
	/**
	 * Gets the students who are registered 
	 * @return students who are registered
	 */
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	/**
	 * Sets the course name 
	 * @param courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	/**
	 * Sets the index number 
	 * @param indexNum
	 */
	public void setIndexNum(int indexNum) {
		this.indexNum = indexNum;
	}
	
	/**
	 * Sets the class vacancy for the index
	 * @param classVacancy
	 */
	public void setClassVacancy(int classVacancy) {
		this.classVacancy = classVacancy;
	}
	
	/**
	 * sets the lessons for the index
	 * @param lessonsList
	 */
	public void setLessonsList(ArrayList<Lesson> lessonsList) {
		this.lessonsList = lessonsList;
	}
	
	/**
	 * sets the students on waitlist
	 * @param waitList
	 */
	public void setWaitList(ArrayList<Student> waitList) {
		this.waitList = waitList;
	}
	
	/**
	 * sets the students to register them
	 * @param studentList
	 */
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	/**
	 * Overrides class index if both of them are equivalent of each other
	 */
	@Override
	public boolean equals(Object other) {
		 if (other == this) { 
	            return true; 
	        } 
	     if (!(other instanceof ClassIndex)) { 
	            return false; 
	        }        
	      ClassIndex that = (ClassIndex) other;     
	      return that.indexNum == this.indexNum;
	}
}
