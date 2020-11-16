import java.io.Serializable;
public class Lesson implements Serializable {
	private String lessonType;
	private String classVenue;
	private String classDay;
	private int [] classTiming;
	private String classWeek;
	
	public Lesson(String lessonType, String classVenue, String classDay, int[] classTiming, String classWeek) {
		this.lessonType = lessonType;
		this.classVenue = classVenue;
		this.classDay = classDay;
		this.classTiming = classTiming;
		this.classWeek = classWeek;
		
	}
	
	public String getLessonType() {
		return lessonType;
	}
	
	public String getClassVenue() {
		return classVenue;
	}
	
	public String getClassDay(){
		return classDay;
	}
	
	public int[] getClassTiming(){
		return classTiming;
	}
	
	public String getClassWeek(){
		return classWeek;
	}
	
	
	public void setLessonType(String lessonType) {
		this.lessonType = lessonType;
	}
	
	public void setClassVenue(String classVenue) {
		this.classVenue = classVenue;
	}
	
	public void setClassDay(String classDay) {
		this.classDay = classDay;
	}
	
	public void setClassTime(int [] classTiming) {
		this.classTiming = classTiming;
	}
	
	public void setClassWeek(String classWeek) {
		this.classWeek = classWeek;
	}

}
