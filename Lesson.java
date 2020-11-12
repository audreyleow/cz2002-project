
import java.util.ArrayList;

public class Lesson {
	private LessonType lessonType;
	private String classVenue;
	private ArrayList<Day> classDay;
	private ArrayList<int[]> classTiming;
	private ArrayList<Week> classWeek;
	
	enum LessonType {
		LECTURE,
		TUTORIAL,
		LABORATORY;
	}
	enum Day {
		MONDAY,
		TUESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY,
		SUNDAY;
	}
	enum Week {
		EVERY, //every week
		ODD,
		EVEN;
	}
	
	public Lesson(LessonType lessonType, String classVenue, ArrayList<Day> classDay, ArrayList<int[]> classTiming, ArrayList<Week> classWeek) {
		this.lessonType = lessonType;
		this.classVenue = classVenue;
		this.classDay = classDay;
		this.classTiming = classTiming;
		this.classWeek = classWeek;
		
	}
	
	public LessonType getLessonType() {
		return lessonType;
	}
	
	public String getClassVenue() {
		return classVenue;
	}
	
	public ArrayList<Day> getClassDay(){
		return classDay;
	}
	
	public ArrayList<int[]> getClassTiming(){
		return classTiming;
	}
	
	public ArrayList<week> getClassWeek(){
		return classWeek;
	}
	
	
	public void setLessonType(LessonType lessonType) {
		this.lessonType = lessonType;
	}
	
	public void setClassVenue(String classVenue) {
		this.classVenue = classVenue;
	}
	
	public void setClassDay(ArrayList<Day> classDay) {
		this.classDay = classDay;
	}
	
	public void setClassTime(ArrayList<int[]> classTiming) {
		this.classTiming = classTiming;
	}
	
	public void setClassWeek(ArrayList<Week> classWeek) {
		this.classWeek = classWeek;
	}

}
