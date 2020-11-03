import java.util.ArrayList;
import java.util.Scanner;
public class AdminStars {
	public static void main(String[] args) {}
		Scanner sc = new Scanner(System.in);
	
	public void editStudAccess() {}
	
	public void addStudent() {}
	
	public void updateCourse() {}
	
	public void createCourse() {
		//request user for info needed to create course
		System.out.println("Enter course code:");
		String courseCode=sc.nextLine();
		//send courseCode to unidatabase to check for duplicate
		//if no duplicate, proceed. else, send error message
		boolean duplicateTest1 = uniDataBase.checkCourseDup(courseCode);
		while(duplicateTest1 == true){
			System.out.println("Course code "+courseCode+" already exists. Enter another course code:");
			courseCode=sc.nextLine();
			duplicateCheck1 = uniDataBase.checkCourseIsDup(courseCode);
		};
		System.out.println("Enter course name:");
		String courseName=sc.nextLine();
		System.out.println("Enter school name:");
		String school=sc.nextLine();
		System.out.println("Enter academic units (AU):");
		int acadUnits=sc.nextInt();
		System.out.println("Enter total number of class index:");
		int classIndexListSize=sc.nextInt();
		ArrayList<ClassIndex> indexNumList = new ArrayList<ClassIndex>();
		for (int i=0;i<classIndexListSize;i++) {
			System.out.println("Enter index number for class index "+ (i+1) + ":");
			int indexNum = sc.nextInt();
			//send indexNum to unidatabase to check for duplicate
			//if no duplicate, proceed. else, send error message
			boolean duplicateTest2 = uniDataBase.checkIndexDup(indexNum);
			while(duplicateTest2 == true){
				System.out.println("Index number "+indexNum+" already exists. Enter another index number:");
				indexNum=sc.nextInt();
				duplicateCheck2 = uniDataBase.checkIndexDup(indexNum);
			};
			//courseName obtained above
			System.out.println("Enter class size for class index "+ indexNum + ":");
			int classSize = sc.nextInt();
			//assume no students when new course is added
			System.out.println("Enter total number of lessons:");
			int lessonListSize=sc.nextInt();
			ArrayList<Lesson> lessonList = new ArrayList<Lesson>();
			for (int j=0;j<lessonListSize;j++) {
				int lessonTypeNum;
				do {
				System.out.println("Choose lesson type for lesson "+(j+1)+":");
				System.out.println("(1) Lecture");
				System.out.println("(2) Tutorial");
				System.out.println("(3) Laboratory");
				lessonTypeNum = sc.nextInt();
				}while(lessonTypeNum<1||lessonTypeNum>3);
				LessonType lessonType = LessonType.values()[lessonTypeNum-1];
				System.out.println("Enter class venue for lesson "+ (j+1) +":");
				String classVenue=sc.nextLine();
				System.out.println("Enter total number dates with "+lessonType+":");
				int numOfDate=sc.nextInt();
				ArrayList<Integer> classDate= new ArrayList<>();
				ArrayList<int[]> classTime= new ArrayList<int[]>();
				for (int k=0;k<numOfDate;k++){
					System.out.println("Enter date " +(i+1)+" out of " +numOfDate+" in ddmmyy format:");
					int date=sc.nextInt();
					classDate.add(date);
					System.out.println("Enter class start time for lesson "+ (j+1) +" on " + date +" in 24hr format (hhmm):");
					int startTime=sc.nextInt();
					System.out.println("Enter class end time for lesson "+ (j+1) +" on " + date+" in 24hr format (hhmm):");
					int endTime=sc.nextInt();
					classTime.add(new int[]{startTime,endTime});
					}
				lessonList.add(new Lesson(lessonType,classVenue,classDate,classTime));
				}
			indexNumList.add(new ClassIndex(indexNum,courseName,classSize,classSize,lessonList));
			}
		Course newCourse=new Course(courseCode,courseName,indexNumList,acadUnits,school);
		//pass user input to uniDataBase
		boolean success=uniDataBase.addToCourses(newCourse);
		if (success=!false) 
			{System.out.println("Course added.");
			//display all courses after addition
			//...
			}
		else System.out.println("Course not added.");
		//display all courses after addition
		}
	
	
	public void printStudListByIndex() {
		//request user for index number
		System.out.println("Enter course index number:");
		int indexNum=sc.nextInt();
		
		//pass user input to unidatabase
		boolean success=uniDataBase.findClassIndex(indexNum);
		if (success!=false)
		{  
			ClassIndex classIndex = uniDataBase.getClassIndexPtr();
			uniDataBase.printStudList(classIndex);	
		}
		else System.out.println("Course index not found.");
	}
		
	public void printStudListByCourse() {
		//request user for course code
		System.out.println("Enter course code:");
		String courseCode=sc.nextLine();
		
		//pass user input to unidatabase
		boolean success=uniDataBase.findCourseByCode(courseCode);
		if (success!=false)
		{
			Course course = uniDataBase.getCoursePtr();
			uniDataBase.printStudList(course);	
		}
		else System.out.println("Course not found.");
		
	}
	
	
	
}

