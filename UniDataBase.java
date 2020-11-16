import java.io.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class UniDataBase {
	
	static File coursesFile;
	static File studentsFile;
	static File adminsFile;
	static ArrayList<Course> courses;
	static ArrayList<Student> students;
	static ArrayList<Admin> admins;
	static int tempCoursesIndex;
	static int tempClassIndex;
	static LocalDateTime startAccessDate;
	static LocalDateTime endAccessDate; 
	
	public static void loadAllFiles() {
		//reading files in on start-up
		// How to deserialize the file back into the arraylist - must close after reading data from file! (file to class)
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
		
		// Top half has ClassNotFoundException AND IOException because class AND file may not exist
		// --------------------------------------------------------------------------------------------------------------
		// Bottom half only has IOException because class definitely has to exist for you to even store it - file may not exist
	
	public static void saveAllFiles() {
		// How to serialize the arraylist to file  - must close streams after adding data to file! (Class to file)
		// FOR SERIALIZING THE ARRAYLIST<COURSE> INTO COURSESFILE
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
		
		
		// printing out an arraylist iteratively
		for (Course s : courses) {
			System.out.println(s);
		}
	}
	
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
	
	public static void setStartAccessDate(int startMonth, int startDate, int startHour, int startMinute){
		startAccessDate = LocalDateTime.of(2020, startMonth, startDate, startHour, startMinute, 0);
	}
	
	public static void setEndAccessDate(int endMonth, int endDate, int endHour, int endMinute) {
		endAccessDate = LocalDateTime.of(2020, endMonth, endDate, endHour, endMinute, 0);
	}
	
	public static LocalDateTime getStartAccessDate() {
		return startAccessDate;
	}
	
	public static LocalDateTime getEndAccessDate() {
		return endAccessDate;
	}

	
	public static boolean verifyExistedStudent(String matricNo, String userName) {
		for (int i=0; i<students.size(); i++) {
			if (students.get(i).getMatricNo().equals(matricNo) || students.get(i).getUserName().equals(userName))
				return true;
		}
		return false;
	}
	
	public static boolean verifyCourse(String code) {
		for (int i =0; i<courses.size(); i++) {
			if (courses.get(i).getCourseCode().equals(code))
				return true;
		}
		return false;
	}

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
	
	public static Course findCourseByCode(String code) {
		for (int i =0; i<courses.size(); i++) {
			if (courses.get(i).getCourseCode().equals(code))
				return courses.get(i);
		}
		return null;
	}
	
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
	
	public static void addToCourses(Course newCourse) {
		courses.add(newCourse);
	}
	
	public static void updateCourseCode(String courseCode, String newCourseCode) {
		Course course = findCourseByCode(courseCode);
		course.setCourseCode(newCourseCode);
		for (int i=0; i<course.getIndexNumList().size(); i++) {
			course.getIndexNumList().get(i).setCourseCode(newCourseCode);
		}
	}
	
	public static void updateCourseSchool(String courseCode, String newSchool) {
		findCourseByCode(courseCode).setSchool(newSchool);
	}
	
	public static void updateCourseIndexNum(String courseCode, int currentIndexNumber, int updatedIndexNumber) {
		Course course = findCourseByCode(courseCode);
		ArrayList<ClassIndex> classIndexList = course.getIndexNumList();
		for (int i=0; i<classIndexList.size(); i++) {
			if (classIndexList.get(i).getIndexNum() == currentIndexNumber)
				classIndexList.get(i).setIndexNum(updatedIndexNumber);
		}
	}
	
	public static void updateCourseIndexNumList(String courseCode, ArrayList<ClassIndex> newIndexNumList) {
		Course course = findCourseByCode(courseCode);
		course.setIndexNumList(newIndexNumList);
	}
	
	public static void updateCourseVacancy(String courseCode, int indexNum, int newVacantNum) {
		Course course = findCourseByCode(courseCode);
		ClassIndex classIndex = findClassIndex(indexNum);
		classIndex.setClassVacancy(newVacantNum-classIndex.getStudentList().size());
		while (classIndex.getWaitList().isEmpty() == false && classIndex.getClassVacancy() != 0) {
				Student student = classIndex.getWaitList().remove(0);
				StudentRecords studentRecords = student.getStudentRecords();
				classIndex.getStudentList().add(student);
				classIndex.setClassVacancy(classIndex.getClassVacancy()-1);
				studentRecords.addCourseRegistered(classIndex);
				studentRecords.setAcadUnitsRegistered(studentRecords.getAcadUnitsRegistered() + course.getAcadUnits());
				
				//Notifying waiting student through email.
				sendEmail.courseRegistered(student.getEmail(), course.getCourseCode(), course.getCourseName(), classIndex.getIndexNum());
			}
	}

	public static void addToStudents(Student newStudent) {
		students.add(newStudent);
	}
	
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
	
	public static void removeCourseStudent(Student student, ClassIndex classIndex) {
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
				classIndex.getWaitList().remove(student);
				
				//Notifying waiting student through email.
				sendEmail.courseRegistered(studentWaiting.getEmail(), course.getCourseCode(), course.getCourseName(), classIndex.getIndexNum());
			}
		}
		
		if (student.getStudentRecords().getStudentWaitList().contains(classIndex)) {
			student.getStudentRecords().getStudentWaitList().remove(classIndex);
			classIndex.getWaitList().remove(student);
		}
	}
	
	public static void changeClassIndex(Student student, ClassIndex currentClassIndex, ClassIndex newClassIndex) {
		newClassIndex.getStudentList().add(student);
		currentClassIndex.getStudentList().remove(student);
		student.getStudentRecords().getCoursesRegistered().add(newClassIndex);
		student.getStudentRecords().getCoursesRegistered().remove(currentClassIndex);
	}
	
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
	
	public static void printStudList(Course course) {
		int indexNumListSize = course.getIndexNumList().size();
		for (int i=0; i<indexNumListSize; i++) {
			ClassIndex classIndex = course.getIndexNumList().get(i);
			ArrayList<Student> studentList = classIndex.getStudentList();
			for (i=0; i<studentList.size(); i++) {
				System.out.println(studentList.get(i).getName() + "\t" + studentList.get(i).getNationality() + "\t" + studentList.get(i).getGender());
			}
		}
		
	}
	
	public static void printStudList(ClassIndex classIndex) {
		ArrayList<Student> studentList = classIndex.getStudentList();
		for (int i=0; i<studentList.size(); i++) {
			System.out.println(studentList.get(i).getName() + "\t" + studentList.get(i).getNationality() + "\t" + studentList.get(i).getGender());
		}
	}
	
	public static boolean verifyLessonClash(String classVenue, String classDay, int[] classTime) {
		for (int i=0; i<courses.size(); i++) {
			for (int j=0; j<courses.get(i).getIndexNumList().size(); j++) {
				for (int k=0; k<courses.get(i).getIndexNumList().get(j).getLessonsList().size(); k++) {
					Lesson lesson = courses.get(i).getIndexNumList().get(j).getLessonsList().get(k);
					if (lesson.getClassVenue().equals(classVenue)) {
						if (lesson.getClassDay().equals(classDay)) {
							if (lesson.getClassTiming()[0] > classTime[0] && lesson.getClassTiming()[0] < classTime[1])
								return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static boolean verifyTimetableClash(Student student, int newClassIndex) {
		ClassIndex classIndex = findClassIndex(newClassIndex);
		Lesson lesson1, lesson2;
		ArrayList<ClassIndex> coursesRegistered = student.getStudentRecords().getCoursesRegistered();
		for (int i=0; i<coursesRegistered.size(); i++) {
			for (int j=0; j<coursesRegistered.get(i).getLessonsList().size(); j++) {
				lesson1 = coursesRegistered.get(i).getLessonsList().get(j);
				for (int k=0; k<classIndex.getLessonsList().size(); k++) {
					lesson2 = classIndex.getLessonsList().get(k);
					if (lesson1.getClassTiming()[0] > lesson2.getClassTiming()[0] && lesson1.getClassTiming()[0] < lesson2.getClassTiming()[1])
						return true;
				}
			}
		}
		ArrayList<ClassIndex> studentWaitingList = student.getStudentRecords().getStudentWaitList();
		for (int i=0; i<studentWaitingList.size(); i++) {
			for (int j=0; j<studentWaitingList.get(i).getLessonsList().size(); j++) {
				lesson1 = studentWaitingList.get(i).getLessonsList().get(j);
				for (int k=0; k<classIndex.getLessonsList().size(); k++) {
					lesson2 = classIndex.getLessonsList().get(k);
					if (lesson1.getClassTiming()[0] > lesson2.getClassTiming()[0] && lesson1.getClassTiming()[0] < lesson2.getClassTiming()[1])
						return true;
				}
			}
		}
		return false;
	}
	
	public static void displayAllCourses() {
		for (int i=0; i<courses.size(); i++) {
			System.out.println(String.format("%-7s%-30s",courses.get(i).getCourseCode(), courses.get(i).getCourseName()));
		}
	}
	
	public static void displayAllStudents() {
		for (int i=0; i<students.size(); i++) {
			System.out.println(String.format("%-30s%-10s%-20s%-6s" , students.get(i).getName(), students.get(i).getMatricNo(), students.get(i).getNationality(), students.get(i).getGender()));
		}
	}
	
	

}
