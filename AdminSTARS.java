import java.sql.Time;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
public class AdminStars extends STARS{
	public static void run() {}
		Scanner sc = new Scanner(System.in);
	
	public void editStudAccess() {
		int choice1;
		System.out.println("(1) Edit student access period");
		System.out.println("(2) Edit student access duration");
		System.out.println("(3) Exit");
		do {
			System.out.println("Enter update of your choice : ");
			choice1=sc.nextInt();
			switch(choice1)
			{
				case 1:
					System.out.println("Cuurent student access period : " + getStudentAccessPeriod()[0]+" to "+getStudentAccessPeriod()[1]);
					System.out.println("Enter new student access starting date in dd-mm-yyyy format : ");
					String date1=sc.nextLine();
					SimpleDateFormat format=new SimpleDateFormat(“dd-mm-yyyy”);
					Date startDate=format.parse(date1);
					Date endDate;
					do{
					System.out.println("Enter new student access end date in dd-mm-yyyy format : ");
					String date2=sc.nextLine();
					SimpleDateFormat format=new SimpleDateFormat(“dd-mm-yyyy”);
					Date endDate=format.parse(date2);
					}while(startDate.compareTo(endDate)!=-1);
					//send info to unidatabase
					Date[] newPeriod = {startDate,endDate};
					uniDataBase.setStudAccessPeriod(newPeriod);
					System.out.println("Student access period updated.");
					break;
				case 2:
					System.out.println("Cuurent student access duration : " + getStudentAccessDuration());
					System.out.println("Adding new student access duration in (hh:mm:ss) format : ");
					int hour;
					do {
					System.out.println("Enter new student access duration for hour (hh) : ");
					hour=sc.nextInt();
					}while(hour<0);
					int min;
					do {
					System.out.println("Enter new student access duration for minute (mm) : ");
					min=sc.nextInt();
					}while(min<0||min>=60);
					int sec;
					do {
					System.out.println("Enter new student access duration for second (ss) : ");
					sec=sc.nextInt();
					}while(sec<0||sec>=60);
					long milli = (60*((60*hour)+min)+sec)*1000;
					//send info to unidatabase
					Time newDuration = new Time(milli);
					uniDataBase.setStudAccessDuration(newDuration);
					System.out.println("Student access duration updated.");
					break;
				default:
					System.out.println("(1) Edit student access period");
					System.out.println("(2) Edit student access duration");
					System.out.println("(3) Exit");
					break;
			}
		}while(choice1!=3);	
	}
	
	public void addStudent() {
		//request all info needed for Student 
		System.out.println("Enter new Student username : ");
		String userName=sc.nextLine();
		//check no duplicate username
		//...
		System.out.println("Enter new Student password : ");
		String pwd = sc.nextLine();
		//hash password
		//...
		System.out.println("Enter new Student name : ");
		String name=sc.nextLine();
		System.out.println("Enter new Student gender : ");
		String gender=sc.nextLine();
		System.out.println("Enter new Student nationality : ");
		String gender=sc.nextLine();
		System.out.println("Enter new Student matriculation number : ");
		String matricNo=sc.nextLine();
		//check no duplicate matric number
		//...
		System.out.println("Enter new Student email : ");
		String email=sc.nextLine();
		//check no duplicate email
		//...
		StudentRecords studentRecords=new StudentRecords();
		Student newStudent=new Student(userName,pwd,name,gender,nationality,false, matricNo,email,studentRecords);
		//send info to uniDataBase
		uniDataBase.addToStudents(newStudent);
	}
	
