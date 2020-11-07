import java.util.ArrayList;

public class Course {
	private String courseCode;
	private String courseName;
	private String school;
	private int acadUnits;
	private ArrayList<ClassIndex> indexNumList;
	
	public Course(String courseCode, String courseName, String school, int acadUnits, ArrayList<ClassIndex> indexNumList) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.school = school;
		this.acadUnits = acadUnits;
		this.indexNumList = indexNumList;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getAcadUnits() {
		return acadUnits;
	}

	public ArrayList<ClassIndex> getIndexNumList() {
		return indexNumList;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setAcadUnits(int acadUnits) {
		this.acadUnits = acadUnits;
	}

	public void setIndexNumList(ArrayList<ClassIndex> indexNumList) {
		this.indexNumList = indexNumList;
	}

}
