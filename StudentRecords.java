import java.util.ArrayList;

public class StudentRecords {

	private int acadUnitsRegistered;
	private ArrayList<ClassIndex> coursesRegistered;
	
	public StudentRecords() {
		acadUnitsRegistered = 0;
		coursesRegistered = new ArrayList<ClassIndex>();
	}
	
	public void addCourseRegistered(ClassIndex newCourseIndex) {
		coursesRegistered.add(newCourseIndex);
	}
	
	public void removeCourseRegistered(ClassIndex removedCourseIndex) {
		if (coursesRegistered.contains(removedCourseIndex)) {
			coursesRegistered.remove(removedCourseIndex);
		}
	}

	public void setAcadUnitsRegistered(int acadUnitsRegistered) {
		this.acadUnitsRegistered = acadUnitsRegistered;
	}

	public void setCoursesRegistered(ArrayList<ClassIndex> coursesRegistered) {
		this.coursesRegistered = coursesRegistered;
	}

	public int getAcadUnitsRegistered() {
		return acadUnitsRegistered;
	}

	public ArrayList<ClassIndex> getCoursesRegistered() {
		return coursesRegistered;
	}
	
}
