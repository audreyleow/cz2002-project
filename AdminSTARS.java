import java.sql.Time;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class AdminStars extends STARS{
	Scanner sc = new Scanner(System.in);
	
	public static void run ()
	{
		System.out.println("============== STARS Menu ==============\r\n" + 
				   "|1. Edit Student Access Period         |\r\n" + 
				   "|2. Add A Student                      |\r\n" + 
				   "|3. Add A Course                       |\r\n" +
				   "|4. Update Course Code                 |\r\n" +
				   "|5. Update Course School               |\r\n" +
				   "|6. Update Course Index Number         |\r\n" +
				   "|7. Update Index Number Vacancy        |\r\n" +
				   "|8. Check Class Vacancies              |\r\n" + 
				   "|9. Print Student List by Index Number |\r\n" + 
				   "|10.Print Student List by Course       |\r\n" + 
				   "|11.Log Out                            |\r\n" + 
				   "========================================\r\n");
		int inputChoice;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print ("\nWhat do you wish to do?");
			inputChoice = scan.nextInt();
			switch(inputChoice) {
				case 1: // Edit Student Access Period
					// Insert code later
					break;
				case 2: // Add A Student
					String newName, newMatricNo, newGender, newNationality,newUserName, newPassword;
					int genderChoice;
					System.out.print("Input name of new student:");
					newName = scan.nextLine();
					newName = newName.trim();								// Remove any whitespace at both ends of String
					newName = newName.replaceAll("\\s+","");				// Remove any whitespace in String 
					System.out.println("New Name Input: "+newName);
					System.out.print("Input matriculation number of new student:");
					newMatricNo = scan.nextLine();
					newMatricNo = newMatricNo.trim();						// Remove any whitespace at both ends of String
					newMatricNo = newMatricNo.replaceAll("\\s+","");		// Remove any whitespace in String 
					System.out.println("New Matriculation Number Input: "+newMatricNo);
					// ---------------------------------------Gender---------------------------------
					System.out.println("======= Gender =========\r\n" + 
							   "|1. Male   |2. Female  |\r\n" + 
							   "========================\r\n");
					do {
						System.out.print("Input gender of new student:");
						genderChoice = scan.nextInt();
						if (genderChoice<1 || genderChoice>2) {
							System.out.println("Please input a positive integer from 1 or 2");
						}
					}while (genderChoice<1 || genderChoice>2);
					if(genderChoice == 1) {
						newGender = "Male";
					}
					else {
						newGender = "Female";
					}
					scan.nextLine();  // Consume newline left-over
					System.out.println("New Gender Input: "+newGender);
					System.out.print("Input nationality of new student:");
					newNationality = scan.nextLine();
					newNationality = newNationality.trim();					// Remove any whitespace at both ends of String
					newNationality = newNationality.replaceAll("\\s+","");	// Remove any whitespace in String 
					System.out.println("New Nationality Input: "+newNationality);
					System.out.print("Input username of new student:");
					newUserName = scan.nextLine();
					newUserName = newUserName.trim();						// Remove any whitespace at both ends of String
					newUserName = newUserName.replaceAll("\\s+","");		// Remove any whitespace in String
					System.out.println("New Username Input: "+newUserName);
					newPassword = newMatricNo;
					System.out.println("New Password Input: "+newPassword);
					// addStudent(newName, newMatricNo, newGender, newNationality, newUserName, newPassword);
					break;
				case 3: // Add A Course  
					String newCourseCode, newCourseName, newSchool, newClassVenue, newClassDay, newClassWeek;
					int newIndexNum, newClassVacancy, newAcadUnits, schoolNo, dayNo, weekNo, startTime, endTime;
					String newLessonType = "LECT";
					int[] newClassTiming = new int[2];  // first is startTime, second is endTime
					System.out.print("Input course code of new course:");
					newCourseCode = scan.nextLine();
					newCourseCode = newCourseCode.trim();								// Remove any whitespace at both ends of String
					newCourseCode = newCourseCode.replaceAll("\\s+","");				// Remove any whitespace in String 
					System.out.println("New Course Code Input: "+newCourseCode);
					System.out.print("Input course name of new course:");
					newCourseName = scan.nextLine();
					newCourseName = newCourseName.trim();								// Remove any whitespace at both ends of String
					newCourseName = newCourseName.replaceAll("\\s+","");				// Remove any whitespace in String 
					System.out.println("New Course Name Input: "+newCourseName);
					System.out.println("============= Schools ==============\r\n" + 
							   "|1. NBS          |10. SSS          |\r\n" + 
							   "|2. CBE          |11. WKWSCI       |\r\n" +
							   "|3. CEE          |12. SBS          |\r\n" +
							   "|4. SCSE         |13. SPMS         |\r\n" + 
							   "|5. EEE          |14. ASE          |\r\n" + 
							   "|6. MSE          |15. LKCSoM       |\r\n" + 
							   "|7. MAE          |16. NIE          |\r\n" + 
							   "|8. ADM          |17. RSIS         |\r\n" + 
							   "|9. SOH                            |\r\n" +
							   "====================================\r\n");
					String [] listOfSchools = {"NBS", "CBE", "CEE","SCSE","EEE","MSE","MAE","ADM","SOH","SSS","WKWSCI","SBS","SPMS","ASE","LKCSoM","NIE","RSIS"}; 
					do {
						System.out.println("Input school of new course(1-17):");
						schoolNo = scan.nextInt();
						if(schoolNo<1 || schoolNo>17) {
							System.out.println("Please insert a positive integer from 1 to 17.");
						}
					}while(schoolNo<1 || schoolNo>17);
					newSchool = listOfSchools[schoolNo-1];
					System.out.println("New Course School Input: "+newSchool);
					do {
						System.out.print("Input course's academic units:");
						newAcadUnits = scan.nextInt();
						if(newAcadUnits<1 || newAcadUnits>4) {
							System.out.println("Please insert a positive value from 1 to 4");
						}
					}while(newAcadUnits<1 || newAcadUnits>4);
					System.out.println("New Course Academic Units Input: "+newAcadUnits);
					do {
						System.out.print("Input an index number of the new course (Additional index numbers to be added using the update course option):");
						newIndexNum = scan.nextInt();
						if(newIndexNum <= 0) {
							System.out.println("Please insert a positive integer.");
						}
					}while(newIndexNum <= 0);
					System.out.println("New Course Lecture Index Number Input: "+newIndexNum);
					do {
						System.out.print("Input class vacancy of new course:");
						newClassVacancy = scan.nextInt();
						if(newClassVacancy <= 0) {
							System.out.println("Please insert a positive integer.");
						}
					}while(newClassVacancy <= 0);
					System.out.println("New Course Lecture Vacancy Input: "+newClassVacancy);
					scan.nextLine();  // Consume newline left-over
					System.out.print("Input lecture class venue of new course:");
					newClassVenue = scan.nextLine();
					newClassVenue = newClassVenue.trim();								// Remove any whitespace at both ends of String
					newClassVenue = newClassVenue.replaceAll("\\s+","");				// Remove any whitespace in String 
					System.out.println("New Course Lecture Venue Input: "+newClassVenue);
					System.out.println("========== Days of Week ===========\r\n" + 
							   "|1. MON          |4. THUR         |\r\n" + 
							   "|2. TUE          |5. FRI          |\r\n" +
							   "|3. WED                           |\r\n" +
							   "====================================\r\n");
					String [] listOfDays = {"MON", "TUE", "WED","THUR","FRI"}; 
					do {
						System.out.println("Input day of the week that lecture of new course occurs:");
						dayNo = scan.nextInt();
						if(dayNo<1 || dayNo>5) {
							System.out.println("Please insert a positive integer from 1 to 5.");
						}
					}while(dayNo<1 || dayNo>5);
					newClassDay = listOfDays[dayNo-1];
					System.out.println("New Course Lecture Day Input: "+newClassDay);
					System.out.println("============= Frequency of Class ==============\r\n" + 
							   "|1. Weekly   |2. Odd Weeks   |3. Even Weeks   |\r\n" + 
							   "===============================================\r\n");
					String [] listOfWeeks = {"EVERY", "ODD", "EVEN"}; 
					do {
						System.out.println("Does the lecture occur weekly? If not, does it occur on even or odd weeks?");
						weekNo = scan.nextInt();
						if(weekNo<1 || weekNo>3) {
							System.out.println("Please insert a positive integer from 1 to 3.");
						}
					}while(weekNo<1 || weekNo>3);
					newClassWeek = listOfWeeks[weekNo-1];
					System.out.println("New Course Lecture Week Input: "+newClassWeek);
					do {
						do {	// HANDLING START TIME
						System.out.println("Input the time that lecture commeneces (in 24hr format - eg.8am = 0800, 3.30pm = 1530 :");
						startTime = scan.nextInt();
						if(((startTime%100)>=60) || (startTime>2400) || (startTime<0)) {
							if(startTime<0) {
								System.out.println("Time input cannot be negative.");
							}
							else if(startTime<10) {
								System.out.println("There is no 000" + startTime + " hours.");
							}
							else if(startTime<100) {
								System.out.println("There is no 00" + startTime + " hours.");
							}
							else if(startTime<1000) {
								System.out.println("There is no 0" + startTime + " hours.");
							}
							else {
								System.out.println("There is no " + startTime + " hours.");
							}
							System.out.println("This time format is incorrect. ");
					}
					}while(((startTime%100)>=60) || (startTime>2400) || (startTime<0));
					if(startTime==2400 || startTime==0) {
						startTime = 0;
						System.out.println("Lecture starting time: 000"+startTime+" hours");
					}
					else if(startTime<10) {
						System.out.println("Lecture starting time: 000"+startTime+" hours");
					}
					else if(startTime<100) {
						System.out.println("Lecture starting time: 00"+startTime+" hours");
					}
					else if(startTime<1000) {
						System.out.println("Lecture starting time: 0"+startTime+" hours");
					}
					else {
						System.out.println("Lecture starting time: "+startTime+" hours");
					}
					do {	// HANDLING END TIME
						System.out.println("Input the time lecture ends in 24hrs format (Please ensure that this time is later than the time the lecture starts):");
						endTime = scan.nextInt();
						if(((endTime%100)>=60) || (endTime>2400) || (endTime<0)) {
							if(endTime<0) {
								System.out.println("Time input cannot be negative.");
							}
							else if(endTime<10) {
								System.out.println("There is no 000" + endTime + " hours.");
							}
							else if(endTime<100) {
								System.out.println("There is no 00" + endTime + " hours.");
							}
							else if(endTime<1000) {
								System.out.println("There is no 0" + endTime + " hours.");
							}
							else {
								System.out.println("There is no " + endTime + " hours.");
							}
							System.out.println("This time format is incorrect. ");
					}
					}while(((endTime%100)>=60) || (endTime>2400) || (endTime<0));
					if(endTime==2400 || endTime==0) {
						endTime = 0;
						System.out.println("Lecture ending time: 000"+endTime+" hours");
					}
					else if(endTime<10) {
						System.out.println("Lecture ending time: 000"+endTime+" hours");
					}
					else if(endTime<100) {
						System.out.println("Lecture ending time: 00"+endTime+" hours");
					}
					else if(endTime<1000) {
						System.out.println("Lecture ending time: 0"+endTime+" hours");
					}
					else {
						System.out.println("Lecture ending time: "+endTime+" hours");
					}
					
					if (startTime>=endTime) {	// COMPARING START TIME & END TIME
						if((endTime == 0) && (startTime!=0)) {
							System.out.println("Lecture timing: " + startTime +" - 000"+ endTime);
						}
						else {
							System.out.println("Lecture ending time should be later than lecture starting time. Lecture cannot end beyond 0000 hours");
							System.out.println("Please input lecture start timing and end timing again.");
						}
					}
					else {
						newClassTiming[0] = startTime;
						newClassTiming[1] = endTime;
					}
					}while(((startTime>endTime) && (endTime!=0)) || (startTime==endTime));
					// createCourse(newCourseCode, newCourseName, newSchool, newIndexNumber, newClassVacancy,newLessonType, newClassVenue, newClassDay, newClassWeek, newClassTiming, newAcadUnits); 
					break;
				case 4: // Update Course Code
					String currentCourseCode, updatedCourseCode;
					System.out.print("Input current course code of course:");
					currentCourseCode = scan.nextLine();
					// IS THERE CHECK FOR STRING INPUT? Remove whitespace? 
					System.out.print("Input updated course code of course:");
					updatedCourseCode = scan.nextLine();
					// IS THERE CHECK FOR STRING INPUT? Remove whitespace? 
					// updateCourseCode(currentCourseCode,updatedCourseCode);
					break;
				case 5: // Update Course School
					String courseCode, updatedSchool;
					int updatedSchoolNo;
					System.out.print("Input course code you wish to update:");
					courseCode = scan.nextLine();
					// IS THERE CHECK FOR STRING INPUT? Remove whitespace? 
					System.out.print("Input updated school of course:");
					System.out.println("============= Schools ==============\r\n" + 
							   "|1. NBS          |10. SSS          |\r\n" + 
							   "|2. CBE          |11. WKWSCI       |\r\n" +
							   "|3. CEE          |12. SBS          |\r\n" +
							   "|4. SCSE         |13. SPMS         |\r\n" + 
							   "|5. EEE          |14. ASE          |\r\n" + 
							   "|6. MSE          |15. LKCSoM       |\r\n" + 
							   "|7. MAE          |16. NIE          |\r\n" + 
							   "|8. ADM          |17. RSIS         |\r\n" + 
							   "|9. SOH                            |\r\n" +
							   "====================================\r\n");
					String [] listOfSchools2 = {"NBS", "CBE", "CEE","SCSE","EEE","MSE","MAE","ADM","SOH","SSS","WKWSCI","SBS","SPMS","ASE","LKCSoM","NIE","RSIS"}; 
					do {
						System.out.println("Input updated school of course(1-17):");
						updatedSchoolNo = scan.nextInt();
						if(updatedSchoolNo<1 || updatedSchoolNo>17) {
							System.out.println("Please insert a positive integer from 1 to 17.");
						}
					}while(updatedSchoolNo<1 || updatedSchoolNo>17);
					updatedSchool = listOfSchools2[updatedSchoolNo-1];
					// updateCourseSchool(courseCode,updatedSchool);
					break;
				case 6: // Update Course Index Number
					int currentIndexNumber, updatedIndexNumber;
					do {
						System.out.print("Input index number of course to be changed:");
						currentIndexNumber = scan.nextInt();
						if(currentIndexNumber<=0) {
							System.out.println("Please insert a positive value");
						}
					}while(currentIndexNumber<=0);
					do {
						System.out.print("Input updated index number of course:");
						updatedIndexNumber = scan.nextInt();
						if(updatedIndexNumber<=0) {
							System.out.println("Please insert a positive value");
						}
					}while(updatedIndexNumber<=0);
					// updateCourseIndexNumber(currentIndexNumber,updatedIndexNumber);
					break;
				case 7: // Update Index Number Vacancy
					int indexNumber, updatedVacancyNumber;
					do {
						System.out.print("Input index number of course to be changed:");
						indexNumber = scan.nextInt();
						if(indexNumber<=0) {
							System.out.println("Please insert a positive value");
						}
					}while(indexNumber<=0);
					do {
						System.out.print("Input updated vacancy number of course:");
						updatedVacancyNumber = scan.nextInt();
						if(updatedVacancyNumber<0) {
							System.out.println("Please insert a positive value");
						}
					}while(updatedVacancyNumber<0);
					// updateCourseIndexNumber(currentIndexNumber,updatedIndexNumber);
					break;
				case 8: // Check Class Vacancies
					int indexNumberTemp1;
					do {
						System.out.print("Input index number to check class vacancy:");
						indexNumberTemp1 = scan.nextInt();
						if(indexNumberTemp1<=0) {
							System.out.println("Please insert a positive value");
						}
					}while(indexNumberTemp1<=0);
					// checkVacancies(indexNumberTemp1); 
					break;
				case 9: // Print Student List by Index Number
					int indexNumberTemp2;
					do {
						System.out.print("Input index number of course to print student list:");
						indexNumberTemp2 = scan.nextInt();
						if(indexNumberTemp2<=0) {
							System.out.println("Please insert a positive value");
						}
					}while(indexNumberTemp2<=0);
					// printStudListByIndex(indexNumberTemp2); 
					break;
				case 10: // Print Student List by Course
					String courseCodeTemp;
					System.out.print("Input course code to print student list:");
					courseCodeTemp = scan.nextLine();
					// printStudListByCourse(courseCodeTemp);
					break;
				case 11: // Exit
					// Call method to (re)write files
					System.out.println("You have logged out.");
					break;
				default:
					System.out.println("Please insert a positive integer from 1-11");
			}
		}while(inputChoice!=11);
		
	}
	
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
			return;
		}
		//create student
		StudentRecords studentRecords = new StudentRecords();
		Student newStudent = new Student(userName, pwd, name , gender , nationality , false, matricNo,
				email, studentRecords);
		//send parameters to unidatabase
		addToStudents(newStudent);
		//list all students
		displayAllStudents();
	}
	
	public void  updateCourseCode(String currentCourseCode, String updatedCourseCode) {
		//verifications
		if (verifyCourse(currentCourseCode)==false) {
			System.out.println("Course code "+ currentCourseCode+" does not exist");
			return;
		}
		if (verifyCourse(updatedCourseCode)==true) {
			System.out.println("Course code "+updatedCourseCode+" already exists");
			return;
		}
		//send parameters to unidatabase
		updateCourseCode(currentCourseCode,updatedCourseCode);
	}
	
	public void updateCourseSchool(String courseCode, String updatedSchool) {
		//verifications
		if (verifyCourse(courseCode)==false) {
			System.out.println("Course code "+courseCode+" does not exist");
			return;
		}
		//send parameters to unidatabase
		updateCourseSchool(courseCode, updatedSchool);

	}
	
	public void updateCourseIndexNumber(int currentIndexNumber, int updatedIndexNumber) {
		//verifications
		if (verifyClassIndex(currentIndexNumber)==false) {
			System.out.println("Course index "+ currentIndexNumber +" does not exist");
			return;
		}
		if (verifyClassIndex(updatedIndexNumber)==true) {
			System.out.println("Course index "+updatedIndexNumber+" already exists");
			return;
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
			return;
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
			return;
		}
		if (verifyClassIndex(indexNum)==true) {
			System.out.println("Course index "+indexNum+" already exists");
			return;
		}
		if (verifyLessonClash(classVenue,classDay,classTime)==true) {
			System.out.println("There is a clash with an existing lesson at "+ classVenue +" on "+classDay+" from "
					+ classTime[0] + " to " + classTime[1]);
			return;
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