	public void updateCourse() {
		//request user for course code, check if course code exist,loop if it doesn't exist
		System.out.println("Enter course code:");
		String courseCode=sc.nextLine();
		boolean exist=uniDataBase.VerifyCourse(courseCode);
		while (exist==false)
		{
			System.out.println("Course code "+courseCode+" does not exist. Enter another course code:");
			courseCode=sc.nextLine();
			exist=uniDataBase.VerifyCourse(courseCode);
		}
			Course course = uniDataBase.findCourseByCode(courseCode);
			//show menu for available updates
			int choice1;
			System.out.println("(1)	Edit general course infomation");
			System.out.println("(2) Add new course index");
			System.out.println("(3) Delete a course index");
			System.out.println("(4) Edit an existing course index");
			System.out.println("(5) Exit");
			do {
				System.out.println("Enter the update of your choice: ");
				choice1 = sc.nextInt();
				
				switch (choice1) {
				case 1: 
					int choice11;
					System.out.println("(1)	Edit course code");
					System.out.println("(2) Edit course name");
					System.out.println("(3) Edit academic units");
					System.out.println("(4) Edit school name");
					System.out.println("(5) Exit");
					do {
						System.out.println("Enter the update of your choice: ");
						choice11 = sc.nextInt();
						
						switch (choice11) {
						case 1: 
							System.out.println("Current course code : "+courseCode);
							System.out.println("Enter new course code : ");
							String newCourseCode=sc.nextLine();
							boolean duplicateTest1 = uniDataBase.VerifyCourse(newCourseCode);
							while(duplicateTest1 == true){
								System.out.println("Course code "+newCourseCode+" already exists. Enter another course code:");
								newCourseCode=sc.nextLine();
								duplicateTest1 = uniDataBase.VerifyCourse(newCourseCode);
							};
							//update coursecode of classindex belonging to the course
							ArrayList<ClassIndex> indexNumList = course.getIndexNumList();
							for (int count=0;count<indexNumList.size();count++) {
								indexNumList.get(count).setCourseCode(newCourseCode);
							};
							//send info to uniDataBase
							uniDataBase.updateCourseCode(courseCode,newCourseCode);
							courseCode=newCourseCode;
							System.out.println("Course code updated.");
							uniDataBase.updateCourseIndexNum(courseCode,indexNumList);
							System.out.println("Course code of the relevant course index updated.");
						
							break;
						case 2: 
							System.out.println("Current course name : " + course.getCourseName());
							System.out.println("Enter new course name : ");
							String newCourseName=sc.nextLine();
							uniDataBase.updateCourseName(courseCode,newCourseName);
							System.out.println("Course name updated.");
							//update course name of relevant course index
							ArrayList<ClassIndex> indexNumList = course.getIndexNumList();
							for (int count=0;count<indexNumList.size();count++) {
								indexNumList.get(count).setCourseName(newCourseName);
							};
							uniDataBase.updateCourseIndexNum(courseCode,indexNumList);
							System.out.println("Course name of the relevant course index updated.");
							break;
						case 3: 
							System.out.println("Current academic units (AU) : "+course.getAcadUnits());
							System.out.println("Enter new academic units (AU) :");
							int newAcadUnits=sc.nextInt();
							uniDataBase.updateCourseAcadUnits(courseCode,newAcadUnits);
							System.out.println("Academic units updated.");
							break;
						case 4: 
							System.out.println("Current school name : "+course.getSchool());
							System.out.println("Enter new school name:");
							String newSchool=sc.nextLine();	
							uniDataBase.updateCourseSchool(courseCode,newSchool);
							System.out.println("School name updated.");
							break;
						default: 
							System.out.println("(1)	Edit course code");
							System.out.println("(2) Edit course name");
							System.out.println("(3) Edit academic units");
							System.out.println("(4) Edit school of course");
							System.out.println("(5) Exit");
						}
					} while (choice11 !=5);
					break;
				case 2: 
					//add new course index to existing course
					ArrayList<ClassIndex> indexNumList = course.getIndexNumList();
					System.out.println("Enter course index number : ");
					int indexNum = sc.nextInt();
					String courseName = course.getCourseName();
					String courseCode = course.getcourseCode();
					//send indexNum to uniDataBase to check for duplicate
					//if no duplicate, proceed. else, send error message
					boolean duplicateTest2 = uniDataBase.verifyClassIndex(indexNum);
					while(duplicateTest2 == true){
						System.out.println("Index number "+indexNum+" already exists. Enter another index number:");
						indexNum=sc.nextInt();
						duplicateTest2 = uniDataBase.verifyClassIndex(indexNum);
					};
					System.out.println("Enter class size for course index "+ indexNum + ":");
					int classSize = sc.nextInt();
					//assume no students when new course is added
					System.out.println("Enter total number of lessons :");
					int lessonListSize=sc.nextInt();
					ArrayList<Lesson> lessonList = new ArrayList<Lesson>();
					for (int j=0;j<lessonListSize;j++) {
						int lessonTypeNum;
						do {
						System.out.println("Choose lesson type for lesson "+(j+1)+":");
						System.out.println("(1) Lecture\n(2) Tutorial\n(3) Laboratory");
						lessonTypeNum = sc.nextInt();
						}while(lessonTypeNum<1||lessonTypeNum>3);
						LessonType lessonType = LessonType.values()[lessonTypeNum-1];
						System.out.println("Enter class venue for lesson "+ (j+1) +":");
						String classVenue=sc.nextLine();
						//request input for Day
						int chooseDay;
						do {
							System.out.println("Enter day of the week for lesson "+ (j+1) +":");
							System.out.println("(1) MON\n (2) TUE\n(3) WED\n (4) THU\n (5) FRI");
							chooseDay=sc.nextInt();
						}while(chooseDay<1||chooseDay>5);
						Day classDay = Day.values()[chooseDay-1];
						//request input for Week
						int chooseWeek;
						do {
							System.out.println("Enter week type for lesson "+ (j+1) +":");
							System.out.println("(1) Week 1-13\n (2) Even Weeks\n(3) Odd Weeks");
							chooseWeek=sc.nextInt();
						}while(chooseWeek<1||chooseWeek>3);
						Week classWeek = Week.values()[chooseWeek-1];
						//request input for Time
						System.out.println("Enter class start time for lesson "+ (j+1) +" on " + classDay +" in 24hr format (hhmm):");
						int startTime=sc.nextInt();
						System.out.println("Enter class end time for lesson "+ (j+1) +" on " + classDay +" in 24hr format (hhmm):");
						int endTime=sc.nextInt();
						int[] classTime={startTime,endTime};
						lessonList.add(new Lesson(lessonType,classVenue,classDay,classTime,classWeek));
						}
					indexNumList.add(new ClassIndex(courseName,courseCode,indexNum,classSize,classSize,lessonList));
					
					//send info to uniDataBase
					uniDataBase.updateCourseIndexNum(courseCode,indexNumList);
					System.out.println("Course index added.");
					break;
				case 3: 
					ArrayList<ClassIndex> indexNumList = course.getIndexNumList();
					System.out.println("Current list of course index numbers : ");
					for (int count=0;count<indexNumList.size();count++) {
						System.out.println(indexNumList.get(count).getIndexNum());
					}
					System.out.println("Enter course index number to be removed : ");
					int indexNum2 = sc.nextInt();
					boolean duplicateTest3 = uniDataBase.verifyClassIndex(indexNum2);
					while(duplicateTest3 == false){
						System.out.println("Index number "+indexNum2+" does not exist. Enter another index number:");
						indexNum2=sc.nextInt();
						duplicateTest3 = uniDataBase.verifyClassIndex(indexNum2);
					};
					ClassIndex classIndex=uniDataBase.findClassIndex(indexNum);
					indexNumList.remove(classIndex);
					//send info to uniDataBase
					uniDataBase.updateCourseIndexNum(courseCode,indexNumList);
					System.out.println("Course index removed.");
					break;
				case 4: 
					updateClassIndex(course);
					break;
				default: 
					System.out.println("(1)	Edit general course infomation");
					System.out.println("(2) Add new course index");
					System.out.println("(3) Delete a course index");
					System.out.println("(4) Edit an existing course index");
					System.out.println("(5) Exit");
				}
			} while (choice1 !=5);//
			//
	}
	
