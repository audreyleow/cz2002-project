import java.util.ArrayList;
import java.util.Scanner;

public class AdminSTARS extends STARS{
	
	public static void run() 
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
			System.out.print ("What do you wish to do? Input choices from 1-11: ");
			inputChoice = scan.nextInt();
			switch(inputChoice) {
				case 1: // Edit Student Access Period
					int startMonth, startDate, startHour,startMinute;
					int endMonth, endDate, endHour,endMinute;
					do {
						System.out.println("Please input numerical month of starting date of access: ");
						startMonth = scan.nextInt();
						if(startMonth<1 || startMonth>12) {
							System.out.println("Please input a positive integer from 1 to 12.");
						}
					}while(startMonth<1 || startMonth>12);
					if (startMonth==2) {
						do {
							System.out.println("Please input date of starting date of access: ");
							startDate = scan.nextInt();
							if(startDate<1 || startDate>28) {
								System.out.println("Please input a positive integer from 1 to 28.");
							}
						}while(startDate<1 || startDate>28);
					}
					else if ((startMonth == 4) || (startMonth == 6) || (startMonth == 9) || (startMonth == 11)) {
						do {
							System.out.println("Please input numerical date of starting date of access: ");
							startDate = scan.nextInt();
							if(startDate<1 || startDate>30) {
								System.out.println("Please input a positive integer from 1 to 30.");
							}
						}while(startDate<1 || startDate>30);
					}
					else {
						do {
						System.out.println("Please input numerical date of starting date of access: ");
						startDate = scan.nextInt();
						if(startDate<1 || startDate>31) {
							System.out.println("Please input a positive integer from 1 to 31.");
						}
						}while(startDate<1 || startDate>31);
					}
					do {
						System.out.println("Please input hour of starting date of access (in 24hr format): ");
						startHour = scan.nextInt();
						if(startHour<0 || startHour>23) {
							System.out.println("Please input a non-negative integer from 0 to 23.");
						}
					}while(startHour<0 || startHour>23);
					do {
						System.out.println("Please input minute of starting date of access: ");
						startMinute = scan.nextInt();
						if(startMinute<0 || startMinute>59) {
							System.out.println("Please input a non-negative integer from 0 to 59.");
						}
					}while(startMinute<0 || startMinute>59);
					System.out.println("The starting access time is "+startDate+"--"+startMonth+"--2020 "+startHour+":"+startMinute+":00");
					do {
						System.out.println("Please input numerical month of ending date of access: ");
						endMonth = scan.nextInt();
						if(endMonth<1 || endMonth>12) {
							System.out.println("Please input a positive integer from 1 to 12.");
						}
					}while(endMonth<1 || endMonth>12);
					if (endMonth==2) {
						do {
							System.out.println("Please input date of ending date of access: ");
							endDate = scan.nextInt();
							if(endDate<1 || endDate>28) {
								System.out.println("Please input a positive integer from 1 to 28.");
							}
						}while(endDate<1 || endDate>28);
					}
					else if ((endMonth == 4) || (endMonth == 6) || (endMonth == 9) || (endMonth == 11)) {
						do {
							System.out.println("Please input numerical date of ending date of access: ");
							endDate = scan.nextInt();
							if(endDate<1 || endDate>30) {
								System.out.println("Please input a positive integer from 1 to 30.");
							}
						}while(endDate<1 || endDate>30);
					}
					else {
						do {
						System.out.println("Please input numerical date of ending date of access: ");
						endDate = scan.nextInt();
						if(endDate<1 || endDate>31) {
							System.out.println("Please input a positive integer from 1 to 31.");
						}
						}while(endDate<1 || endDate>31);
					}
					do {
						System.out.println("Please input hour of ending date of access (in 24hr format): ");
						endHour = scan.nextInt();
						if(endHour<0 || endHour>23) {
							System.out.println("Please input a non-negative integer from 0 to 23.");
						}
					}while(endHour<0 || endHour>23);
					do {
						System.out.println("Please input minute of ending date of access: ");
						endMinute = scan.nextInt();
						if(endMinute<0 || endMinute>59) {
							System.out.println("Please input a non-negative integer from 0 to 59.");
						}
					}while(endMinute<0 || endMinute>59);
					System.out.println("The ending access time is "+endDate+"--"+endMonth+"--2020 "+endHour+":"+endMinute+":00");
					if(endMonth>startMonth) {				// LATER MONTH
						System.out.println("You are updating the student access period.");
						UniDataBase.setStartAccessDate(startMonth, startDate, startHour, startMinute);
						UniDataBase.setEndAccessDate(endMonth, endDate, endHour, endMinute);
					}
					else if (endMonth==startMonth) {
						if(endDate>startDate) {				// SAME MONTH, LATER DAY
							System.out.println("You are updating the student access period.");
							UniDataBase.setStartAccessDate(startMonth, startDate, startHour, startMinute);
							UniDataBase.setEndAccessDate(endMonth, endDate, endHour, endMinute);
						}
						else if(endDate == startDate){
							if(endHour>startHour) {			// SAME MONTH & DATE, LATER HOUR
								System.out.println("You are updating the student access period.");
								UniDataBase.setStartAccessDate(startMonth, startDate, startHour, startMinute);
								UniDataBase.setEndAccessDate(endMonth, endDate, endHour, endMinute);
							}
							else if(endHour == startHour) {
								if(endMinute>startMinute) {	// SAME MONTH, DATE & HOUR, LATER MINUTE
									System.out.println("You are updating the student access period.");
									UniDataBase.setStartAccessDate(startMonth, startDate, startHour, startMinute);
									UniDataBase.setEndAccessDate(endMonth, endDate, endHour, endMinute);
								}
								else {						// SAME MONTH, DATE & HOUR, EARLIER/SAME MINUTE
									System.out.println("The ending access time must be later than the starting access time. Update failed.");
								}
							}
							else {							// SAME MONTH & DATE, EARLIER HOUR
								System.out.println("The ending access time must be later than the starting access time. Update failed.");
							}
						}
						else {								// SAME MONTH, EARLIER DATE
							System.out.println("The ending access time must be later than the starting access time. Update failed.");
						}
					}
					else {									// EARLIER MONTH
						System.out.println("The ending access time must be later than the starting access time. Update failed.");
					}
					break;
				case 2: // Add A Student
					String newName, newMatricNo, newGender, newNationality,newUserName, newPassword, newEmail;
					int genderChoice;
					scan.nextLine();  // Consume newline left-over
					System.out.print("Input name of new student:");
					newName = scan.nextLine();
					newName = newName.trim();								// Remove any whitespace at both ends of String
					System.out.println("New Name Input: "+newName);
					System.out.print("Input matriculation number of new student:");
					newMatricNo = scan.nextLine();
					newMatricNo = newMatricNo.trim();						// Remove any whitespace at both ends of String
					newMatricNo = newMatricNo.replaceAll("\\s+","");		// Remove any whitespace in String 
					System.out.println("New Matriculation Number Input: "+newMatricNo);
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
					newNationality = newNationality.trim();								// Remove any whitespace at both ends of String
					System.out.println("New Nationality Input: "+newNationality);
					System.out.print("Input username of new student:");
					newUserName = scan.nextLine();
					newUserName = newUserName.trim();									// Remove any whitespace at both ends of String
					newUserName = newUserName.replaceAll("\\s+","");					// Remove any whitespace in String
					System.out.println("New Username Input: "+newUserName);
					newEmail = newUserName+"@e.ntu.edu.sg";
					newPassword = HashPassword.generateHash(newMatricNo);
					// addStudent(newName, newMatricNo, newGender, newNationality, newUserName, newPassword, newEmail);
					break;
				case 3: // Add A Course  
					String newCourseCode, newCourseName, newSchool, newClassVenue, newClassDay, newClassWeek;
					int newIndexNum, newClassVacancy, newAcadUnits, schoolNo, dayNo, weekNo, startTime, endTime;
					int indexNumQuantity, commonLectureDayNo, commonLectureWeekNo, commonLectureStartTime, commonLectureEndTime, lessonFormat, commonLectureIndexNum, commonLectureClassIndexVacancy;
					String newCommonLectureVenue, newCommonLectureDay ,newCommonLectureWeek;
					scan.nextLine();  // Consume newline left-over
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
							System.out.println("Please input a positive integer from 1 to 17.");
						}
					}while(schoolNo<1 || schoolNo>17);
					newSchool = listOfSchools[schoolNo-1];
					System.out.println("New Course School Input: "+newSchool);
					do {
						System.out.print("Input course's academic units:");
						newAcadUnits = scan.nextInt();
						if(newAcadUnits<1 || newAcadUnits>4) {
							System.out.println("Please input a positive value from 1 to 4");
						}
					}while(newAcadUnits<1 || newAcadUnits>4);
					System.out.println("New Course Academic Units Input: "+newAcadUnits);
					// Input common lecture lesson for each classIndex
					String newCourseLectureType = "LECT";
					int[] newCommonLectureTiming = new int[2];  // first is startTime, second is endTime
					System.out.print("Input common lecture class venue of new course:");
					scan.nextLine();  // Consume newline left-over
					newCommonLectureVenue = scan.nextLine();
					newCommonLectureVenue = newCommonLectureVenue.trim();									// Remove any whitespace at both ends of String
					newCommonLectureVenue = newCommonLectureVenue.replaceAll("\\s+","");					// Remove any whitespace in String 
					System.out.println("New Course Common Lecture Venue Input: "+newCommonLectureVenue);
					System.out.println("========== Days of Week ===========\r\n" + 
							   "|1. MON          |4. THUR         |\r\n" + 
							   "|2. TUE          |5. FRI          |\r\n" +
							   "|3. WED                           |\r\n" +
							   "====================================\r\n");
					String [] listOfDays = {"MON", "TUE", "WED","THUR","FRI"}; 
					do {
						System.out.println("Input day of the week that common lecture of new course occurs:");
						commonLectureDayNo = scan.nextInt();
						if(commonLectureDayNo<1 || commonLectureDayNo>5) {
							System.out.println("Please input a positive integer from 1 to 5.");
						}
					}while(commonLectureDayNo<1 || commonLectureDayNo>5);
					newCommonLectureDay = listOfDays[commonLectureDayNo-1];
					System.out.println("New Course Common Lecture Day Input: "+newCommonLectureDay);
					System.out.println("============= Frequency of Class ==============\r\n" + 
							   "|1. Weekly   |2. Odd Weeks   |3. Even Weeks   |\r\n" + 
							   "===============================================\r\n");
					String [] listOfWeeks = {"EVERY", "ODD", "EVEN"}; 
					do {
						System.out.println("Does the lecture occur weekly? If not, does it occur on even or odd weeks?");
						commonLectureWeekNo = scan.nextInt();
						if(commonLectureWeekNo<1 || commonLectureWeekNo>3) {
							System.out.println("Please input a positive integer from 1 to 3.");
						}
					}while(commonLectureWeekNo<1 || commonLectureWeekNo>3);
					newCommonLectureWeek = listOfWeeks[commonLectureWeekNo-1];
					System.out.println("New Course Lecture Week Input: "+newCommonLectureWeek);
					do {
						do {	// HANDLING START TIME
							System.out.println("Input the time that lecture commeneces (in 24hr format - eg.8am = 0800, 3.30pm = 1530 :");
							commonLectureStartTime = scan.nextInt();
							if(((commonLectureStartTime%100)>=60) || (commonLectureStartTime>=2400) || (commonLectureStartTime<0)) {
								if(commonLectureStartTime<0) {
									System.out.println("Time input cannot be negative.");
								}
								else if(commonLectureStartTime<10) {
									System.out.println("There is no 000" + commonLectureStartTime + " hours.");
								}
								else if(commonLectureStartTime<100) {
									System.out.println("There is no 00" + commonLectureStartTime + " hours.");
								}
								else if(commonLectureStartTime<1000) {
									System.out.println("There is no 0" + commonLectureStartTime + " hours.");
								}
								else {
									System.out.println("There is no " + commonLectureStartTime + " hours.");
								}
								System.out.println("This time format is incorrect. ");
							}
						}while(((commonLectureStartTime%100)>=60) || (commonLectureStartTime>=2400) || (commonLectureStartTime<0));
						if(commonLectureStartTime==0) {
							System.out.println("Lecture starting time: 000"+commonLectureStartTime+" hours");
						}
						else if(commonLectureStartTime<10) {
							System.out.println("Lecture starting time: 000"+commonLectureStartTime+" hours");
						}
						else if(commonLectureStartTime<100) {
							System.out.println("Lecture starting time: 00"+commonLectureStartTime+" hours");
						}
						else if(commonLectureStartTime<1000) {
							System.out.println("Lecture starting time: 0"+commonLectureStartTime+" hours");
						}
						else {
							System.out.println("Lecture starting time: "+commonLectureStartTime+" hours");
						}
						do {	// HANDLING END TIME
							System.out.println("Input the time lecture ends in 24hrs format (Please ensure that this time is later than the time the lecture starts):");
							commonLectureEndTime = scan.nextInt();
							if(((commonLectureEndTime%100)>=60) || (commonLectureEndTime>=2400) || (commonLectureEndTime<0)) {
								if(commonLectureEndTime<0) {
									System.out.println("Time input cannot be negative.");
								}
								else if(commonLectureEndTime<10) {
									System.out.println("There is no 000" + commonLectureEndTime + " hours.");
								}
								else if(commonLectureEndTime<100) {
									System.out.println("There is no 00" + commonLectureEndTime + " hours.");
								}
								else if(commonLectureEndTime<1000) {
									System.out.println("There is no 0" + commonLectureEndTime + " hours.");
								}
								else {
									System.out.println("There is no " + commonLectureEndTime + " hours.");
								}
								System.out.println("This time format is incorrect. ");
							}
						}while(((commonLectureEndTime%100)>=60) || (commonLectureEndTime>=2400) || (commonLectureEndTime<0));
						if(commonLectureEndTime==0) {
							System.out.println("Lecture ending time: 000"+commonLectureEndTime+" hours");
						}
						else if(commonLectureEndTime<10) {
							System.out.println("Lecture ending time: 000"+commonLectureEndTime+" hours");
						}
						else if(commonLectureEndTime<100) {
							System.out.println("Lecture ending time: 00"+commonLectureEndTime+" hours");
						}
						else if(commonLectureEndTime<1000) {
							System.out.println("Lecture ending time: 0"+commonLectureEndTime+" hours");
						}
						else {
							System.out.println("Lecture ending time: "+commonLectureEndTime+" hours");
						}
						if (commonLectureStartTime>=commonLectureEndTime) {	// COMPARING START TIME & END TIME
							if((commonLectureEndTime == 0) && (commonLectureStartTime!=0)) {
								System.out.println("Lecture timing: " + commonLectureStartTime +" - 000"+ commonLectureEndTime);
							}
							else {
								System.out.println("Lecture ending time should be later than lecture starting time. Lecture cannot end beyond 0000 hours");
								System.out.println("Please input lecture start timing and end timing again.");
							}
						}
						else {
							newCommonLectureTiming[0] = commonLectureStartTime;
							newCommonLectureTiming[1] = commonLectureEndTime;
						}
					}while(((commonLectureStartTime>commonLectureEndTime) && (commonLectureEndTime!=0)) || (commonLectureStartTime==commonLectureEndTime));
					System.out.println("======== Lesson Format ========\r\n" + 
							   "|1. Lecture only               |\r\n" + 
							   "|2. Lecture & Tutorial only    |\r\n" + 
							   "|3. Lecture, Tutorial & Lab    |\r\n" +
							   "================================\r\n");
					do {
						System.out.println("Input lesson format for this course: ");
						lessonFormat = scan.nextInt();
						if(lessonFormat<1 || lessonFormat>3) {
							System.out.println("Please input a positive integer from 1 to 3.");
						}
					}while(lessonFormat<1 || lessonFormat>3);
					if(lessonFormat == 1) {				// Lecture only
						do {
							System.out.print("Input index number of the new course:");
							commonLectureIndexNum = scan.nextInt();
							if(commonLectureIndexNum <= 0) {
								System.out.println("Please input a positive integer.");
							}
						}while(commonLectureIndexNum <= 0);
						System.out.println("New Course Index Number Input: "+commonLectureIndexNum);
						do {
							System.out.print("Input lecture class vacancy of new course:");
							commonLectureClassIndexVacancy = scan.nextInt();
							if(commonLectureClassIndexVacancy <= 0) {
								System.out.println("Please input a positive integer.");
							}
						}while(commonLectureClassIndexVacancy <= 0);
						System.out.println("New Course Lecture Class Vacancy Input: "+commonLectureClassIndexVacancy);
						createCourse(newCourseCode, newCourseName, newSchool, commonLectureIndexNum, commonLectureClassIndexVacancy,newCourseLectureType, newCommonLectureVenue, newCommonLectureDay,newCommonLectureTiming, newCommonLectureWeek , newAcadUnits); 
					}
					else if(lessonFormat == 2) {		// Lecture & Tutorial
						do {
							System.out.println("How many index numbers will this course have?");
							indexNumQuantity = scan.nextInt();
							if(indexNumQuantity<1) {
								System.out.println("Please input a positive number.");
							}
						}while(indexNumQuantity<1);
						Lesson tempLectureLesson = createLessonIndex(newCourseLectureType, newCommonLectureVenue, newCommonLectureDay, newCommonLectureTiming, newCommonLectureWeek);
						ArrayList<ClassIndex> tempIndexNumList = new ArrayList<ClassIndex>();
						for(int i = 0; i < indexNumQuantity; i++) {
							int tempIndexNum, tempClassVacancy,tempClassDayNo,tempClassWeekNo, tempClassStartTime, tempClassEndTime;
							String tempLessonType = "TUT";
							String tempClassVenue,tempClassDay, tempClassWeek;
							int[] tempTutorialTiming = new int[2];  // first is startTime, second is endTime
							Lesson tempLesson;
							ClassIndex tempClassIndex;
							ArrayList<Lesson> tempLessonsList = new ArrayList<Lesson>();
							tempLessonsList.add(tempLectureLesson); // Adds compulsory lecture Lesson to temp lessonsList of each ClassIndex
							do {
								System.out.print("Input #"+(i+1)+" index number of the new course:");
								tempIndexNum = scan.nextInt();
								if(tempIndexNum <= 0) {
									System.out.println("Please input a positive integer.");
								}
							}while(tempIndexNum <= 0);
							System.out.println("New Course #"+(i+1)+" Index Number Input: "+tempIndexNum);
							do {
								System.out.print("Input tutorial class vacancy of #"+(i+1)+" index number of the new course:");
								tempClassVacancy = scan.nextInt();
								if(tempClassVacancy <= 0) {
									System.out.println("Please input a positive integer.");
								}
							}while(tempClassVacancy <= 0);
							System.out.print("Input tutorial class venue of new course:");
							scan.nextLine();  // Consume newline left-over
							tempClassVenue = scan.nextLine();
							tempClassVenue = tempClassVenue.trim();									// Remove any whitespace at both ends of String
							tempClassVenue = tempClassVenue.replaceAll("\\s+","");					// Remove any whitespace in String 
							System.out.println("New Course Tutorial Venue Input: "+tempClassVenue);
							System.out.println("========== Days of Week ===========\r\n" + 
									   "|1. MON          |4. THUR         |\r\n" + 
									   "|2. TUE          |5. FRI          |\r\n" +
									   "|3. WED                           |\r\n" +
									   "====================================\r\n");
							do {
								System.out.println("Input day of the week that tutorial of new course occurs:");
								tempClassDayNo = scan.nextInt();
								if(tempClassDayNo<1 || tempClassDayNo>5) {
									System.out.println("Please input a positive integer from 1 to 5.");
								}
							}while(tempClassDayNo<1 || tempClassDayNo>5);
							tempClassDay = listOfDays[tempClassDayNo-1];
							System.out.println("New Course Tutorial Day Input: "+tempClassDay);
							System.out.println("============= Frequency of Class ==============\r\n" + 
									   "|1. Weekly   |2. Odd Weeks   |3. Even Weeks   |\r\n" + 
									   "===============================================\r\n");
							do {
								System.out.println("Does the lecture occur weekly? If not, does it occur on even or odd weeks?");
								tempClassWeekNo = scan.nextInt();
								if(tempClassWeekNo<1 || tempClassWeekNo>3) {
									System.out.println("Please input a positive integer from 1 to 3.");
								}
							}while(tempClassWeekNo<1 || tempClassWeekNo>3);
							tempClassWeek = listOfWeeks[tempClassWeekNo-1];
							System.out.println("New Course Tutorial Week Input: "+tempClassWeek);
							do {
								do {	// HANDLING TUTORIAL START TIME
									System.out.println("Input the time that tutorial commeneces (in 24hr format - eg.8am = 0800, 3.30pm = 1530 :");
									tempClassStartTime = scan.nextInt();
									if(((tempClassStartTime%100)>=60) || (tempClassStartTime>=2400) || (tempClassStartTime<0)) {
										if(tempClassStartTime<0) {
											System.out.println("Time input cannot be negative.");
										}
										else if(tempClassStartTime<10) {
											System.out.println("There is no 000" + tempClassStartTime + " hours.");
										}
										else if(tempClassStartTime<100) {
											System.out.println("There is no 00" + tempClassStartTime + " hours.");
										}
										else if(tempClassStartTime<1000) {
											System.out.println("There is no 0" + tempClassStartTime + " hours.");
										}
										else {
											System.out.println("There is no " + tempClassStartTime + " hours.");
										}
										System.out.println("This time format is incorrect. ");
									}
								}while(((tempClassStartTime%100)>=60) || (tempClassStartTime>=2400) || (tempClassStartTime<0));
								if(tempClassStartTime==0) {
									System.out.println("Tutorial starting time: 000"+tempClassStartTime+" hours");
								}
								else if(tempClassStartTime<10) {
									System.out.println("Tutorial starting time: 000"+tempClassStartTime+" hours");
								}
								else if(tempClassStartTime<100) {
									System.out.println("Tutorial starting time: 00"+tempClassStartTime+" hours");
								}
								else if(tempClassStartTime<1000) {
									System.out.println("Tutorial starting time: 0"+tempClassStartTime+" hours");
								}
								else {
									System.out.println("Tutorial starting time: "+tempClassStartTime+" hours");
								}
								do {	// HANDLING TUTORIAL END TIME
									System.out.println("Input the time tutorial ends in 24hrs format (Please ensure that this time is later than the time the lecture starts):");
									tempClassEndTime = scan.nextInt();
									if(((tempClassEndTime%100)>=60) || (tempClassEndTime>=2400) || (tempClassEndTime<0)) {
										if(tempClassEndTime<0) {
											System.out.println("Time input cannot be negative.");
										}
										else if(tempClassEndTime<10) {
											System.out.println("There is no 000" + tempClassEndTime + " hours.");
										}
										else if(tempClassEndTime<100) {
											System.out.println("There is no 00" + tempClassEndTime + " hours.");
										}
										else if(tempClassEndTime<1000) {
											System.out.println("There is no 0" + tempClassEndTime + " hours.");
										}
										else {
											System.out.println("There is no " + tempClassEndTime + " hours.");
										}
										System.out.println("This time format is incorrect. ");
									}
								}while(((tempClassEndTime%100)>=60) || (tempClassEndTime>=2400) || (tempClassEndTime<0));
								if(tempClassEndTime==0) {
									System.out.println("Tutorial ending time: 000"+tempClassEndTime+" hours");
								}
								else if(tempClassEndTime<10) {
									System.out.println("Tutorial ending time: 000"+tempClassEndTime+" hours");
								}
								else if(tempClassEndTime<100) {
									System.out.println("Tutorial ending time: 00"+tempClassEndTime+" hours");
								}
								else if(tempClassEndTime<1000) {
									System.out.println("Tutorial ending time: 0"+tempClassEndTime+" hours");
								}
								else {
									System.out.println("Tutorial ending time: "+tempClassEndTime+" hours");
								}
								if (tempClassStartTime>=tempClassEndTime) {	// COMPARING START TIME & END TIME
									if((tempClassEndTime == 0) && (tempClassStartTime!=0)) {
										System.out.println("Tutorial timing: " + tempClassStartTime +" - 000"+ tempClassEndTime);
									}
									else {
										System.out.println("Tutorial ending time should be later than tutorial starting time. Tutorial cannot end beyond 0000 hours");
										System.out.println("Please input tutorial start timing and end timing again.");
									}
								}
								else {
									tempTutorialTiming[0] = tempClassStartTime;
									tempTutorialTiming[1] = tempClassEndTime;
								}
							}while(((tempClassStartTime>tempClassEndTime) && (tempClassEndTime!=0)) || (tempClassStartTime==tempClassEndTime));
							tempLesson = createLessonIndex(tempLessonType, tempClassVenue, tempClassDay, tempTutorialTiming, tempClassWeek);
							tempLessonsList.add(tempLesson);  	// Adds specific tutorial Lesson to temp lessonsList of each ClassIndex
							tempClassIndex = createClassIndex(newCourseName, newCourseCode, tempIndexNum, tempClassVacancy, tempLessonsList);
							tempIndexNumList.add(tempClassIndex);	 // Adds specific ClassIndex(containing a common lecture Lesson & specific tutorial Lesson under a specific index num) to temp indexNumList for each ClassIndex
						}
						createCourse2(newCourseCode, newCourseName, newSchool, tempIndexNumList ,newAcadUnits); 
					}
					else if(lessonFormat == 3) {		// Lecture, Tutorial & Lab
						do {
							System.out.println("How many index numbers will this course have?");
							indexNumQuantity = scan.nextInt();
							if(indexNumQuantity<1) {
								System.out.println("Please input a positive number.");
							}
						}while(indexNumQuantity<1);
						Lesson tempLectureLesson = createLessonIndex(newCourseLectureType, newCommonLectureVenue, newCommonLectureDay, newCommonLectureTiming, newCommonLectureWeek);
						ArrayList<ClassIndex> tempIndexNumList = new ArrayList<ClassIndex>();
						for(int i = 0; i < indexNumQuantity; i++) {
							int tempIndexNum, tempClassVacancy,tempTutDayNo,tempTutWeekNo, tempTutStartTime, tempTutEndTime, tempLabDayNo,tempLabWeekNo, tempLabStartTime, tempLabEndTime;
							String tempTutLessonType = "TUT";
							String tempLabLessonType = "LAB";
							String tempTutVenue,tempTutDay, tempTutWeek, tempLabVenue,tempLabDay, tempLabWeek;
							int[] tempTutTiming = new int[2];  // first is startTime, second is endTime
							int[] tempLabTiming = new int[2];  // first is startTime, second is endTime
							Lesson tempTutLesson, tempLabLesson;
							ClassIndex tempClassIndex;
							ArrayList<Lesson> tempLessonsList = new ArrayList<Lesson>();
							tempLessonsList.add(tempLectureLesson); // Adds compulsory lecture Lesson to temp lessonsList of each ClassIndex
							do {
								System.out.print("Input #"+(i+1)+" index number of the new course:");
								tempIndexNum = scan.nextInt();
								if(tempIndexNum <= 0) {
									System.out.println("Please input a positive integer.");
								}
							}while(tempIndexNum <= 0);
							System.out.println("New Course #"+(i+1)+" Index Number Input: "+tempIndexNum);
							do {
								System.out.print("Input class vacancy of #"+(i+1)+" index number of the new course:");
								tempClassVacancy = scan.nextInt();
								if(tempClassVacancy <= 0) {
									System.out.println("Please input a positive integer.");
								}
							}while(tempClassVacancy <= 0);
							System.out.print("Input tutorial class venue of new course:");
							scan.nextLine();  // Consume newline left-over
							tempTutVenue = scan.nextLine();
							tempTutVenue = tempTutVenue.trim();									// Remove any whitespace at both ends of String
							tempTutVenue = tempTutVenue.replaceAll("\\s+","");					// Remove any whitespace in String 
							System.out.println("New Course Tutorial Venue Input: "+tempTutVenue);
							System.out.println("========== Days of Week ===========\r\n" + 
									   "|1. MON          |4. THUR         |\r\n" + 
									   "|2. TUE          |5. FRI          |\r\n" +
									   "|3. WED                           |\r\n" +
									   "====================================\r\n");
							do {
								System.out.println("Input day of the week that tutorial of new course occurs:");
								tempTutDayNo = scan.nextInt();
								if(tempTutDayNo<1 || tempTutDayNo>5) {
									System.out.println("Please input a positive integer from 1 to 5.");
								}
							}while(tempTutDayNo<1 || tempTutDayNo>5);
							tempTutDay = listOfDays[tempTutDayNo-1];
							System.out.println("New Course Tutorial Day Input: "+tempTutDay);
							System.out.println("============= Frequency of Class ==============\r\n" + 
									   "|1. Weekly   |2. Odd Weeks   |3. Even Weeks   |\r\n" + 
									   "===============================================\r\n");
							do {
								System.out.println("Does the tutorial occur weekly? If not, does it occur on even or odd weeks?");
								tempTutWeekNo = scan.nextInt();
								if(tempTutWeekNo<1 || tempTutWeekNo>3) {
									System.out.println("Please input a positive integer from 1 to 3.");
								}
							}while(tempTutWeekNo<1 || tempTutWeekNo>3);
							tempTutWeek = listOfWeeks[tempTutWeekNo-1];
							System.out.println("New Course Tutorial Week Input: "+tempTutWeek);
							do {
								do {	// HANDLING TUTORIAL START TIME
									System.out.println("Input the time that tutorial commeneces (in 24hr format - eg.8am = 0800, 3.30pm = 1530 :");
									tempTutStartTime = scan.nextInt();
									if(((tempTutStartTime%100)>=60) || (tempTutStartTime>=2400) || (tempTutStartTime<0)) {
										if(tempTutStartTime<0) {
											System.out.println("Time input cannot be negative.");
										}
										else if(tempTutStartTime<10) {
											System.out.println("There is no 000" + tempTutStartTime + " hours.");
										}
										else if(tempTutStartTime<100) {
											System.out.println("There is no 00" + tempTutStartTime + " hours.");
										}
										else if(tempTutStartTime<1000) {
											System.out.println("There is no 0" + tempTutStartTime + " hours.");
										}
										else {
											System.out.println("There is no " + tempTutStartTime + " hours.");
										}
										System.out.println("This time format is incorrect. ");
									}
								}while(((tempTutStartTime%100)>=60) || (tempTutStartTime>=2400) || (tempTutStartTime<0));
								if(tempTutStartTime==0) {
									System.out.println("Tutorial starting time: 000"+tempTutStartTime+" hours");
								}
								else if(tempTutStartTime<10) {
									System.out.println("Tutorial starting time: 000"+tempTutStartTime+" hours");
								}
								else if(tempTutStartTime<100) {
									System.out.println("Tutorial starting time: 00"+tempTutStartTime+" hours");
								}
								else if(tempTutStartTime<1000) {
									System.out.println("Tutorial starting time: 0"+tempTutStartTime+" hours");
								}
								else {
									System.out.println("Tutorial starting time: "+tempTutStartTime+" hours");
								}
								do {	// HANDLING TUTORIAL END TIME
									System.out.println("Input the time tutorial ends in 24hrs format (Please ensure that this time is later than the time the lecture starts):");
									tempTutEndTime = scan.nextInt();
									if(((tempTutEndTime%100)>=60) || (tempTutEndTime>=2400) || (tempTutEndTime<0)) {
										if(tempTutEndTime<0) {
											System.out.println("Time input cannot be negative.");
										}
										else if(tempTutEndTime<10) {
											System.out.println("There is no 000" + tempTutEndTime + " hours.");
										}
										else if(tempTutEndTime<100) {
											System.out.println("There is no 00" + tempTutEndTime + " hours.");
										}
										else if(tempTutEndTime<1000) {
											System.out.println("There is no 0" + tempTutEndTime + " hours.");
										}
										else {
											System.out.println("There is no " + tempTutEndTime + " hours.");
										}
										System.out.println("This time format is incorrect. ");
									}
								}while(((tempTutEndTime%100)>=60) || (tempTutEndTime>=2400) || (tempTutEndTime<0));
								if(tempTutEndTime==0) {
									System.out.println("Tutorial ending time: 000"+tempTutEndTime+" hours");
								}
								else if(tempTutEndTime<10) {
									System.out.println("Tutorial ending time: 000"+tempTutEndTime+" hours");
								}
								else if(tempTutEndTime<100) {
									System.out.println("Tutorial ending time: 00"+tempTutEndTime+" hours");
								}
								else if(tempTutEndTime<1000) {
									System.out.println("Tutorial ending time: 0"+tempTutEndTime+" hours");
								}
								else {
									System.out.println("Tutorial ending time: "+tempTutEndTime+" hours");
								}
								if (tempTutStartTime>=tempTutEndTime) {	// COMPARING START TIME & END TIME
									if((tempTutEndTime == 0) && (tempTutStartTime!=0)) {
										System.out.println("Tutorial timing: " + tempTutStartTime +" - 000"+ tempTutEndTime);
									}
									else {
										System.out.println("Tutorial ending time should be later than tutorial starting time. Tutorial cannot end beyond 0000 hours");
										System.out.println("Please input tutorial start timing and end timing again.");
									}
								}
								else {
									tempTutTiming[0] = tempTutStartTime;
									tempTutTiming[1] = tempTutEndTime;
								}
							}while(((tempTutStartTime>tempTutEndTime) && (tempTutEndTime!=0)) || (tempTutStartTime==tempTutEndTime));
							tempTutLesson = createLessonIndex(tempTutLessonType, tempTutVenue, tempTutDay, tempTutTiming, tempTutWeek);
							tempLessonsList.add(tempTutLesson);  	// Adds specific tutorial Lesson to temp lessonsList of each ClassIndex
							System.out.print("Input lab class venue of new course:");
							scan.nextLine();  // Consume newline left-over
							tempLabVenue = scan.nextLine();
							tempLabVenue = tempLabVenue.trim();									// Remove any whitespace at both ends of String
							tempLabVenue = tempLabVenue.replaceAll("\\s+","");					// Remove any whitespace in String 
							System.out.println("New Course Lab Venue Input: "+tempLabVenue);
							System.out.println("========== Days of Week ===========\r\n" + 
									   "|1. MON          |4. THUR         |\r\n" + 
									   "|2. TUE          |5. FRI          |\r\n" +
									   "|3. WED                           |\r\n" +
									   "====================================\r\n");
							do {
								System.out.println("Input day of the week that lab of new course occurs:");
								tempLabDayNo = scan.nextInt();
								if(tempLabDayNo<1 || tempLabDayNo>5) {
									System.out.println("Please input a positive integer from 1 to 5.");
								}
							}while(tempLabDayNo<1 || tempLabDayNo>5);
							tempLabDay = listOfDays[tempLabDayNo-1];
							System.out.println("New Course Lab Day Input: "+tempLabDay);
							System.out.println("============= Frequency of Class ==============\r\n" + 
									   "|1. Weekly   |2. Odd Weeks   |3. Even Weeks   |\r\n" + 
									   "===============================================\r\n");
							do {
								System.out.println("Does the lab occur weekly? If not, does it occur on even or odd weeks?");
								tempLabWeekNo = scan.nextInt();
								if(tempLabWeekNo<1 || tempLabWeekNo>3) {
									System.out.println("Please input a positive integer from 1 to 3.");
								}
							}while(tempLabWeekNo<1 || tempLabWeekNo>3);
							tempLabWeek = listOfWeeks[tempLabWeekNo-1];
							System.out.println("New Course Lab Week Input: "+tempLabWeek);
							do {
								do {	// HANDLING LAB START TIME
									System.out.println("Input the time that lab commeneces (in 24hr format - eg.8am = 0800, 3.30pm = 1530 :");
									tempLabStartTime = scan.nextInt();
									if(((tempLabStartTime%100)>=60) || (tempLabStartTime>=2400) || (tempLabStartTime<0)) {
										if(tempLabStartTime<0) {
											System.out.println("Time input cannot be negative.");
										}
										else if(tempLabStartTime<10) {
											System.out.println("There is no 000" + tempLabStartTime + " hours.");
										}
										else if(tempLabStartTime<100) {
											System.out.println("There is no 00" + tempLabStartTime + " hours.");
										}
										else if(tempLabStartTime<1000) {
											System.out.println("There is no 0" + tempLabStartTime + " hours.");
										}
										else {
											System.out.println("There is no " + tempLabStartTime + " hours.");
										}
										System.out.println("This time format is incorrect. ");
									}
								}while(((tempLabStartTime%100)>=60) || (tempLabStartTime>=2400) || (tempLabStartTime<0));
								if(tempLabStartTime==0) {
									System.out.println("Lab starting time: 000"+tempLabStartTime+" hours");
								}
								else if(tempLabStartTime<10) {
									System.out.println("Lab starting time: 000"+tempLabStartTime+" hours");
								}
								else if(tempLabStartTime<100) {
									System.out.println("Lab starting time: 00"+tempLabStartTime+" hours");
								}
								else if(tempLabStartTime<1000) {
									System.out.println("Lab starting time: 0"+tempLabStartTime+" hours");
								}
								else {
									System.out.println("Lab starting time: "+tempLabStartTime+" hours");
								}
								do {	// HANDLING LAB END TIME
									System.out.println("Input the time lab ends in 24hrs format (Please ensure that this time is later than the time the lab starts):");
									tempLabEndTime = scan.nextInt();
									if(((tempLabEndTime%100)>=60) || (tempLabEndTime>=2400) || (tempLabEndTime<0)) {
										if(tempLabEndTime<0) {
											System.out.println("Time input cannot be negative.");
										}
										else if(tempLabEndTime<10) {
											System.out.println("There is no 000" + tempLabEndTime + " hours.");
										}
										else if(tempLabEndTime<100) {
											System.out.println("There is no 00" + tempLabEndTime + " hours.");
										}
										else if(tempLabEndTime<1000) {
											System.out.println("There is no 0" + tempLabEndTime + " hours.");
										}
										else {
											System.out.println("There is no " + tempLabEndTime + " hours.");
										}
										System.out.println("This time format is incorrect. ");
									}
								}while(((tempLabEndTime%100)>=60) || (tempLabEndTime>=2400) || (tempLabEndTime<0));
								if(tempLabEndTime==0) {
									System.out.println("Lab ending time: 000"+tempLabEndTime+" hours");
								}
								else if(tempLabEndTime<10) {
									System.out.println("Lab ending time: 000"+tempLabEndTime+" hours");
								}
								else if(tempLabEndTime<100) {
									System.out.println("Lab ending time: 00"+tempLabEndTime+" hours");
								}
								else if(tempLabEndTime<1000) {
									System.out.println("Lab ending time: 0"+tempLabEndTime+" hours");
								}
								else {
									System.out.println("Lab ending time: "+tempLabEndTime+" hours");
								}
								if (tempLabStartTime>=tempLabEndTime) {	// COMPARING START TIME & END TIME
									if((tempLabEndTime == 0) && (tempLabStartTime!=0)) {
										System.out.println("Lab timing: " + tempLabStartTime +" - 000"+ tempLabEndTime);
									}
									else {
										System.out.println("Lab ending time should be later than lab starting time. Lab cannot end beyond 0000 hours");
										System.out.println("Please input lab start timing and end timing again.");
									}
								}
								else {
									tempLabTiming[0] = tempLabStartTime;
									tempLabTiming[1] = tempLabEndTime;
								}
							}while(((tempLabStartTime>tempLabEndTime) && (tempLabEndTime!=0)) || (tempLabStartTime==tempLabEndTime));
							tempLabLesson = createLessonIndex(tempLabLessonType, tempLabVenue, tempLabDay, tempLabTiming, tempLabWeek);
							tempLessonsList.add(tempLabLesson);  	// Adds specific lab Lesson to temp lessonsList of each ClassIndex
							
							tempClassIndex = createClassIndex(newCourseName, newCourseCode, tempIndexNum, tempClassVacancy, tempLessonsList);
							tempIndexNumList.add(tempClassIndex);	 // Adds specific ClassIndex(containing a common lecture Lesson, specific tutorial Lesson & specific lab Lesson under a specific index num) to temp indexNumList for each ClassIndex
						}
						createCourse2(newCourseCode, newCourseName, newSchool, tempIndexNumList ,newAcadUnits); 
					}		
					break;
				case 4: // Update Course Code
					String currentCourseCode, updatedCourseCode;
					scan.nextLine();  // Consume newline left-over
					System.out.print("Input current course code of course:");
					currentCourseCode = scan.nextLine();
					currentCourseCode = currentCourseCode.trim();							// Remove any whitespace at both ends of String
					currentCourseCode = currentCourseCode.replaceAll("\\s+","");			// Remove any whitespace in String 
					System.out.println("Course Code to be Updated: "+currentCourseCode);
					System.out.print("Input updated course code of course:");
					updatedCourseCode = scan.nextLine();
					updatedCourseCode = updatedCourseCode.trim();							// Remove any whitespace at both ends of String
					updatedCourseCode = updatedCourseCode.replaceAll("\\s+","");			// Remove any whitespace in String 
					System.out.println("Course "+currentCourseCode+" is being updated to Course "+updatedCourseCode+".");
					updateCourseCode(currentCourseCode,updatedCourseCode);
					break;
				case 5: // Update Course School
					String courseCode, updatedSchool;
					int updatedSchoolNo;
					scan.nextLine();  // Consume newline left-over
					System.out.print("Input course code you wish to update:");
					courseCode = scan.nextLine();
					courseCode = courseCode.trim();											// Remove any whitespace at both ends of String
					courseCode = courseCode.replaceAll("\\s+","");
					System.out.println("School of Course "+courseCode+" is being updated.");// Remove any whitespace in String 
					System.out.println("Input updated school of course:");
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
					System.out.println("School of Course "+courseCode+" is being updated to "+updatedSchool+".");
					updateCourseSchool(courseCode,updatedSchool);
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
					System.out.println("Index Number of Course "+currentIndexNumber+" is being updated.");
					do {
						System.out.print("Input updated index number of course:");
						updatedIndexNumber = scan.nextInt();
						if(updatedIndexNumber<=0) {
							System.out.println("Please insert a positive value");
						}
					}while(updatedIndexNumber<=0);
					System.out.println("Index Number of Course "+currentIndexNumber+" is being updated to "+updatedIndexNumber+".");
					updateCourseIndexNumber(currentIndexNumber,updatedIndexNumber);
					break;
				case 7: // Update Index Number Vacancy
					int indexNumber, updatedVacancyNumber;
					do {
						System.out.print("Input index number of course vacancy to be changed:");
						indexNumber = scan.nextInt();
						if(indexNumber<=0) {
							System.out.println("Please insert a positive value");
						}
					}while(indexNumber<=0);
					System.out.println("Vacancy of Index Number "+indexNumber+" is being updated.");
					do {
						System.out.print("Input updated vacancy number of course:");
						updatedVacancyNumber = scan.nextInt();
						if(updatedVacancyNumber<0) {
							System.out.println("Please insert a non-negative value");
						}
					}while(updatedVacancyNumber<0);
					System.out.println("Vacancy of Index Number "+indexNumber+" is being updated to "+updatedVacancyNumber+".");
					updateIndexNumberVacancy(indexNumber,updatedVacancyNumber);
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
					System.out.println("Checking the Class Vacancies of Index Number "+indexNumberTemp1+"...");
					checkVacancies(indexNumberTemp1); 
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
					System.out.println("Printing the Student List by Index Number "+indexNumberTemp2+"...");
					printStudListByIndex(indexNumberTemp2); 
					break;
				case 10: // Print Student List by Course
					String courseCodeTemp;
					scan.nextLine();  // Consume newline left-over
					System.out.print("Input course code to print student list:");
					courseCodeTemp = scan.nextLine();
					courseCodeTemp = courseCodeTemp.trim();									// Remove any whitespace at both ends of String
					courseCodeTemp = courseCodeTemp.replaceAll("\\s+","");					// Remove any whitespace in String 
					System.out.println("Printing the Student List by Course "+courseCodeTemp+"...");
					printStudListByCourse(courseCodeTemp);
					break;
				case 11: // Exit
					UniDataBase.saveAllFiles();
					System.out.println("You have logged out.");
					break;
				default:
					System.out.println("Please insert a positive integer from 1-11");
			}
		}while(inputChoice!=11);
	}
	
	public static void addStudent(String name, String matricNo, String gender, String nationality, String userName, String pwd ,String email){
		//verifications
		if (UniDataBase.verifyExistedStudent(matricNo,userName)==true) {
			System.out.println("Student with matric number "+ matricNo +" or student with username " +
		userName+ " already exists");
			return;
		}
		//create student
		StudentRecords studentRecords = new StudentRecords();
		Student newStudent = new Student(userName, pwd, name , gender , nationality , false, matricNo,
				email, studentRecords);
		//send parameters to UniDataBase
		UniDataBase.addToStudents(newStudent);
		System.out.println("Student added.");
		//list all students
		System.out.println("Displaying all students.");
		UniDataBase.displayAllStudents();
	}
	
	public static void updateCourseCode(String currentCourseCode, String updatedCourseCode) {
		//verifications
		if (UniDataBase.verifyCourse(currentCourseCode)==false) {
			System.out.println("Course code "+ currentCourseCode+" does not exist");
			return;
		}
		if (UniDataBase.verifyCourse(updatedCourseCode)==true) {
			System.out.println("Course code "+updatedCourseCode+" already exists");
			return;
		}
		//send parameters to UniDataBase
		UniDataBase.updateCourseCode(currentCourseCode,updatedCourseCode);
		System.out.println("Course code updated.");
	}
	
	public static void updateCourseSchool(String courseCode, String updatedSchool) {
		//verifications
		if (UniDataBase.verifyCourse(courseCode)==false) {
			System.out.println("Course code "+courseCode+" does not exist");
			return;
		}
		//send parameters to UniDataBase
		UniDataBase.updateCourseSchool(courseCode, updatedSchool);
		System.out.println("School of course updated.");

	}
	
	public static void updateCourseIndexNumber(int currentIndexNumber, int updatedIndexNumber) {
		//verifications
		if (UniDataBase.verifyClassIndex(currentIndexNumber)==false) {
			System.out.println("Course index "+ currentIndexNumber +" does not exist");
			return;
		}
		if (UniDataBase.verifyClassIndex(updatedIndexNumber)==true) {
			System.out.println("Course index "+updatedIndexNumber+" already exists");
			return;
		}
		ClassIndex classIndex = UniDataBase.findClassIndex(currentIndexNumber);
		String courseCode= classIndex.getCourseCode();
		//send parameters to UniDataBase
		UniDataBase.updateCourseIndexNum(courseCode,currentIndexNumber,updatedIndexNumber);
		System.out.println("Index number of course updated.");
	}

	
	public static void updateIndexNumberVacancy(int indexNumber,int updatedVacancyNumber){
		//verification
		if (UniDataBase.verifyClassIndex(indexNumber)==false) {
			System.out.println("Course index "+indexNumber+" does not exist");
			return;
		}
		ClassIndex classIndex = UniDataBase.findClassIndex(indexNumber);
		String courseCode= classIndex.getCourseCode();
		//send parameters to UniDataBase
		UniDataBase.updateCourseVacancy(courseCode,indexNumber,updatedVacancyNumber);
		System.out.println("Vacancy of course index updated.");
	}
	
	public static void createCourse(String courseCode,String courseName,String school,
			int indexNum, int classVacancy,
			String lessonType,String classVenue,String classDay,int[] classTiming,String classWeek,int acadUnits) {
		//verifications
		if (UniDataBase.verifyCourse(courseCode)==true) {
			System.out.println("Course code "+courseCode+" already exists");
			return;
		}
		if (UniDataBase.verifyClassIndex(indexNum)==true) {
			System.out.println("Course index "+indexNum+" already exists");
			return;
		}
		if (UniDataBase.verifyLessonClash(classVenue,classDay,classTiming)==true) {
			System.out.println("There is a clash with an existing lesson at "+ classVenue +" on "+classDay+" from "
					+ classTiming[0] + " to " + classTiming[1]);
			return;
		}
		//create all ArrayList required
		ArrayList <ClassIndex> indexNumList = new ArrayList <ClassIndex>();
		ArrayList <Lesson> lessonsList = new ArrayList <Lesson>();
		ArrayList <Student> studentsList = new ArrayList <Student>();
		ArrayList <Student> waitList = new ArrayList <Student>();
		//create lesson,adding it to lessonsList
		lessonsList.add(new Lesson(lessonType,classVenue,classDay,classTiming,classWeek));
		//create class index, adding it to indexNumList
		indexNumList.add(new ClassIndex(courseName,courseCode,indexNum,classVacancy,lessonsList,studentsList,waitList));
		//create course
		Course newCourse=new Course(courseCode,courseName,school,acadUnits,indexNumList);
		//send newCourse to UniDataBase
		UniDataBase.addToCourses(newCourse);
		System.out.println("New course added");
		//display all courses after addition
		System.out.println("Displaying all courses");
		UniDataBase.displayAllCourses();
	}
	
	public static void printStudListByIndex(int indexNum) {
		//Verify existence of such a course index
		if (UniDataBase.verifyClassIndex(indexNum)==true){  
			ClassIndex classIndex =UniDataBase.findClassIndex(indexNum);
			UniDataBase.printStudList(classIndex);	
		}
		else System.out.println("Course index not found.");
	}
		
	public static void printStudListByCourse(String courseCode) {	
		//Verify existence of such a course
		if (UniDataBase.verifyCourse(courseCode)==true){
			Course course = UniDataBase.findCourseByCode(courseCode);
			UniDataBase.printStudList(course);	
		}
		else System.out.println("Course not found.");
		
	}
	
	public static Lesson createLessonIndex(String lessonType, String lessonVenue, String lessonDay, int [] lessonTiming, String lessonWeek) {
		return new Lesson(lessonType,lessonVenue,lessonDay,lessonTiming,lessonWeek);
	}
	
	public static ClassIndex createClassIndex(String courseName, String courseCode, int indexNum, int classVacancy, ArrayList <Lesson> lessonsList) {
		ArrayList <Student> studentsList = new ArrayList <Student>();
		ArrayList <Student> waitList = new ArrayList <Student>();
		return new ClassIndex(courseName,courseCode,indexNum,classVacancy,lessonsList,waitList,studentsList);
	}
		
	
	public static void createCourse2(String newCourseCode, String newCourseName, String newSchool, ArrayList <ClassIndex>tempIndexNumList , int newAcadUnits) {
		//verify course code
		if (UniDataBase.verifyCourse(newCourseCode)==true) {
			System.out.println("Course code "+newCourseCode+" already exists");
			return;
		}
		//verify all index number and verify lesson clash
		int tempIndexNumListSize=tempIndexNumList.size();
		int indexNum, lessonsListSize;
		String classVenue,classDay;
		int[] classTime;
		ArrayList<Lesson> lessonsList;
		for (int i=0;i<tempIndexNumListSize;i++){
			indexNum = tempIndexNumList.get(i).getIndexNum();
			if (UniDataBase.verifyClassIndex(indexNum)==true) {
				System.out.println("Course index "+indexNum+" already exists");
				return;
			}
			lessonsList = tempIndexNumList.get(i).getLessonsList();
			lessonsListSize = lessonsList.size(); 
			for (int j=0;j<lessonsListSize;j++) {
				classVenue = lessonsList.get(j).getClassVenue();
				classDay = lessonsList.get(j).getClassDay();
				classTime = lessonsList.get(j).getClassTiming();
				if (UniDataBase.verifyLessonClash(classVenue,classDay,classTime)==true) {
					System.out.println("There is a clash with an existing lesson at "+ classVenue +" on "+classDay+" from "
							+ classTime[0] + " to " + classTime[1]);
					return;
				}
			}
		}
		//create course
		Course newCourse=new Course( newCourseCode,newCourseName,newSchool, newAcadUnits,tempIndexNumList);
		//send newCourse to UniDataBase
		UniDataBase.addToCourses(newCourse);
		System.out.println("New course added");
		//display all courses after addition
		UniDataBase.displayAllCourses();
		
	}	
	
}
