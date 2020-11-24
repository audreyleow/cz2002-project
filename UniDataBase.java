import java.io.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class UniDataBase {
	
	/**
	 *  Course's data file name
	 */
	static File coursesFile;
	
	/**
	 *  Student's data file name
	 */
	static File studentsFile;
	
	/**
	 *  Admin's data file name
	 */
	static File adminsFile;
	
	/**
	 * Settings' data file name
	 */
	static File settingsFile;
	
	/**
	 * An array list of all courses in the school
	 */
	static ArrayList<Course> courses;
	
	/**
	 * An array list of all students in the school
	 */
	static ArrayList<Student> students;
	
	/**
	 * An array List of all admins in the school
	 */
	static ArrayList<Admin> admins;
	
	/**
	 * The starting access time from which the student will be able to access StudentSTARS
	 */
	static LocalDateTime startAccessDate;
	
	/**
	 * The ending access time from which the student will no longer be able to access StudentSTARS
	 */
	static LocalDateTime endAccessDate; 
	
	/**
	 * Load all datas stored in external files into the application
	 */
	public static void loadAllFiles() {
		loadCoursesFile();
		loadStudentsFile();
		loadAdminsFile();
		loadSettingsFile();
	}
	
	/**
	 * Save all datas in the application currently into the external files
	 */
	public static void saveAllFiles() {
		saveCoursesFile();
		saveStudentsFile();
		saveAdminsFile();
		saveSettingsFile();
	}
	
	/**
	 * Load the courses data from courses file stored externally into courses arraylist
	 */
	public static void loadCoursesFile() {
		coursesFile = new File("courses.txt");
		courses = new ArrayList<Course>();
		// FOR READING COURSESFILE INTO ARRAYLIST<COURSE>
		FileInputStream fiCourses = null;
		ObjectInputStream inputCourses = null;
		try{
			fiCourses = new FileInputStream(coursesFile);
			inputCourses = new ObjectInputStream(fiCourses);
			while(true) {
				Course s = (Course)inputCourses.readObject();  // ClassNotFoundException in case class does not exist
				courses.add(s);
			}
		} catch (ClassNotFoundException|IOException ex) {
			try {
				inputCourses.close();
				fiCourses.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * Load the students data from students file stored externally into the students arraylist
	 */
	public static void loadStudentsFile() {
		studentsFile = new File("students.txt");
		students = new ArrayList<Student>();
		// FOR READING STUDENTSFILE INTO ARRAYLIST<STUDENT>
		FileInputStream fiStudents = null;
		ObjectInputStream inputStudents = null;
		try{
			fiStudents = new FileInputStream(studentsFile);
			inputStudents = new ObjectInputStream(fiStudents);
			while(true) {
				Student s = (Student)inputStudents.readObject();  // ClassNotFoundException in case class does not exist for.readOject()
				students.add(s);
			}
		} catch (ClassNotFoundException|IOException ex) {	
			//  IOException is the parent of FileNotFoundException - so you don't need both
			// 	IOException is a bigger net BUT it is the smallest net that catches both IOException and FileNotFoundException
			//	Will have error if you replace IOException with FileNotFound Exception
			try {
				inputStudents.close();
				fiStudents.close();
			} catch (IOException e) {  //  IOException is for when file cannot be opened/closed
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * Load the admins data from admins file stored externally into the admins arraylist
	 */
	public static void loadAdminsFile() {
		adminsFile = new File("admins.txt");
		admins=new ArrayList<Admin>();
		// FOR READING ADMINSFILE INTO ARRAYLIST<ADMIN>
		FileInputStream fiAdmins = null;
		ObjectInputStream inputAdmins = null;
		try{
			fiAdmins = new FileInputStream(adminsFile);
			inputAdmins = new ObjectInputStream(fiAdmins);
			while(true) {
				Admin s = (Admin)inputAdmins.readObject();  // ClassNotFoundException in case class does not exist
				admins.add(s);
			}
		} catch (ClassNotFoundException|IOException ex) {
			try {
				inputAdmins.close();
				fiAdmins.close();
			} catch (IOException e) {  //  IOException is for when file cannot be opened/closed
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * Load the settings data from courses file stored externally to get the starting access time and ending access time for the student
	 */
	public static void loadSettingsFile() {
		settingsFile=new File("settings.txt");
		// For access period
		FileInputStream fiSettings = null;
		ObjectInputStream inputSettings = null;
		try{
			fiSettings = new FileInputStream(settingsFile);
			inputSettings = new ObjectInputStream(fiSettings);
			startAccessDate = (LocalDateTime)inputSettings.readObject();
			endAccessDate =(LocalDateTime)inputSettings.readObject();
			// ClassNotFoundException in case class does not exist
		} catch (ClassNotFoundException|IOException ex) {
			try {
				inputSettings.close();
				fiSettings.close();
			} catch (IOException e) {  //  IOException is for when file cannot be opened/closed
				System.out.println(e.getMessage());
			}
		}
	}
			
	/**
	 * Save the changes, done to the courses data, into the external file
	 */
	public static void saveCoursesFile() {
		
		try {
			FileOutputStream foCourses = new FileOutputStream(coursesFile);
			ObjectOutputStream outputCourses = new ObjectOutputStream(foCourses);
			for (Course s : courses) {
				outputCourses.writeObject(s);
			}
			outputCourses.close();
			foCourses.close();
		}catch (IOException e) {  //  IOException is for when file cannot be opened/closed
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Save the changes, done to the students data, into the external file
	 */
	public static void saveStudentsFile() {
		// FOR SERIALIZING THE ARRAYLIST<STUDENT> INTO STUDENTSFILE
		try {
			FileOutputStream foStudents = new FileOutputStream(studentsFile);
			ObjectOutputStream outputStudents = new ObjectOutputStream(foStudents);
			for (Student s : students) {
				outputStudents.writeObject(s);
			}
			outputStudents.close();
			foStudents.close();
		}catch (IOException e) { //  IOException is for when file cannot be opened/closed
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Save the changes, done to the admins data, into the external file
	 */
	public static void saveAdminsFile() {
		// FOR SERIALIZING THE ARRAYLIST<ADMIN> INTO ADMINSFILE
		try {
			FileOutputStream foAdmins = new FileOutputStream(adminsFile);
			ObjectOutputStream outputAdmins = new ObjectOutputStream(foAdmins);
			for (Admin s : admins) {
				outputAdmins.writeObject(s);
			}
			outputAdmins.close();
			foAdmins.close();
		}catch (IOException e) { //  IOException is for when file cannot be opened/closed
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Save the changes, done to the settings data, into the external file
	 */
		public static void saveSettingsFile() {
		//for access period
		try {
			FileOutputStream foSettings = new FileOutputStream(settingsFile);
			ObjectOutputStream outputSettings = new ObjectOutputStream(foSettings);
			
			outputSettings.writeObject(startAccessDate);
			outputSettings.writeObject(endAccessDate);
			
			outputSettings.close();
			foSettings.close();
		}catch (IOException e) { //  IOException is for when file cannot be opened/closed
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Check whether the student exists in the data and whether the password is correct. 
	 * @param userName The student's account user name
	 * @param pwd The student's account password
	 * @return True if student exists in the data and the password entered is correct.
	 */
	public static boolean verifyStudentAccount(String userName, String pwd) {
		for (int i=0; i<students.size(); i++) {
			if (students.get(i).getUserName().equals(userName)) {
				if (students.get(i).getPwd().equals(pwd))
					return true;
				else
					return false;
			}
		}
		return false;
	}
	
	/**
	 * Check whether the admin exists in the data and whether the password is correct.
	 * @param userName The admin's account user name
	 * @param pwd The admin's account password
	 * @return True if admin exists in the data and the password entered is correct.
	 */
	public static boolean verifyAdminAccount(String userName, String pwd) {
		for (int i=0; i<admins.size(); i++) {
			if (admins.get(i).getUserName().equals(userName)) {
				if (admins.get(i).getPwd().equals(pwd))
					return true;
				else
					return false;
			}
		}
		return false;
	}
	
	/**
	 * Change the starting access timing
	 * @param startMonth Month of starting access time
	 * @param startDate Day of starting access time
	 * @param startHour Hour of starting access time
	 * @param startMinute Minute of starting access time
	 */
	public static void setStartAccessDate(int startMonth, int startDate, int startHour, int startMinute){
		startAccessDate = LocalDateTime.of(2020, startMonth, startDate, startHour, startMinute, 0);
	}
	
	/**
	 * Change the ending access timing
	 * @param endMonth Month of ending access time
	 * @param endDate Day of ending access time
	 * @param endHour Hour of ending access time
	 * @param endMinute Minute of ending access time
	 */
	public static void setEndAccessDate(int endMonth, int endDate, int endHour, int endMinute) {
		endAccessDate = LocalDateTime.of(2020, endMonth, endDate, endHour, endMinute, 0);
	}
	
	/**
	 * Get the starting access timing
	 * @return The starting access timing
	 */
	public static LocalDateTime getStartAccessDate() {
		return startAccessDate;
	}
	
	/**
	 * Get the ending access timing
	 * @return The ending access timing
	 */
	public static LocalDateTime getEndAccessDate() {
		return endAccessDate;
	}

	/**
	 * Check whether a student with the given matricNo or userName is already in the system data.
	 * @param matricNo Matriculation number to be check with
	 * @param userName User name to be check with
	 * @return True if a student with the given matriculation number or user name is already in the system data
	 */
	public static boolean verifyExistedStudent(String matricNo, String userName) {
		for (int i=0; i<students.size(); i++) {
			if (students.get(i).getMatricNo().equals(matricNo) || students.get(i).getUserName().equals(userName))
				return true;
		}
		return false;
	}
	
	/**
	 * Check whether a course with the given course code is already in the system data.
	 * @param code The course code to be check with
	 * @return True if a course with the given course code is already in the system data.
	 */
	public static boolean verifyCourse(String code) {
		for (int i =0; i<courses.size(); i++) {
			if (courses.get(i).getCourseCode().equals(code))
				return true;
		}
		return false;
	}
	
	/**
	 * Check whether a class index with the given class index number is already in the system data.
	 * @param indexNum The class index number to be check with
	 * @return True if a class index with the given class index number is already in the system data.
	 */
	public static boolean verifyClassIndex(int indexNum) {
		for (int i=0; i<courses.size(); i++) {
			ArrayList<ClassIndex> indexNumList = courses.get(i).getIndexNumList();
			for (int j=0; j<indexNumList.size(); j++) {
				if (indexNumList.get(j).getIndexNum() == indexNum)
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Get the Student object from the system data if the user name and password matches correctly.
	 * @param userName The student's account user name
	 * @param pwd The student's account password
	 * @return The student object
	 */
	public static Student findStudentByAccount(String userName, String pwd) {
		int i;
		for (i=0; i<students.size(); i++) {
			if (students.get(i).getUserName().equals(userName)) {
				if (students.get(i).getPwd().equals(pwd))
					break;
			}
		}
		return students.get(i);
	}
	
	/**
	 * Get the Course object from the system data if the course code exists.
	 * @param code The course's course code
	 * @return The course object
	 */
	public static Course findCourseByCode(String code) {
		for (int i =0; i<courses.size(); i++) {
			if (courses.get(i).getCourseCode().equals(code))
				return courses.get(i);
		}
		return null;
	}
	
	/**
	 * Get the ClassIndex object from the system data if the class index number exists
	 * @param indexNum The class index's identification number
	 * @return The ClassIndex object
	 */
	public static ClassIndex findClassIndex(int indexNum) {
		for (int i=0; i<courses.size(); i++) {
			ArrayList<ClassIndex> indexNumList = courses.get(i).getIndexNumList();
			for (int j=0; j<indexNumList.size(); j++) {
				if (indexNumList.get(j).getIndexNum() == indexNum)
					return indexNumList.get(j);
			}
		}
		return null;
	}
	
	/**
	 * Add a new Course object into the array list of courses in the application
	 * @param newCourse The new course to be added into the school system
	 */
	public static void addToCourses(Course newCourse) {
		courses.add(newCourse);
	}
	
	/** 
	 * Update the course's course code
	 * @param courseCode The current course code of the course that is to be changed
	 * @param newCourseCode The new course code that is assigned to the course
	 */
	public static void updateCourseCode(String courseCode, String newCourseCode) {
		Course course = findCourseByCode(courseCode);
		course.setCourseCode(newCourseCode);
		for (int i=0; i<course.getIndexNumList().size(); i++) {
			course.getIndexNumList().get(i).setCourseCode(newCourseCode);
		}
	}
	
	/**
	 * Update the school that the course is from.
	 * @param courseCode The current course code of the course that is to be changed
	 * @param newSchool The new school that is assigned to the course
	 */
	public static void updateCourseSchool(String courseCode, String newSchool) {
		findCourseByCode(courseCode).setSchool(newSchool);
	}
	
	/**
	 * Update the current index number in a course with new index number
	 * @param courseCode The course code of the course that is to be made changes to
	 * @param currentIndexNumber The current class index number of the class
	 * @param updatedIndexNumber The new class index number to be assigned to the class
	 */
	public static void updateCourseIndexNum(String courseCode, int currentIndexNumber, int updatedIndexNumber) {
		Course course = findCourseByCode(courseCode);
		ArrayList<ClassIndex> classIndexList = course.getIndexNumList();
		for (int i=0; i<classIndexList.size(); i++) {
			if (classIndexList.get(i).getIndexNum() == currentIndexNumber)
				classIndexList.get(i).setIndexNum(updatedIndexNumber);
		}
	}
	
	/**
	 * Update the course's array list of class index with a new array list of class index
	 * @param courseCode The course code of the course that is to be made changes to
	 * @param newIndexNumList The new array list of class index that is to the replace the current array list of class index in the course.
	 */
	public static void updateCourseIndexNumList(String courseCode, ArrayList<ClassIndex> newIndexNumList) {
		Course course = findCourseByCode(courseCode);
		course.setIndexNumList(newIndexNumList);
	}
	
	/**
	 * Update the class's vacancy of a class index in a course
	 * @param courseCode The course code of the course that is to be make changes to
	 * @param indexNum The class index number of the class index that is to be made changes to
	 * @param newVacantNum The new vacancy number of the class
	 */
	public static void updateCourseVacancy(String courseCode, int indexNum, int newVacantNum) {
		Course course = findCourseByCode(courseCode);
		ClassIndex classIndex = findClassIndex(indexNum);
		classIndex.setClassVacancy(newVacantNum);
		while (classIndex.getWaitList().isEmpty() == false && classIndex.getClassVacancy() != 0) {
				Student student = classIndex.getWaitList().remove(0);
				StudentRecords studentRecords = student.getStudentRecords();
				classIndex.getStudentList().add(student);
				classIndex.setClassVacancy(classIndex.getClassVacancy()-1);
				studentRecords.addCourseRegistered(classIndex);
				studentRecords.setAcadUnitsRegistered(studentRecords.getAcadUnitsRegistered() + course.getAcadUnits());
				studentRecords.removeStudentWaitList(classIndex);
			
				//Notifying waiting student through email.
				NotificationApp notifyApp = new NotificationApp(new Email()); 
				notifyApp.courseAllocated(student,indexNum);
			}
	}
	
	/**
	 * Add a new Student object into the array list of students in the application
	 * @param newStudent The new student to be added into the school system
	 */
	public static void addToStudents(Student newStudent) {
		students.add(newStudent);
	}
	
	/**
	 * Add a new student into the class (of the class index number)
	 * @param student The student to be added into the class
	 * @param classIndex The class that the student is to be added into
	 */
	public static void addCourseStudent(Student student, ClassIndex classIndex) {
		//classIndex is not filled yet
		String courseCode = classIndex.getCourseCode();
		Course course = findCourseByCode(courseCode);
		if (classIndex.getClassVacancy() != 0) {
			student.getStudentRecords().addCourseRegistered(classIndex);
			int tempAcadUnitsRegistered = student.getStudentRecords().getAcadUnitsRegistered(); 
			student.getStudentRecords().setAcadUnitsRegistered(tempAcadUnitsRegistered + course.getAcadUnits());
			classIndex.getStudentList().add(student);
			classIndex.setClassVacancy(classIndex.getClassVacancy()-1);
		}
		
		//classIndex is filled currently --> add to waiting list
		else {
			classIndex.getWaitList().add(student);
			student.getStudentRecords().getStudentWaitList().add(classIndex);
		}
	}
	
	/**
	 * Remove a student from the class (of the class index number)
	 * @param student The student to be removed from the class
	 * @param classIndex The class that the student is to be removed from
	 */
	public static void removeCourseStudent(Student student, ClassIndex classIndex) {
		if (student.getStudentRecords().getStudentWaitList().contains(classIndex)) {
			student.getStudentRecords().getStudentWaitList().remove(classIndex);
			classIndex.getWaitList().remove(student);
			return;
		}		
		if (student.getStudentRecords().getCoursesRegistered().contains(classIndex)) {
			String courseCode = classIndex.getCourseCode();
			Course course = findCourseByCode(courseCode);
			student.getStudentRecords().getCoursesRegistered().remove(classIndex);
			int tempAcadUnitsRegistered = student.getStudentRecords().getAcadUnitsRegistered();
			student.getStudentRecords().setAcadUnitsRegistered(tempAcadUnitsRegistered - course.getAcadUnits());
			classIndex.getStudentList().remove(student);
			classIndex.setClassVacancy(classIndex.getClassVacancy()+1);
			
			//add students from waiting list if there is people waiting to get the class index
			if (classIndex.getWaitList().isEmpty() == false) {
				Student studentWaiting = classIndex.getWaitList().get(0);
				studentWaiting.getStudentRecords().getStudentWaitList().remove(classIndex);
				studentWaiting.getStudentRecords().getCoursesRegistered().add(classIndex);
				tempAcadUnitsRegistered = studentWaiting.getStudentRecords().getAcadUnitsRegistered();
				studentWaiting.getStudentRecords().setAcadUnitsRegistered(tempAcadUnitsRegistered + course.getAcadUnits());
				classIndex.getStudentList().add(studentWaiting);
				classIndex.setClassVacancy(classIndex.getClassVacancy()-1);
				classIndex.getWaitList().remove(0);
				
				//Notifying waiting student through email.
				NotificationApp notifyApp = new NotificationApp(new Email()); 
				notifyApp.courseAllocated(studentWaiting,classIndex.getIndexNum());
			}
		}
		
		if (student.getStudentRecords().getStudentWaitList().contains(classIndex)) {
			student.getStudentRecords().getStudentWaitList().remove(classIndex);
			classIndex.getWaitList().remove(student);
		}
	}
	
	/**
	 * Change the class that a student is currently in into another another. If there is student in the waitlist of the current class, the student in the waitlist will be added into it.
	 * @param student The student that is changing class.
	 * @param currentClassIndex The current class the student is in.
	 * @param newClassIndex The new class that the student will be transfered into.
	 */
	public static void changeClassIndex(Student student, ClassIndex currentClassIndex, ClassIndex newClassIndex) {
		Course course = findCourseByCode(currentClassIndex.getCourseCode());
		newClassIndex.getStudentList().add(student);
		newClassIndex.setClassVacancy(newClassIndex.getClassVacancy()-1);
		currentClassIndex.getStudentList().remove(student);
		currentClassIndex.setClassVacancy(currentClassIndex.getClassVacancy()+1);
		student.getStudentRecords().getCoursesRegistered().add(newClassIndex);
		student.getStudentRecords().getCoursesRegistered().remove(currentClassIndex);
		
		if (currentClassIndex.getWaitList().isEmpty() == false) {
			Student studentWaiting = currentClassIndex.getWaitList().get(0);
			studentWaiting.getStudentRecords().getStudentWaitList().remove(currentClassIndex);
			studentWaiting.getStudentRecords().getCoursesRegistered().add(currentClassIndex);
			int tempAcadUnitsRegistered = studentWaiting.getStudentRecords().getAcadUnitsRegistered();
			studentWaiting.getStudentRecords().setAcadUnitsRegistered(tempAcadUnitsRegistered + course.getAcadUnits());
			currentClassIndex.getStudentList().add(studentWaiting);
			currentClassIndex.setClassVacancy(currentClassIndex.getClassVacancy()-1);
			currentClassIndex.getWaitList().remove(student);
			
			//Notifying waiting student through email.
			NotificationApp notifyApp = new NotificationApp(new Email()); 
			notifyApp.courseAllocated(studentWaiting,currentClassIndex.getIndexNum());
		}
	}
	
	/**
	 * Swap the class index of student1 with the class index of student2. Both the class index need to belong to the same course for it to works
	 * @param student1 1st student
	 * @param student2 2nd student
	 * @param classIndex1 Current class index of the 1st student
	 * @param classIndex2 Current class index of the 2nd student
	 */
	public static void swopClassIndex(Student student1, Student student2, ClassIndex classIndex1, ClassIndex classIndex2) {
		if (classIndex1.getCourseCode().equals(classIndex2.getCourseCode())) {
			classIndex1.getStudentList().remove(student1);
			classIndex2.getStudentList().remove(student2);
			classIndex1.getStudentList().add(student2);
			classIndex2.getStudentList().add(student1);
			student1.getStudentRecords().getCoursesRegistered().remove(classIndex1);
			student2.getStudentRecords().getCoursesRegistered().remove(classIndex2);
			student1.getStudentRecords().getCoursesRegistered().add(classIndex2);
			student2.getStudentRecords().getCoursesRegistered().add(classIndex1);
		}
	}
	
	/**
	 * Print the list of students enrolled in a course.
	 * @param course Course object that the you want to get the list of students
	 */
	public static void printStudList(Course course) {
		int indexNumListSize = course.getIndexNumList().size();
		System.out.println(String.format("%-7s%-20s%-30s","Gender","Nationality","Name"));
		System.out.println("-------------------------------");
		for (int i=0; i<indexNumListSize; i++) {
			ClassIndex classIndex = course.getIndexNumList().get(i);
			ArrayList<Student> studentList = classIndex.getStudentList();
			for (int j=0; j<studentList.size(); j++) {
				System.out.println(String.format("%-7s%-20s%-30s" , studentList.get(j).getGender(),studentList.get(j).getNationality(),studentList.get(j).getName()));
			}
		}	
	}
	
	/**
	 * Print the list of students enrolled in a class (index).
	 * @param classIndex ClassIndex object that you want to get the list of students
	 */
	public static void printStudList(ClassIndex classIndex) {
		ArrayList<Student> studentList = classIndex.getStudentList();
		System.out.println(String.format("%-7s%-20s%-30s","Gender","Nationality","Name"));
		System.out.println("-------------------------------");
		for (int i=0; i<studentList.size(); i++) {
			System.out.println(String.format("%-7s%-20s%-30s" , studentList.get(i).getGender(),studentList.get(i).getNationality(),studentList.get(i).getName()));
		}
	}
	
	/**
	 * To check whether whether there is an existing class, in the courses arraylist, that utilizes the venue on the same day and clashes with its timing of usage
	 * @param classVenue Location of the class
	 * @param classDay Day of the class
	 * @param classTime Timing of the class
	 * @return True if there is already a class in the system that utilized the venue on the same day and clashes with its timing of usage
	 */
	public static boolean verifyLessonClash(String classVenue, String classDay, int[] classTime) {
		int startTime1, startTime2,endTime1,endTime2;
		for (int i=0; i<courses.size(); i++) {
			for (int j=0; j<courses.get(i).getIndexNumList().size(); j++) {
				for (int k=0; k<courses.get(i).getIndexNumList().get(j).getLessonsList().size(); k++) {
					Lesson lesson = courses.get(i).getIndexNumList().get(j).getLessonsList().get(k);
					if (lesson.getClassVenue().equals(classVenue)) {
						if (lesson.getClassDay().equals(classDay)) {
							startTime1 = lesson.getClassTiming()[0];
							startTime2 = classTime[0];
							endTime1=lesson.getClassTiming()[1];
							endTime2=classTime[1];
							if ((startTime1 >= startTime2 && startTime1 < endTime2)
									||(endTime1 > startTime2 && endTime1 <= endTime2)
									||(startTime1==startTime2 && endTime1==endTime2) )
								return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Check whether the new class clashes with any other courses that the student has already registered.
	 * @param student The student, which his registered course will be checked against
	 * @param newClassIndex The new class that the student is trying to register
	 * @return True if there is at least one clash in timing between the new class and the courses that the student has already registered
	 */
	public static boolean verifyTimetableClash(Student student, int newClassIndex) {
		int startTime1, startTime2,endTime1,endTime2;
		ClassIndex classIndex = findClassIndex(newClassIndex);
		Lesson lesson1, lesson2;
		ArrayList<ClassIndex> coursesRegistered = student.getStudentRecords().getCoursesRegistered();
		for (int i=0; i<coursesRegistered.size(); i++) {
			for (int j=0; j<coursesRegistered.get(i).getLessonsList().size(); j++) {
				lesson1 = coursesRegistered.get(i).getLessonsList().get(j);
				for (int k=0; k<classIndex.getLessonsList().size(); k++) {
					lesson2 = classIndex.getLessonsList().get(k);
					if(lesson1.getClassDay().equals(lesson2.getClassDay())) {
						startTime1 = lesson1.getClassTiming()[0];
						startTime2 = lesson2.getClassTiming()[0];
						endTime1=lesson1.getClassTiming()[1];
						endTime2=lesson2.getClassTiming()[1];
						if ((startTime1 >= startTime2 && startTime1 < endTime2)
								||(endTime1 > startTime2 && endTime1 <= endTime2)
								||(startTime1==startTime2 && endTime1==endTime2) )
							return true;
					}
				}
			}
		}
		ArrayList<ClassIndex> studentWaitingList = student.getStudentRecords().getStudentWaitList();
		for (int i=0; i<studentWaitingList.size(); i++) {
			for (int j=0; j<studentWaitingList.get(i).getLessonsList().size(); j++) {
				lesson1 = studentWaitingList.get(i).getLessonsList().get(j);
				for (int k=0; k<classIndex.getLessonsList().size(); k++) {
					lesson2 = classIndex.getLessonsList().get(k);
					if(lesson1.getClassDay().equals(lesson2.getClassDay())) {
						startTime1 = lesson1.getClassTiming()[0];
						startTime2 = lesson2.getClassTiming()[0];
						endTime1=lesson1.getClassTiming()[1];
						endTime2=lesson2.getClassTiming()[1];
						if ((startTime1 >= startTime2 && startTime1 < endTime2)
								||(endTime1 > startTime2 && endTime1 <= endTime2)
								||(startTime1==startTime2 && endTime1==endTime2) )
							return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * When the student is already registered in a class of a course, check whether the new class (of this course) clashes with any other courses that the student has already registered. 
	 * @param student The student, which his registered course will be checked against
	 * @param newClassIndex The new class that the student is trying to swap into
	 * @param oldClassIndex The current class that the student is in
	 * @return True if there is at least one clash in timing between the new class and the courses that the student has already registered
	 */
	public static boolean verifyTimetableClash(Student student, int newClassIndex,int oldClassIndex) {
		ClassIndex classIndex = findClassIndex(newClassIndex);
		Lesson lesson1, lesson2;
		int starttime1,starttime2,endtime1,endtime2;
		ArrayList<ClassIndex> coursesRegistered = student.getStudentRecords().getCoursesRegistered();
		for (int i=0; i<coursesRegistered.size(); i++) {
			if(coursesRegistered.get(i).getIndexNum()==oldClassIndex) {
				continue;
			}
			for (int j=0; j<coursesRegistered.get(i).getLessonsList().size(); j++) {
				lesson1 = coursesRegistered.get(i).getLessonsList().get(j);
				for (int k=0; k<classIndex.getLessonsList().size(); k++) {
					lesson2 = classIndex.getLessonsList().get(k);
					if(lesson1.getClassDay().equals(lesson2.getClassDay())) {
						starttime1 = lesson1.getClassTiming()[0];
						starttime2 = lesson2.getClassTiming()[0];
						endtime1=lesson1.getClassTiming()[1];
						endtime2=lesson2.getClassTiming()[1];
						if ((starttime1 >= starttime2 && starttime1 < endtime2)
								||(endtime1 > starttime2 && endtime1 <= endtime2)
								||(starttime1==starttime2 && endtime1==endtime2) )
							return true;
					}
				}
			}
		}
		ArrayList<ClassIndex> studentWaitingList = student.getStudentRecords().getStudentWaitList();
		for (int i=0; i<studentWaitingList.size(); i++) {
			for (int j=0; j<studentWaitingList.get(i).getLessonsList().size(); j++) {
				lesson1 = studentWaitingList.get(i).getLessonsList().get(j);
				for (int k=0; k<classIndex.getLessonsList().size(); k++) {
					lesson2 = classIndex.getLessonsList().get(k);
					if(lesson1.getClassDay().equals(lesson2.getClassDay())) {
						starttime1 = lesson1.getClassTiming()[0];
						starttime2 = lesson2.getClassTiming()[0];
						endtime1=lesson1.getClassTiming()[1];
						endtime2=lesson2.getClassTiming()[1];
						if ((starttime1 >= starttime2 && starttime1 < endtime2)
								||(endtime1 > starttime2 && endtime1 <= endtime2)
								||(starttime1==starttime2 && endtime1==endtime2) )
							return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Print a list of courses currently available in the system
	 */
	public static void displayAllCourses() {
		System.out.println(String.format("%-11s%-30s","Course Code","Course Name"));
		System.out.println("---------------------");
		for (int i=0; i<courses.size(); i++) {
			System.out.println(String.format("%-11s%-30s",courses.get(i).getCourseCode(), courses.get(i).getCourseName()));
		}
	}
	
	/**
	 * Print a list of students currently in the course registration system.
	 */
	public static void displayAllStudents() {
		System.out.println(String.format("%-10s%-7s%-20s%-30s","Matric No.","Gender","Nationality","Name"));
		System.out.println("-----------------------------------------");	
		for (int i=0; i<students.size(); i++) {
			System.out.println(String.format("%-10s%-7s%-20s%-30s" , students.get(i).getMatricNo(),students.get(i).getGender(), students.get(i).getNationality(),students.get(i).getName()));
		}
	}
	
	

}
