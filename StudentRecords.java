import java.util.ArrayList;
import java.io.Serializable;
public class StudentRecords implements Serializable{

	/**
	 * total academic units registered for this student
	 */
	private int acadUnitsRegistered;
	/**
	 * list of courses where this student is registered in
	 */
	private ArrayList<ClassIndex> coursesRegistered;
	/**
	 * list of courses where this student wishes to register but currently has no vacancy
	 */
	private ArrayList<ClassIndex> studentWaitList;
	
	/**
	 * constructor for student
	 * sets academic units registered to 0
	 * create new list to store the courses registered for this student
	 * creates new list to store the courses where this student is currently on waiting list as the class index is fully registered by students.
	 */
	public StudentRecords() {
		acadUnitsRegistered = 0;
		coursesRegistered = new ArrayList<ClassIndex>();
		studentWaitList = new ArrayList<ClassIndex>();
	}
	
	/**
	 * Gets the total number of academic units registered
	 * @return the total number of academic units registered
	 */
	public int getAcadUnitsRegistered() {
		return acadUnitsRegistered;
	}
	
	/**
	 * sets the number of academic units registered for this student
	 * @param acadUnitsRegistered
	 */
	public void setAcadUnitsRegistered(int acadUnitsRegistered) {
		this.acadUnitsRegistered = acadUnitsRegistered;
	}
	
	/**
	 * Adds the new index of the course where this student is registered in
	 * @param newCourseIndex where this student has registered in
	 */
	public void addCourseRegistered(ClassIndex newCourseIndex) {
		coursesRegistered.add(newCourseIndex);
	}
	
	/**
	 * removes the index of the course where this student is registered in
	 * @param removedCourseIndex where this student has already registered in
	 */
	public void removeCourseRegistered(ClassIndex removedCourseIndex) {
		if (coursesRegistered.contains(removedCourseIndex)) {
			coursesRegistered.remove(removedCourseIndex);
		}
	}
	
	/**
	 * sets the registered index of the course into the array list of registered courses
	 * @param coursesRegistered
	 */
	public void setCoursesRegistered(ArrayList<ClassIndex> coursesRegistered) {
		this.coursesRegistered = coursesRegistered;
	}
	
	/**
	 * gets the lists of courses where this student is registered in
	 * @return list of courses registered 
	 */
	public ArrayList<ClassIndex> getCoursesRegistered() {
		return coursesRegistered;
	}
	
	/**
	 * Adds index course into this student's waiting list
	 * @param newCourseIndex that this student wants to register in but currently has no vacancy
	 */
	public void addStudentWaitList(ClassIndex newCourseIndex) {
		studentWaitList.add(newCourseIndex);
	}
	
	/**
	 * removes index course from this student's waiting list
	 * @param removedCourseIndex where this student do not wish to register in 
	 */
	public void removeStudentWaitList(ClassIndex removedCourseIndex) {
		if (studentWaitList.contains(removedCourseIndex)) {
			studentWaitList.remove(removedCourseIndex);
		}
	}
	
	/**
	 * sets the lists of courses where this student is currently on the wait list
	 * @param studentWaitList
	 */
	public void setStudentWaitList(ArrayList<ClassIndex> studentWaitList) {
		this.studentWaitList = studentWaitList;
	}
	
	/**
	 * gets the list of courses where this student is currently on, in the waiting list
	 * @return lists of courses where student is on wait list
	 */
	public ArrayList<ClassIndex> getStudentWaitList() {
		return studentWaitList;
	}
	
}