	public void updateClassIndex(Course course) {
		String courseCode=course.getCourseCode();
		String courseName=course.getCourseName();
		//select course/class index to be edited
		ArrayList<ClassIndex> indexNumList = course.getIndexNumList();
		System.out.println("Current list of course index numbers : ");
		for (int count=0;count<indexNumList.size();count++) {
			System.out.println(indexNumList.get(count).getIndexNum());
		};
		System.out.println("Enter course index number to be edited : ");
		int indexNum = sc.nextInt();
		boolean exist = uniDataBase.verifyClassIndex(indexNum);
		while(exist == false){
			System.out.println("Index number "+indexNum+" does not exist. Enter another index number:");
			indexNum=sc.nextInt();
			exist = uniDataBase.verifyClassIndex(indexNum);
		};
		ClassIndex classIndex=uniDataBase.findClassIndex(indexNum);
		int choice1;
		System.out.println("(1)	Edit index number");
		System.out.println("(2) Edit class size");
		System.out.println("(3) Edit lessons");
		System.out.println("(4) Edit list of student");
		System.out.println("(5) Exit");
		do {
			System.out.println("Enter the update of your choice: ");
			choice1 = sc.nextInt();
			
			switch (choice1) {
				case 1: 
					System.out.println("Current course index number : "+indexNum);
					System.out.println("Enter new course index number : ");
					int newIndexNum=sc.nextInt();
					boolean duplicateTest1 = uniDataBase.verifyClassIndex(newIndexNum);
					while(duplicateTest1 == true){
						System.out.println("Course index number "+newIndexNum+" already exists. Enter another course index number:");
						newIndexNum=sc.nextInt();
						duplicateTest1 = uniDataBase.verifyClassIndex(newIndexNum);
					};
					classIndex.setIndexNum(newIndexNum);
					//send info to uniDataBase
					uniDataBase.updateCourseIndexNum(courseCode,indexNumList);
					indexNum=newIndexNum;
					System.out.println("Course index number updated.");
					break;
				case 2: 
					int classSize =classIndex.getClassSize();
					ArrayList<Student> studList=classIndex.getStudentList();
					int currentSize = studList.size();
					System.out.println("Current class size : "+classSize);
					System.out.println("Current number of student : "+currentSize);
					System.out.println("Enter new class size : ");
					int newClassSize=sc.nextInt();
					while(newClassSize<0||newClassSize-currentSize<0) {
						System.out.println("Invalid class size. Enter new class size : ");
						newClassSize=sc.nextInt();
					}
					//update class size
					classIndex.setClassSize(newClassSize);
					//update vacancy
					int newClassVacancy = newClassSize-currentSize;
					classIndex.setClassVacancy(newClassVacancy);	
					//send info to uniDataBase
					uniDataBase.updateCourseIndexNum(courseCode,indexNumList);
					//send info to uniDataBase
					uniDataBase.updateCourseVacancy(courseCode,indexNumList,newClassVacancy);
					System.out.println("Class size updated.");
					classSize=newClassSize;
					break;
				case 3: 
					ArrayList<Lesson> lessonList = classIndex.getLessonList();
					int choice2;
					System.out.println("(1)	Add lesson to course index");
					System.out.println("(2) Remove lesson from course index");
					System.out.println("(3) Exit");
					do {
						System.out.println("Enter the update of your choice: ");
						choice2 = sc.nextInt();
						switch(choice2)
						{
						case 1:
							int lessonTypeNum;
							do {
								System.out.println("Choose lesson type : ");
								System.out.println("(1) Lecture\n(2) Tutorial\n(3) Laboratory");
								lessonTypeNum = sc.nextInt();
							}while(lessonTypeNum<1||lessonTypeNum>3);
							LessonType lessonType = LessonType.values()[lessonTypeNum-1];
							System.out.println("Enter class venue for the lesson : ");
							String classVenue=sc.nextLine();
							int chooseDay;
							do {
								System.out.println("Enter day of the week for the lesson :");
								System.out.println("(1) MON\n (2) TUE\n(3) WED\n (4) THU\n (5) FRI");
								chooseDay=sc.nextInt();
							}while(chooseDay<1||chooseDay>5);
							Day classDay = Day.values()[chooseDay-1];
							int chooseWeek;
							do {
								System.out.println("Enter week type for the lesson :");
								System.out.println("(1) Week 1-13\n (2) Even Weeks\n(3) Odd Weeks");
								chooseWeek=sc.nextInt();
							}while(chooseWeek<1||chooseWeek>3);
							Week classWeek = Week.values()[chooseWeek-1];
							System.out.println("Enter class start time for lesson in 24hr format (hhmm):");
							int startTime=sc.nextInt();
							System.out.println("Enter class end time for lesson in 24hr format (hhmm):");
							int endTime=sc.nextInt();
							int[] classTime={startTime,endTime};
							lessonList.add(new Lesson(lessonType,classVenue,classDay,classTime,classWeek));								
							indexNumList.add(new ClassIndex(courseName,courseCode,indexNum,classSize,classSize,lessonList));
							
							//send info to uniDataBase
							uniDataBase.updateCourseIndexNum(courseCode,indexNumList);
							break;
						case 2:
							//show current list of lesson
							System.out.println("Current list of lesson : ");
							int lessonListSize = lessonList.size();
							if (lessonListSize=0)
							{
								System.out.println("Currently there is no list of lesson for "+indexNum);
								break;
							}
							for (int i=0;i<lessonListSize;i++)
							{
								System.out.println("Lesson "+(i+1)+"\tLesson type: "+lessonList.get(i).getLessonType()+"\tDay: "+lessonList.get(i).getClassDay());
							}
							int chooseLesson;
							do {
							System.out.println("Enter lesson to be removed : ");
							for (int i=0;i<lessonListSize;i++)
							{
								System.out.println("("+(1+i)+")"+" Lesson "+(i+1)+"\tLesson type: "+lessonList.get(i).getLessonType()+"\tDay: "+lessonList.get(i).getClassDay());
								chooseLesson = sc.nextInt();
							}
							}while(chooseLesson<1||chooseLesson>lessonListSize);
							break;
							lessonList.remove(chooseLesson-1);
							//send info to uniDataBase
							uniDataBase.updateCourseIndexNum(courseCode,indexNumList);
						default:
							System.out.println("(1)	Add lesson to course index");
							System.out.println("(2) Remove lesson from course index");
							System.out.println("(3) Exit");
						}
						
					}while (choice2 !=3);
					break;
				case 4: 
					int choice3;
					System.out.println("(1)	Add student to course index");
					System.out.println("(2) Remove student from course index");
					System.out.println("(3) Exit");
					do {
						System.out.println("Enter the update of your choice: ");
						choice3 = sc.nextInt();
						switch(choice3)
						{
						case 1:
							//check class size > size of current student list
							int classSize2 =classIndex.getClassSize();
							ArrayList<Student> studList2=classIndex.getStudentList();
							int currentSize2 = studList2.size();
							if(classSize2-currentSize2<=0)
							{
								System.out.println("Unable to add student due to class size.");
								break;
							}
							System.out.println("Enter the matriculation number of student to be added : ");
							String matricNo = sc.nextLine();
							boolean exist2 = uniDataBase.VerifyStudent(matricNo);
							while(exist2 == false){
								System.out.println("Student with matriculation number "+matricNo+" does not exist. Try again : ");
								matricNo=sc.nextInt();
								exist2 = uniDataBase.VerifyStudent(matricNo);
							};
							Student student = uniDataBase.findStudentByMatric(matricNo);
							studList2.add(student);
							//send info to uniDataBase
							uniDataBase.updateCourseIndexNum(courseCode,indexNumList);
							break;
						case 2:
							break;
							//check size of current student list > 0
							int classSize2 =classIndex.getClassSize();
							ArrayList<Student> studList2=classIndex.getStudentList();
							int currentSize2 = studList2.size();
							if(currentSize2<=0)
							{
								System.out.println("No student to be removed.");
								break;
							}
							System.out.println("Current list of student's matriculation number in the class: ");
							for(int i=0;i<currentSize2;i++) {
							System.out.println(studList2.get(i).getMatricNo());
							}
							System.out.println("Enter the matriculation number of student to be removed : ");
							String matricNo = sc.nextLine();
							boolean exist2 = uniDataBase.VerifyStudent(matricNo);
							while(exist2 == false){
								System.out.println("Student with matriculation number "+matricNo+" does not exist. "
										+ "Enter another matriculation number : ");
								matricNo=sc.nextLine();
								exist2 = uniDataBase.VerifyStudent(matricNo);
							};
							Student student2 = uniDataBase.findStudentByMatric(matricNo);
							//check if student is in the class
							if(studList2.contains(student2)) {
								studList2.remove(student2);
								//send info to uniDataBase
								uniDataBase.updateCourseIndexNum(courseCode,indexNumList);
							}
							else {
								System.out.println("Student with matriculation number "+matricNo+" is not in the class list.");
							}
;
							break;
						default:
							System.out.println("(1)	Add student to course index");
							System.out.println("(2) Remove student from course index");
							System.out.println("(3) Exit");
						}
						
					}while (choice3 !=3);
					break;
				default: 
					System.out.println("(1)	Edit index number");
					System.out.println("(2) Edit class size");
					System.out.println("(3) Edit lessons");
					System.out.println("(4) Edit list of student");
					System.out.println("(5) Exit");
					
			}
		} while (choice1 !=5);
		
		
	}
	
