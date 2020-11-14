import java.util.ArrayList;

public class ClassIndex {
	private String courseName;
	private String courseCode;
	private int indexNum;
	private int classVacancy;
	private ArrayList<Lesson> lessonsList; 
	private ArrayList<Student> waitList;
	private ArrayList<Student> studentList;
	
	
	public ClassIndex(String courseName, String courseCode, int indexNum, int classVacancy, ArrayList<Lesson> lessonsList, ArrayList<Student> waitList, ArrayList<Student> studentList) {
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.indexNum = indexNum;
		this.classVacancy = classVacancy;
		this.lessonsList = lessonsList;
		this.waitList = waitList;
		this.studentList = studentList;
	}
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}
	public int getIndexNum() {
		return indexNum;
	}
	public int getClassVacancy() {
		return classVacancy;
	}
	public ArrayList<Lesson> getLessonsList() {
		return lessonsList;
	}
	public ArrayList<Student> getWaitList() {
		return waitList;
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setIndexNum(int indexNum) {
		this.indexNum = indexNum;
	}
	public void setClassVacancy(int classVacancy) {
		this.classVacancy = classVacancy;
	}
	public void setLessonsList(ArrayList<Lesson> lessonsList) {
		this.lessonsList = lessonsList;
	}
	public void setWaitList(ArrayList<Student> waitList) {
		this.waitList = waitList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
}
