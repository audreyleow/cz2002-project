import java.util.ArrayList;
import java.util.Scanner;

public class StudentSTARS extends STARS {
	
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
			Scanner scan = new Scanner(System.in);
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
							if (UniDataBase.verifyClassIndex(indexNumberTemp) == false) {
								System.out.println("This index number does not exist.");
							}
							else {
								addCourse(studentLoggedIn,indexNumberTemp);
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
							if (UniDataBase.verifyClassIndex(indexNumberTemp2) == false) {
								System.out.println("This index number does not exist.");
							}
							else {
								dropCourse(studentLoggedIn,indexNumberTemp2);
							}	
						break;
					case 3: // Check Courses Registered
						printCourses(studentLoggedIn);
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
						checkVacancies(indexNumberTemp3);
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
						changeIndex(studentLoggedIn,indexNumberTemp4, indexNumberTemp5);
						break;
					case 6: // Swap Index Number with Another Student
						int indexNumberTemp6,peerIndexNumberTemp;
						String peerUserName, peerPassword,peerHashedPassword;
						do {
							System.out.print("Input your index number you wish to change:");
							indexNumberTemp6 = scan.nextInt();
							if(indexNumberTemp6<=0) {
								System.out.println("Please insert a positive value");
							}
						}while(indexNumberTemp6<=0);
						scan.nextLine();
						System.out.print("Input your peer's username:");
						peerUserName = scan.nextLine();
						peerUserName = peerUserName.trim();									// Remove any whitespace at both ends of String
						peerUserName = peerUserName.replaceAll("\\s+","");					// Remove any whitespace in String
						System.out.print("Input your peer's password:");
						peerPassword = scan.nextLine();
						peerPassword = peerPassword.trim();									// Remove any whitespace at both ends of String
						peerPassword = peerPassword.replaceAll("\\s+","");					// Remove any whitespace in String
						peerHashedPassword = HashPassword.generateHash(peerPassword);
						do {
							System.out.print("Input your peer's index number you wish to change to:");
							peerIndexNumberTemp = scan.nextInt();
							if(peerIndexNumberTemp<=0) {
								System.out.println("Please insert a positive value");
							}
						}while(peerIndexNumberTemp<=0);
						swopIndex(studentLoggedIn,indexNumberTemp6, peerUserName, peerHashedPassword, peerIndexNumberTemp);
						break;
					case 7: // Exit
						UniDataBase.saveAllFiles();
						System.out.println("You have logged out.");
						break;
					default:
						System.out.println("Please insert a positive integer from 1-7");
				}
			}while(inputChoice != 7);
			
		}	
	
		public static void addCourse(Student studentLoggedIn,int addIndexNumber) {
			//verification
			if (UniDataBase.verifyClassIndex(addIndexNumber)==false) {
				System.out.println("Course index "+ addIndexNumber +" does not exist");
				return;
			}
			//check if the course index has been registered by the student
			StudentRecords studRec=studentLoggedIn.getStudentRecords();
			ArrayList<ClassIndex> coursesReg = studRec.getCoursesRegistered();
			int coursesRegSize = coursesReg.size();
			for(int i=0;i<coursesRegSize;i++) {
				if(coursesReg.get(i).getIndexNum()==addIndexNumber){
				System.out.println("Course index "+ addIndexNumber +" has already been added");
				return;
				}	
			}
			//check if student is already in the waitlist
			ClassIndex classIndex=UniDataBase.findClassIndex(addIndexNumber);
			if(classIndex.getWaitList().contains(studentLoggedIn)){
				System.out.println("You are already in the waitlist for course index "+ addIndexNumber );
				return;
			}
			//verify timetable clash
			if(UniDataBase.verifyTimetableClash(studentLoggedIn,addIndexNumber) == true){
				System.out.println("There is a timetable clash with course index "+ addIndexNumber );
				return;
			}
			//verify AcadUnitsRegistered
			int currentAUReg=studRec.getAcadUnitsRegistered();
			String courseCode = classIndex.getCourseCode();
			Course addCourse = UniDataBase.findCourseByCode(courseCode);
			int addAU= addCourse.getAcadUnits();

			if(currentAUReg+addAU>21){
				System.out.println("You cannot exceed 21 AUs.");
				return;
			}
			//register student into course
			if(classIndex.getClassVacancy()==0){
				System.out.println("There are no vacanies at the moment. You have been added into the waitlist for course index "+ addIndexNumber );
			}
			else{
				UniDataBase.addCourseStudent(studentLoggedIn, classIndex);
				System.out.println("Your course has been added!");
			}
		}
		
		public static void dropCourse(Student studentLoggedIn,int dropIndexNumber) {
			//verification
			if (UniDataBase.verifyClassIndex(dropIndexNumber)==false) {
				System.out.println("Course index "+ dropIndexNumber +" does not exist");
				return;
			}
			//check if the course index has been registered by the student
			StudentRecords studRec=studentLoggedIn.getStudentRecords();
			ArrayList<ClassIndex> coursesReg = studRec.getCoursesRegistered();
			int coursesRegSize = coursesReg.size();
			ClassIndex classIndex=UniDataBase.findClassIndex(dropIndexNumber);
			for(int i= 0;i<coursesRegSize;i++) {
				if(coursesReg.get(i).getIndexNum()==dropIndexNumber){
				UniDataBase.removeCourseStudent(studentLoggedIn,classIndex);
				System.out.println("Course index "+ dropIndexNumber +" has been dropped");
				return;
				}
			}
			//possible to drop course while in waitlist?
			System.out.println("You are not registered to course index "+ dropIndexNumber);
		}
		
		public static void printCourses(Student studentLoggedIn) {
			System.out.println("Printing courses registered...");
			StudentRecords studRec=studentLoggedIn.getStudentRecords();
			ArrayList<ClassIndex> coursesReg = studRec.getCoursesRegistered();
			int coursesRegSize = coursesReg.size();
			String courseCode,courseName;
			int indexNum;
			System.out.println("Courses registered... :");
			System.out.println(String.format("%-11s%-10s%-30s","Course Code","Index No.","Course Name")); 
			System.out.println("-------------------------------");
			for(int i=0;i<coursesRegSize;i++) {
				courseCode = coursesReg.get(i).getCourseCode(); 
				courseName = coursesReg.get(i).getCourseName();
				indexNum = coursesReg.get(i).getIndexNum();
				//print courses registered
				System.out.println((i+1)+ ":"+String.format("%-8s%-10s%-30s", courseCode, indexNum, courseName));
				}
		// print courses in waitlist
			ArrayList<ClassIndex> waitListCourses = studRec.getStudentWaitList();
			int waitListCoursesSize = waitListCourses.size();
			String wlcourseCode, wlcourseName;
			int wlindexNum;
			System.out.println("Courses on waitlist... :");
			System.out.println(String.format("%-11s%-10s%-30s","Course Code","Index No.","Course Name")); 
			System.out.println("-------------------------------");
			for (int p = 0; p< waitListCoursesSize ; p++) {
				wlcourseCode = waitListCourses.get(p).getCourseCode();
				wlcourseName = waitListCourses.get(p).getCourseName();
				wlindexNum = waitListCourses.get(p).getIndexNum();
				System.out.println((p+1)+ ":"+String.format("%-8s%-10s%-30s", wlcourseCode, wlindexNum, wlcourseName));
			}
		}
		
		public static void changeIndex(Student studentLoggedIn,int oldIndexNumber, int newIndexNumber) {
			//verify indexes exist
			if (UniDataBase.verifyClassIndex(oldIndexNumber)==false) {
				System.out.println("Course index "+ oldIndexNumber +" does not exist");
				return;
			}
			if (UniDataBase.verifyClassIndex(newIndexNumber)==false) {
				System.out.println("Course index "+ newIndexNumber +" does not exist");
				return;
			}
			//verify indexes belong to same course
			ClassIndex ClassIndex1, ClassIndex2;
			ClassIndex1=UniDataBase.findClassIndex(oldIndexNumber);
			ClassIndex2=UniDataBase.findClassIndex(newIndexNumber);
			if(!(ClassIndex1.getCourseCode().equals(ClassIndex2.getCourseCode()))){
				System.out.println("Course index "+ oldIndexNumber +" and course index "+ newIndexNumber +" do not belong to the same course.");
				return;
			}
			//verify indexes are different
			if(oldIndexNumber == newIndexNumber) {
					System.out.println("Invalid input, you cannot put the same indexes.");
					return;
			}
			//verify student has oldindexnumber as registered course
			StudentRecords studRec=studentLoggedIn.getStudentRecords();
			ArrayList<ClassIndex> coursesReg = studRec.getCoursesRegistered();
			int coursesRegSize = coursesReg.size();
			boolean hasIndex=false;
			for(int i=0;i<coursesRegSize;i++) {
				if(coursesReg.get(i).getIndexNum()== oldIndexNumber){
				hasIndex =true;
				}
			}
			if (hasIndex==false) {
				System.out.println("Invalid input, you are not registered to course index " +oldIndexNumber);
				return;
			}
			//check vacancies for newIndexNumber,change if vacancy > 0
			ClassIndex currentClassIndex = UniDataBase.findClassIndex(oldIndexNumber);
			ClassIndex newClassIndex = UniDataBase.findClassIndex(newIndexNumber);
			if (currentClassIndex.getClassVacancy()>0) {
				UniDataBase.changeClassIndex(studentLoggedIn,currentClassIndex,newClassIndex);
				System.out.println("Course index changed from  "+ oldIndexNumber +" to "+ newIndexNumber);
				return;
				}
			System.out.println("There are no vacanies at the moment for course index " + newIndexNumber);
			
		}
		
		public static void swopIndex(Student studentLoggedIn,int userIndexNumber, String peerUserName, String peerPassword, int peerIndexNumber ){
			//verify indexes exist
			if (UniDataBase.verifyClassIndex(userIndexNumber)==false) {
				System.out.println("Course index "+ userIndexNumber +" does not exist");
				return;
			}
			if (UniDataBase.verifyClassIndex(peerIndexNumber)==false) {
				System.out.println("Course index "+ peerIndexNumber +" does not exist");
				return;
			}
			//verify indexes belong to same course
			ClassIndex classIndex1,classIndex2;
			classIndex1=UniDataBase.findClassIndex(userIndexNumber);
			classIndex2=UniDataBase.findClassIndex(peerIndexNumber);
			if(!(classIndex1.getCourseCode().equals(classIndex2.getCourseCode()))){
				System.out.println("Course index "+ userIndexNumber +" and course index "+ peerIndexNumber +" do not belong to the same course.");
				return;
			}
			//verify indexes are different
			if(userIndexNumber == peerIndexNumber) {
				System.out.println("Invalid input, you cannot put the same indexes.");
				return;
			}
			//verify peer's account
			if(UniDataBase.verifyStudentAccount(peerUserName,peerPassword)==false) {
				System.out.println("Invalid account username/password.");
				return;
			}
			//fetch student2 after verification of account
			Student peer = UniDataBase.findStudentByAccount(peerUserName,peerPassword);
			//verify student1 has userIndexNumber as registered course
			StudentRecords studRec=studentLoggedIn.getStudentRecords();
			ArrayList<ClassIndex> coursesReg = studRec.getCoursesRegistered();
			int coursesRegSize = coursesReg.size();
			boolean hasIndex=false;
			for(int i=0;i<coursesRegSize;i++) {
				if(coursesReg.get(i).getIndexNum()== userIndexNumber){
				hasIndex =true;
				}
			}
			if (hasIndex==false) {
				System.out.println("Invalid input, you are not registered to course index " +userIndexNumber);
				return;
			}
			//verify student2 has peerIndexNumber as registered course
			StudentRecords studRec2=peer.getStudentRecords();
			ArrayList<ClassIndex> coursesReg2 = studRec2.getCoursesRegistered();
			int coursesRegSize2 = coursesReg2.size();
			hasIndex=false;
			for(int i=0;i<coursesRegSize2;i++) {
				if(coursesReg2.get(i).getIndexNum()== peerIndexNumber){
				hasIndex =true;
				}
			}
			if (hasIndex==false) {
				System.out.println("Invalid input, your peer is not registered to course index " +peerIndexNumber);
				return;
			}
			//call to swop index
			UniDataBase.swopClassIndex(studentLoggedIn, peer, classIndex1,classIndex2);
			System.out.println("Swop successful.");
		}

}

