import java.sql.Time;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
public class AdminStars extends STARS{
	Scanner sc = new Scanner(System.in);
	public static void run() {}
	
	public void  editStudAccess(Date startDate,Date endDate) {
		//verify startdate<=endDate
		//update access period
	}
	
	public void  editStudAccess(Time duration) {
		//verify  duration <=24hrs (some max duration)
		//update access duration
	}
	
	public void addStudent(String name, String matricNo, String gender, String nationality, String userName, String pwd ,String email){
		//verifications
		if (verifyExistedStudent(matricNo,userName)==true) {
			System.out.println("Student with matric number "+ matricNo +" or student with username " +
		userName+ " already exists");
			break;
		}
		//create student
		StudentRecords studentRecords = new StudentRecords();
		Student newStudent = new Student(userName, pwd, name , gender , nationality , false, matricNo,
				email, studentRecords);
		//send parameters to unidatabase
		addToStudents(newStudent);
	}
	
	public void  updateCourseCode(String currentCourseCode, String updatedCourseCode) {
		//verifications
		if (verifyCourse(currentCourseCode)==false) {
			System.out.println("Course code "+ currentCourseCode+" does not exist");
			break;
		}
		if (verifyCourse(updatedCourseCode)==true) {
			System.out.println("Course code "+updatedCourseCode+" already exists");
			break;
		}
		//send parameters to unidatabase
		updateCourseCode(currentCourseCode,updatedCourseCode);
	}
	
	public void updateCourseSchool(String courseCode, String updatedSchool) {
		//verifications
		if (verifyCourse(courseCode)==false) {
			System.out.println("Course code "+courseCode+" does not exist");
			break;
		}
		//send parameters to unidatabase
		updateCourseSchool(courseCode, updatedSchool);

	}
	
	public void updateCourseIndexNumber(int currentIndexNumber, int updatedIndexNumber) {
		//verifications
		if (verifyClassIndex(currentIndexNumber)==false) {
			System.out.println("Course index "+ currentIndexNumber +" does not exist");
			break;
		}
		if (verifyClassIndex(updatedIndexNumber)==true) {
			System.out.println("Course index "+updatedIndexNumber+" already exists");
			break;
		}
		ClassIndex classIndex = findClassIndex(currentIndexNumber);
		String courseCode= classIndex.getCourseCode();
		//send parameters to unidatabase
		updateCourseIndexNum(courseCode,currentIndexNumber,updatedIndexNumber); 
	}

	
	public void updateIndexNumberVacancy(int indexNumber,int updatedVacancyNumber){
		//verification
		if (verifyClassIndex(indexNumber)==false) {
			System.out.println("Course index "+indexNumber+" does not exist");
			break;
		}
		ClassIndex classIndex = findClassIndex(indexNumber);
		String courseCode= classIndex.getCourseCode();
		//send parameters to unidatabase
		updateCourseVacancy(courseCode,indexNumber,updatedVacancyNumber);
	}
	
	public void createCourse(String courseCode,String courseName,String school,
			int indexNum, int classVacancy,int acadUnits,
			LessonType lessonType,String classVenue,Day classDay,int[] classTime,Week classWeek) {
		//verifications
		if (verifyCourse(courseCode)==true) {
			System.out.println("Course code "+courseCode+" already exists");
			break;
		}
		if (verifyClassIndex(indexNum)==true) {
			System.out.println("Course index "+indexNum+" already exists");
			break;
		}
		if (verifyVenueClash(classVenue,classDay,classTime)==true) {
			System.out.println("There is a clash of venue at "+ classVenue +" on "+classDay+" from "
					+ classTime[0] + " to " + classTime[1]);
			break;
		}
		//create all ArrayList required
		ArrayList <ClassIndex> indexNumList = new ArrayList <ClassIndex>();
		ArrayList <Lesson> lessonsList = new ArrayList <Lesson>();
		ArrayList <Student> studentsList = new ArrayList <Student>();
		ArrayList <Student> waitList = new ArrayList <Student>();
		//create lesson,adding it to lessonsList
		lessonsList.add(new Lesson(lessonType,classVenue,classDay,classTime,classWeek));
		//create class index, adding it to indexNumList
		indexNumList.add(new ClassIndex(courseName,courseCode,indexNum,classVacancy,lessonsList,studentsList,waitList));
		//create course
		Course newCourse=new Course(courseCode,courseName,indexNumList,acadUnits,school);
		//send newCourse to unidatabase
		addToCourses(newCourse);
		System.out.println("New course added");
		//display all courses after addition
		displayAllCourses();
	}
	
	public void printStudListByIndex(int indexNum) {
		//Verify existence of such a course index
		if (verifyClassIndex(indexNum)==true)
		{  
			ClassIndex classIndex =findClassIndex(indexNum);
			printStudList(classIndex);	
		}
		else System.out.println("Course index not found.");
	}
		
	public void printStudListByCourse(String courseCode) {	
		//Verify existence of such a course
		if (verifyCourse(courseCode)==true)
		{
			Course course = findCourseByCode(courseCode);
			printStudList(course);	
		}
		else System.out.println("Course not found.");
		
	}
	
}
