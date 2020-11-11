import java.util.*;
public class StudentStars extends STARS { //student page
	
	Scanner scan = new Scanner(System.in);
  
	public static void run (Student studentLoggedIn)
	{
		System.out.println("================ STARS Menu ================\r\n" + 
				   "|1. Add Course                             |\r\n" + 
				   "|2. Drop Course                            |\r\n" + 
				   "|3. Check Courses Registered               |\r\n" +
				   "|4. Check Vacancies Available              |\r\n" + 
				   "|5. Change Index Number of Course          |\r\n" + 
				   "|6. Swop Index Number with Another Student |\r\n" + 
				   "|7. Log Out                                |\r\n" + 
				   "============================================\r\n");
		int inputChoice;
		do {
			System.out.print ("\nWhat do you wish to do?");
			inputChoice = scan.nextInt();
			switch(inputChoice) {
				case 1: // Add Course
					int indexNumberTemp;
					do {
						System.out.print("Input the index number of the course you would like to add:");
						indexNumberTemp = scan.nextInt();
						if(indexNumberTemp <= 0) {
							System.out.println("Please insert a positive integer");
						}
					}while(indexNumberTemp <= 0);
						if (verifyClassIndex(indexNumberTemp) == false) {
							System.out.println("This index number does not exist.");
						}
						else {
							//addCourse(indexNumberTemp);
							System.out.println("Your course has been added!");
						}	
					break;
				case 2: // Drop Course
					int indexNumberTemp2;
					do {
						System.out.print("Input the index number of the course you would like to drop:");
						indexNumberTemp2 = scan.nextInt();
						if(indexNumberTemp2 <= 0) {
							System.out.println("Please insert a positive integer");
						}
					}while(indexNumberTemp2 <= 0);
						if (verifyClassIndex(indexNumberTemp2) == false) {
							System.out.println("This index number does not exist.");
						}
						else {
							//dropCourse(indexNumberTemp2);
							System.out.println("Your course has been dropped!");
						}	
					break;
				case 3: // Check Courses Registered
					//printCourses(studentLoggedIn);
					break;
				case 4: // Check Vacancies Available
					int indexNumberTemp3;
					do {
						System.out.print("Input index number to check class vacancy:");
						indexNumberTemp3 = scan.nextInt();
						if(indexNumberTemp3<=0) {
							System.out.println("Please insert a positive value");
						}
					}while(indexNumberTemp3<=0);
					//checkVacancies(indexNumberTemp3);
					break;
				case 5: // Change Index Number of Course
					int indexNumberTemp4,indexNumberTemp5;
					do {
						System.out.print("Input your index number you wish to change:");
						indexNumberTemp4 = scan.nextInt();
						if(indexNumberTemp4 <= 0) {
							System.out.println("Please insert a positive integer");
						}
					}while(indexNumberTemp4 <= 0);
					do {
						System.out.print("Input your new index number:");
						indexNumberTemp5 = scan.nextInt();
						if(indexNumberTemp5 <= 0) {
							System.out.println("Please insert a positive integer");
						}
					}while(indexNumberTemp5 <= 0);
					//changeIndex(indexNumberTemp4, indexNumberTemp5);
					break;
				case 6: // Swap Index Number with Another Student
					int indexNumberTemp6,peerIndexNumberTemp;
					String peerUserName, peerPassword;
					do {
						System.out.print("Input your index number you wish to change:");
						indexNumberTemp6 = scan.nextInt();
						if(indexNumberTemp6<=0) {
							System.out.println("Please insert a positive value");
						}
					}while(indexNumberTemp6<=0);
					System.out.print("Input your peer's username:");
					peerUserName = scan.nextLine();
					// IS THERE CHECK FOR STRING INPUT? Remove whitespace?
					System.out.print("Input your peer's username:");
					peerPassword = scan.nextLine();
					// IS THERE CHECK FOR STRING INPUT? Remove whitespace?
					do {
						System.out.print("Input your index number you wish to change:");
						indexNumberTemp6 = scan.nextInt();
						if(indexNumberTemp6<=0) {
							System.out.println("Please insert a positive value");
						}
					}while(indexNumberTemp6<=0);
					//swopIndex(indexNumberTemp6, peerUserName, peerPassword, peerIndexNumberTemp);
					break;
				case 7: // Exit
					// Call method to (re)write files
					System.out.println("You have logged out.");
					break;
				default:
					System.out.println("Please insert a positive integer from 1-7");
			}
		}while(inputChoice != 7);

	}
	