	public void createCourse() {
		//request user for info needed to create course
		System.out.println("Enter course code:");
		String courseCode=sc.nextLine();
		//send courseCode to uniDataBase to check for duplicate
		//if no duplicate, proceed. else, send error message
		boolean duplicateTest1 = uniDataBase.VerifyCourse(courseCode);
		while(duplicateTest1 == true){
			System.out.println("Course code "+courseCode+" already exists. Enter another course code:");
			courseCode=sc.nextLine();
			duplicateTest1 = uniDataBase.VerifyCourse(courseCode);
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
			System.out.println("Enter course index number "+(i+1)+" of "+classIndexListSize+":");
			
			int indexNum = sc.nextInt();
			//send indexNum to uniDataBase to check for duplicate
			//if no duplicate, proceed. else, send error message
			boolean duplicateTest2 = uniDataBase.verifyClassIndex(indexNum);
			while(duplicateTest2 == true){
				System.out.println("Index number "+indexNum+" already exists. Enter another index number:");
				indexNum=sc.nextInt();
				duplicateTest2 = uniDataBase.verifyClassIndex(indexNum);
			};
			//courseName obtained above
			System.out.println("Enter class size for course index "+ indexNum + ":");
			int classSize = sc.nextInt();
			//assume no students when new course is added
			System.out.println("Enter total number of lesson in a week in general:");
			int lessonListSize=sc.nextInt();
			ArrayList<Lesson> lessonList = new ArrayList<Lesson>();
			for (int j=0;j<lessonListSize;j++) {
				int lessonTypeNum;
				do {
				System.out.println("Choose lesson type for lesson "+(j+1)+":");
				System.out.println("(1) Lecture\n(2) Tutorial\n(3) Laboratory");
				lessonTypeNum = sc.nextInt();
				}while(lessonTypeNum<1||lessonTypeNum>3);
				LessonType lessonType = LessonType.values()[lessonTypeNum-1];
				System.out.println("Enter class venue for lesson "+ (j+1) +":");
				String classVenue=sc.nextLine();
				int chooseDay;
				do {
					System.out.println("Enter day of the week for lesson "+ (j+1) +":");
					System.out.println("(1) MON\n (2) TUE\n(3) WED\n (4) THU\n (5) FRI");
					chooseDay=sc.nextInt();
				}while(chooseDay<1||chooseDay>5);
				Day classDay = Day.values()[chooseDay-1];
				int chooseWeek;
				do {
					System.out.println("Enter week type for lesson "+ (j+1) +":");
					System.out.println("(1) Week 1-13\n (2) Even Weeks\n(3) Odd Weeks");
					chooseWeek=sc.nextInt();
				}while(chooseWeek<1||chooseWeek>3);
				Week classWeek = Week.values()[chooseWeek-1];
				System.out.println("Enter class start time for lesson "+ (j+1) +" on " + classDay +" in 24hr format (hhmm):");
				int startTime=sc.nextInt();
				System.out.println("Enter class end time for lesson "+ (j+1) +" on " + classDay+" in 24hr format (hhmm):");
				int endTime=sc.nextInt();
				int[] classTime={startTime,endTime};
				lessonList.add(new Lesson(lessonType,classVenue,classDay,classTime,classWeek));
				}
			indexNumList.add(new ClassIndex(courseName,courseCode,indexNum,classSize,classSize,lessonList));
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
		
		}
	
	
	public void printStudListByIndex() {
		//request user for index number
		System.out.println("Enter course index number:");
		int indexNum=sc.nextInt();
		
		//pass user input to uniDataBase
		boolean success=uniDataBase.verifyClassIndex(indexNum);
		if (success!=false)
		{  
			ClassIndex classIndex = uniDataBase.findClassIndex(indexNum);
			uniDataBase.printStudList(classIndex);	
		}
		else System.out.println("Course index not found.");
	}
		
	public void printStudListByCourse() {
		//request user for course code
		System.out.println("Enter course code:");
		String courseCode=sc.nextLine();
		
		//pass user input to uniDataBase
		boolean success=uniDataBase.VerifyCourse(courseCode);
		if (success!=false)
		{
			Course course = uniDataBase.findCourseByCode(courseCode);
			uniDataBase.printStudList(course);	
		}
		else System.out.println("Course not found.");
		
	}
	
	
	
}
	
