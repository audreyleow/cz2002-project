import java.io.Serializable;
public class Lesson implements Serializable {
	
	/**
	 * type of lesson (lecture, tutorial, lab)
	 */
	private String lessonType;
	
	/**
	 * location where the class is held in
	 */
	private String classVenue;
	
	/**
	 * day of the week where the class is held in
	 */
	private String classDay;
	
	/**
	 * start and end timing of the class
	 */
	private int [] classTiming;
	
	/**
	 * type of week the class is held in (every/odd/even)
	 */
	private String classWeek;
	
	/**
	 * Constructor for lesson for an index
	 * 
	 * @param lessonType
	 * @param classVenue
	 * @param classDay
	 * @param classTiming
	 * @param classWeek
	 */
	public Lesson(String lessonType, String classVenue, String classDay, int[] classTiming, String classWeek) {
		this.lessonType = lessonType;
		this.classVenue = classVenue;
		this.classDay = classDay;
		this.classTiming = classTiming;
		this.classWeek = classWeek;
		
	}
	
	/**
	 * gets the type of lesson (lecture, tutorial, lab) of this index
	 * @return type of lesson
	 */
	public String getLessonType() {
		return lessonType;
	}
	
	/**
	 * gets the location where the class is held at
	 * @return location of the class
	 */
	public String getClassVenue() {
		return classVenue;
	}
	
	/**
	 * gets the day of the week where class is held in
	 * @return day of the week where class is held
	 */
	public String getClassDay(){
		return classDay;
	}
	
	/**
	 * gets the start and end timing of the class
	 * @return start and end timing of the class
	 */
	public int[] getClassTiming(){
		return classTiming;
	}
	
	/**
	 * gets the type of week the class is held in (odd/even/every week)
	 * @return the type of week where the class is held
	 */
	public String getClassWeek(){
		return classWeek;
	}
	
	/**
	 * sets the type of lesson
	 * @param lessonType
	 */
	public void setLessonType(String lessonType) {
		this.lessonType = lessonType;
	}
	
	/**
	 * sets the location of the class
	 * @param classVenue
	 */
	public void setClassVenue(String classVenue) {
		this.classVenue = classVenue;
	}
	
	/**
	 * sets the day of the week where the class is held in
	 * @param classDay
	 */
	public void setClassDay(String classDay) {
		this.classDay = classDay;
	}
	
	/**
	 * sets the start and end timing for the class
	 * @param classTiming
	 */
	public void setClassTime(int [] classTiming) {
		this.classTiming = classTiming;
	}
	
	/**
	 * sets the type of week where the class is held in (odd/even/every)
	 * @param classWeek
	 */
	public void setClassWeek(String classWeek) {
		this.classWeek = classWeek;
	}

}
