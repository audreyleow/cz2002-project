import java.util.*;
public class StudentStars extends STARS { //student page
	
	Scanner scan = new Scanner(System.in);
  
  //main function 
	
	public void addCourse() { // invokes addCourseStudent in unidatabase?
		
		System.out.println("Add course for student:");
		Course.add(scan.next());
		
		
	}
	public void dropCourse() { // invoke removeCourseStudent in unidatabase?
		
		System.out.println("Drop course for student");
		Course.remove(scan.next());
		
	}
	public void printCourses() { // student id stored or student name stored in student Arraylist?
		
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
	public void changeIndex() { // input second student id
		System.out.println("Enter index of second student:");
		Integer studentId = scan.nextInt();
		for (int i =0; i < Student.size(); i++) {    //find student in the arraylist
			if (studentId == Student.get(i))
				// invoke swopClassIndex() in unidatabase?
		}
		
		
	}

}
