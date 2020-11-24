import java.util.ArrayList;
import java.io.Serializable;


public class Course implements Serializable{
	/**
	 * Specific course code for the course
	 * name of the course
	 * name of the school/faculty
	 * number of academic units for a course
	 * list of class index for the course
	 */
	private String courseCode;
	private String courseName;
	private String school;
	private int acadUnits;
	private ArrayList<ClassIndex> indexNumList;
	
	/**
	 * Constructor for creating course 
	 * @param courseCode
	 * @param courseName
	 * @param school
	 * @param acadUnits
	 * @param indexNumList
	 */
	public Course(String courseCode, String courseName, String school, int acadUnits, ArrayList<ClassIndex> indexNumList) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.school = school;
		this.acadUnits = acadUnits;
		this.indexNumList = indexNumList;
	}
	
	/**
	 * Get school name
	 * @return school name
	 */
	public String getSchool() {
		return school;
	}
	
	/**
	 * Set the school name
	 * @param school
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	
	/**
	 * Get course code 
	 * @return course code
	 */
	public String getCourseCode() {
		return courseCode;
	}
	
	/**
	 * get course name
	 * @return course name
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * Get the number of academic units the course has
	 * @return number of academic units
	 */
	public int getAcadUnits() {
		return acadUnits;
	}
	
	/**
	 * get list of index number of a course
	 * @return list of index number of a course
	 */
	public ArrayList<ClassIndex> getIndexNumList() {
		return indexNumList;
	}
	
	/**
	 * Set new course code 
	 * @param courseCode new course code
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	/**
	 * Set the name for new course
	 * @param courseName Name of the new course
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	/**
	 * Set the number of academic for the course
	 * @param acadUnits number of academic units
	 */
	public void setAcadUnits(int acadUnits) {
		this.acadUnits = acadUnits;
	}
	
	/**
	 * Set new index number for the course
	 * @param indexNumList new index number for course
	 */
	public void setIndexNumList(ArrayList<ClassIndex> indexNumList) {
		this.indexNumList = indexNumList;
	}

}