	public void addCourse(Student studentLoggedIn,int addIndexNumber) {
		//verification
		if (verifyClassIndex(addIndexNumber)==false) {
			System.out.println("Course index "+ addIndexNumber +" does not exist");
			return;
		}
		//check if the course index has been registered by the student
		StudentRecords studRec=studentLoggedIn.getstudentRecords();
		ArrayList<ClassIndex> coursesReg = studRec.getCoursesRegistered();
		int coursesRegSize = coursesReg.size();
		for(int i;i<coursesRegSize;i++) {
			if(coursesReg.get(i).getIndexNum()==addIndexNumber);{
			System.out.println("Course index "+ addIndexNumber +" has already been added");
			return;
			}	
		}
		//check if student is already in the waitlist
		ClassIndex classIndex=findClassIndex(addIndexNumber);
		if(classIndex.getWaitList().contains(studentLoggedIn)){
			System.out.println("You are already in the waitlist for course index "+ addIndexNumber );
			return;
		}
		//verify timetable clash
		if(verifyTimeTableClash == true){
			System.out.println("There is a timetable clash with course index "+ addIndexNumber );
			return;
		}
		//register student into course
		addCourseStudent(studentLoggedIn, classIndex);
		if(classIndex.getClassVacancy()==0){
			System.out.println("There are no vacanies at the moment. You have been added into the waitlist for course index "+ addIndexNumber );
		}
		else{
			System.out.println("Your course has been added!");
		}
	}
	
	public void dropCourse(Student studentLoggedIn,int dropIndexNumber) {
		//verification
		if (verifyClassIndex(addIndexNumber)==false) {
			System.out.println("Course index "+ dropIndexNumber +" does not exist");
			return;
		}
		//check if the course index has been registered by the student
		StudentRecords studRec=studentLoggedIn.getstudentRecords();
		ArrayList<ClassIndex> coursesReg = studRec.getCoursesRegistered();
		int coursesRegSize = coursesReg.size();
		ClassIndex classIndex=findClassIndex(dropIndexNumber);
		for(int i;i<coursesRegSize;i++) {
			if(coursesReg.get(i).getIndexNum()==dropIndexNumber){
			removeCourseStudent(studentLoggedIn,classIndex);
			System.out.println("Course index "+ dropIndexNumber +" has been dropped");
			return;
			}
		}
		//possible to drop course while in waitlist?
		System.out.println("You are not registered to course index "+ dropIndexNumber);
	}
	
	public void printCourses(Student studentLoggedIn) { // student id stored or student name stored in student Arraylist?
		
		System.out.println("Enter index of student:"); //user input unique identity (id?) of student that u want to print out
		Integer studentId = scan.nextInt();
		for (int i =0; i < Student.size(); i++) {    //find student in the arraylist
			if (studentId == Student.get(i))
				// print courses of specific student
		}
		
		// or print directly w/o finding student id
		System.out.println("Printing courses registered..."); 
		System.out.println(Course.get());
		
		
	}
	public void changeIndex(int oldIndexNumber, int newIndexNumber) { // input second student id
		System.out.println("Enter index of second student:");
		Integer studentId = scan.nextInt();
		for (int i =0; i < Student.size(); i++) {    //find student in the arraylist
			if (studentId == Student.get(i))
				// invoke swopClassIndex() in unidatabase?
		}
		
		
	}

}
