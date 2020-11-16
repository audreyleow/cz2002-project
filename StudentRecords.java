import java.util.ArrayList;
import java.io.Serializable;
public class StudentRecords implements Serializable{

	private int acadUnitsRegistered;
	private ArrayList<ClassIndex> coursesRegistered;
	private ArrayList<ClassIndex> studentWaitList;
	
	public StudentRecords() {
		acadUnitsRegistered = 0;
		coursesRegistered = new ArrayList<ClassIndex>();
		studentWaitList = new ArrayList<ClassIndex>();
	}
	
	public int getAcadUnitsRegistered() {
		return acadUnitsRegistered;
	}
	
	public void setAcadUnitsRegistered(int acadUnitsRegistered) {
		this.acadUnitsRegistered = acadUnitsRegistered;
	}
	
	public void addCourseRegistered(ClassIndex newCourseIndex) {
		coursesRegistered.add(newCourseIndex);
	}
	
	public void removeCourseRegistered(ClassIndex removedCourseIndex) {
		if (coursesRegistered.contains(removedCourseIndex)) {
			coursesRegistered.remove(removedCourseIndex);
		}
	}

	public void setCoursesRegistered(ArrayList<ClassIndex> coursesRegistered) {
		this.coursesRegistered = coursesRegistered;
	}


	public ArrayList<ClassIndex> getCoursesRegistered() {
		return coursesRegistered;
	}
	
	public void addStudentWaitList(ClassIndex newCourseIndex) {
		studentWaitList.add(newCourseIndex);
	}
	
	public void removeStudentWaitList(ClassIndex removedCourseIndex) {
		if (studentWaitList.contains(removedCourseIndex)) {
			studentWaitList.remove(removedCourseIndex);
		}
	}

	public void setStudentWaitList(ArrayList<ClassIndex> studentWaitList) {
		this.studentWaitList = studentWaitList;
	}


	public ArrayList<ClassIndex> getStudentWaitList() {
		return studentWaitList;
	}
	
}
