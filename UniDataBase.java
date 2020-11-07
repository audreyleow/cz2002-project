import java.io.*;
import java.util.ArrayList;

public class UniDataBase {
	
	File coursesFile;
	File studentsFile;
	File adminsFile;
	ArrayList<Course> courses;
	ArrayList<Student> students;
	ArrayList<Admin> admins;
	int tempCoursesIndex;
	int tempClassIndex;
	
	public UniDataBase() {
		coursesFile = new File("courses.txt");
		studentsFile = new File("students.txt");
		adminsFile = new File("admins.txt");
		courses = new ArrayList<Course>();
		students = new ArrayList<Student>();
		admins = new ArrayList<Admin>();
		tempCoursesIndex = -1;
		tempClassIndex = -1;
	}
	
	public void loadAllFiles() {
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
	
	public void saveAllFiles() {
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
	
	public boolean verifyStudentAccount(String userName, String pwd) {
		for (int i=0; i<students.size(); i++) {
			if (students.get(i).getUserName() == userName) {
				if (students.get(i).getPwd()==pwd)
					return true;
				else
					return false;
			}
		}
		return false;
	}
	
	public boolean verifyAdminAccount(String userName, String pwd) {
		for (int i=0; i<admins.size(); i++) {
			if (admins.get(i).getUserName() == userName) {
				if (admins.get(i).getPwd()==pwd)
					return true;
				else
					return false;
			}
		}
		return false;
	}
	
	public boolean verifyCourse(String code) {
		for (int i =0; i<courses.size(); i++) {
			if (courses.get(i).getCourseCode() == code)
				return true;
		}
		return false;
	}

	public boolean verifyCLassIndex(int indexNum) {
		for (int i=0; i<courses.size(); i++) {
			ArrayList<ClassIndex> indexNumList = courses.get(i).getIndexNumList();
			for (int j=0; j<indexNumList.size(); j++) {
				if (indexNumList.get(j).getIndexNum() == indexNum)
				return true;
			}
		}
		return false;
	}
	
	public Course findCourseByCode(String code) {
		for (int i =0; i<courses.size(); i++) {
			if (courses.get(i).getCourseCode() == code)
				return courses.get(i);
		}
		return null;
	}
	
	public ClassIndex findClassIndex(int indexNum) {
		for (int i=0; i<courses.size(); i++) {
			ArrayList<ClassIndex> indexNumList = courses.get(i).getIndexNumList();
			for (int j=0; j<indexNumList.size(); j++) {
				if (indexNumList.get(j).getIndexNum() == indexNum)
					return indexNumList.get(j);
			}
		}
		return null;
	}
	
	public void addToCourses(Course newCourse) {
		courses.add(newCourse);
	}
	
	public void updateCourseCode(String courseCode, String newCourseCode) {
		findCourseByCode(courseCode).setCourseCode(newCourseCode);
	}
	
	public void updateCourseSchool(String courseCode, String newSchool) {
		findCourseByCode(courseCode).setSchool(newSchool);
	}
	
	public void updateCourseVacancy(String courseCode, int indexNum, int newVacantNum) {
		findClassIndex(indexNum).setClassVacancy(newVacantNum);
	}
	
	public void addToStudents(Student newStudent) {
		students.add(newStudent);
	}
	
	public void addCourseStudent(Student student, ClassIndex classIndex) {
		
		//classIndex is not filled yet
		int tempClassVacancy = classIndex.getClassVacancy();
		String courseCode = classIndex.getCourseCode();
		Course course = findCourseByCode(courseCode);
		if (tempClassVacancy != 0) {
			student.getStudentRecords().addCourseRegistered(classIndex);
			int tempAcadUnitsRegistered = student.getStudentRecords().getAcadUnitsRegistered(); 
			student.getStudentRecords().setAcadUnitsRegistered(tempAcadUnitsRegistered + course.getAcadUnits());
			classIndex.getStudentList().add(student);
			classIndex.setClassVacancy(tempClassVacancy -= 1);
		}
		
		//classIndex is filled currently --> add to waiting list
		else {
			classIndex.getWaitList().add(student);
		}
	}
	
	public void removeCourseStudent(Student student, ClassIndex classIndex) {
		if (student.getStudentRecords().getCoursesRegistered().contains(classIndex)) {
			String courseCode = classIndex.getCourseCode();
			Course course = findCourseByCode(courseCode);
			student.getStudentRecords().getCoursesRegistered().remove(classIndex);
			int tempAcadUnitsRegistered = student.getStudentRecords().getAcadUnitsRegistered();
			student.getStudentRecords().setAcadUnitsRegistered(tempAcadUnitsRegistered - course.getAcadUnits());
			classIndex.getStudentList().remove(student);
			int tempClassVacancy = classIndex.getClassVacancy();
			classIndex.setClassVacancy(tempClassVacancy + 1);
			
			//add students from waiting list if there is people waiting to get the class index
			if (classIndex.getWaitList().isEmpty() == false) {
				Student studentWaiting = classIndex.getWaitList().get(0);
				studentWaiting.getStudentRecords().getCoursesRegistered().add(classIndex);
				tempAcadUnitsRegistered = studentWaiting.getStudentRecords().getAcadUnitsRegistered();
				studentWaiting.getStudentRecords().setAcadUnitsRegistered(tempAcadUnitsRegistered + course.getAcadUnits());
				classIndex.getStudentList().add(studentWaiting);
				tempClassVacancy = classIndex.getClassVacancy();
				classIndex.setClassVacancy(tempClassVacancy - 1);
				
				/////need the sending email application here
			}
			
		}
	}
	
	public void swopClassIndex(Student student1, Student student2, ClassIndex classIndex1, ClassIndex classIndex2) {
		if (classIndex1.getCourseCode() == classIndex2.getCourseCode()) {
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
	
	public void printStudList(Course course) {
		int indexNumListSize = course.getIndexNumList().size();
		for (int i=0; i<indexNumListSize; i++) {
			ClassIndex classIndex = course.getIndexNumList().get(i);
			ArrayList<Student> studentList = classIndex.getStudentList();
			for (i=0; i<studentList.size(); i++) {
				System.out.println(studentList.get(i).getName() + "		" + studentList.get(i).getMatricNo());
			}
		}
		
	}
	
	public void printStudList(ClassIndex classIndex) {
		ArrayList<Student> studentList = classIndex.getStudentList();
		for (int i=0; i<studentList.size(); i++) {
			System.out.println(studentList.get(i).getName() + "		" + studentList.get(i).getMatricNo());
		}
	}

}
