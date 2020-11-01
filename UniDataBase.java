import java.io.*;
import java.util.ArrayList;

public class UniDataBase {

		public static void main(String[] args) {
			File coursesFile = new File("courses.txt");
			File studentsFile = new File("students.txt");
			File adminsFile = new File("admins.txt");
			ArrayList<Course> courses = new ArrayList<Course>();
			ArrayList<Student> students = new ArrayList<Student>();
			ArrayList<Admin> admins = new ArrayList<Admin>();
			
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
			
			
			// Top half only has IOException because class definitely has to exist for you to even store it - file may not exist
			// --------------------------------------------------------------------------------------------------------------
			// Bottom half has ClassNotFoundException AND IOException because class AND file may not exist
			
			 
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
			
			
			
			// printing out an arraylist iteratively
			for (Course s : courses) {
				System.out.println(s);
			}
		}

	}

