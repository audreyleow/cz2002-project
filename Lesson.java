
import java.util.ArrayList;

public class Lesson {
	private LessonType lessonType;
	private String classVenue;
	private ArrayList<Day> classDay;
	private ArrayList<int[]> classTiming;
	private ArrayList<Week> classWeek;
	
	enum LessonType {
		LECTURE;
		TUTORIAL;
		LABORATORY;
	}
	enum Day {
		MONDAY;
		TUESDAY;
		WEDNESDAY;
		THURSDAY;
		FRIDAY;
		SATURDAY;
		SUNDAY;
	}
	enum Week {
		EVERY; //every week
		ODD;
		EVEN;
	}

}
