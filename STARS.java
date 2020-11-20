import java.util.ArrayList;

public class STARS {
	
	public static void checkVacancies(int indexNumber) {
		//verification
		if (UniDataBase.verifyClassIndex(indexNumber)==false) {
			System.out.println("Course index "+indexNumber+" does not exist");
			return;
		}
		ClassIndex classIndex = UniDataBase.findClassIndex(indexNumber);
		int classVacancy= classIndex.getClassVacancy();
		int totalClassSize= classVacancy + classIndex.getStudentList().size();
		System.out.println("Course index "+indexNumber+" has "+classVacancy+" slot(s) left and maximum class size of "+totalClassSize+".");
	}
	
	public static void showErrorMessage() {
		System.out.println("Error! Please input again!");
	}
	
	public static void showAllCourses() {
		String courseCode,lessonType,classDay,classVenue;
		int indexNum,au,lessonsListSize,starttime,endtime;
		Course course;
		Lesson lesson;
		System.out.println("Printing all courses... :");
		System.out.println(String.format("%-13s%-4s%-11s%-6s%-5s%-9s%2s%2s","Course Code","AU","Index No.","Type","Day","Time"," ","Venue")); 
		System.out.println(String.format("%63s", "-").replace(' ', '-'));
		ArrayList<Course> allCourses=UniDataBase.courses;
		int allCoursesSize=allCourses.size();
		for(int k=0;k<allCoursesSize;k++) {
			course=allCourses.get(k);
			ArrayList<ClassIndex> allIndexNumList=course.getIndexNumList();
			int allIndexNumListSize = allIndexNumList.size();
			for(int i=0;i<allIndexNumListSize;i++) {
				courseCode = allIndexNumList.get(i).getCourseCode(); 
				indexNum = allIndexNumList.get(i).getIndexNum();
				course=UniDataBase.findCourseByCode(courseCode);
				au=course.getAcadUnits();
				lessonsListSize=allIndexNumList.get(i).getLessonsList().size();
				for(int j=0;j<lessonsListSize;j++) {
					lesson=allIndexNumList.get(i).getLessonsList().get(j);
					lessonType=lesson.getLessonType();
					classDay=lesson.getClassDay();
					classVenue=lesson.getClassVenue();
					starttime = lesson.getClassTiming()[0];
					endtime=lesson.getClassTiming()[1];
					if(j==0) {
						System.out.println(String.format("%-13s%-4d%-11d%-6s%-5s%04d%-1s%04d%2s%2s", courseCode, au,indexNum,lessonType,classDay,starttime,"-",endtime," ",classVenue));
					}
					else {
						System.out.println(String.format("%-13s%-4s%-11s%-6s%-5s%04d%-1s%04d%2s%2s", " ", " ", " ",lessonType,classDay,starttime,"-",endtime," ",classVenue));	
					}
				}
			}
		}
	}
}

