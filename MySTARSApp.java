import java.util.Scanner;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter; 
	
public class MySTARSApp {
	public static void main(String[] args) {
		String userNameLogIn, passwordLogIn;
		int logInOption = 1;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input your username:");
		userNameLogIn = scan.nextLine();
		System.out.println("Please input your password:");
		passwordLogIn = scan.nextLine();
		// Missing hashing for password
        // Call uniDataBase methods for start time and end time object
         LocalDateTime startAccessDate = getStartAccessDate();
         LocalDateTime endAccessDate = getEndAccessDate();
         LocalDateTime now = LocalDateTime.now();
        do{
        	if(verifyStudentAccount(userNameLogIn, passwordLogIn) == true) { // STUDENT USER
    			if((now.isAfter(startAccessDate) || (now.isEqual(startAccessDate))) && now.isBefore(endAccessDate)) {
    				Student studentLoggedIn = findStudentByAccount(userNameLogIn, passwordLogIn);
    				StudentSTARS.run(studentLoggedIn);
    			}
    			else {
    				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
    				String startAccessDateTimeFormatted = startAccessDate.format(format);
    				String endAccessDateTimeFormatted = endAccessDate.format(format);
    				System.out.println("Not allowed to access now. You may only log in from "+ startAccessDateTimeFormatted + " to "+endAccessDateTimeFormatted+".");
    			}
    		}
    		else if(verifyAdminAccount(userNameLogIn, passwordLogIn) == true) { // ADMIN USER
    			AdminStars.run();
    		}
    		else {
    			System.out.println("Incorrect username or password!");
    			do {
    				System.out.println("Do you wish to try logging in again?");
    				System.out.println("== Log in again? ==\r\n" + 
    					   "|1. Yes  |2. No   |\r\n" + 
    					   "===================\r\n");
    				logInOption = scan.nextInt();
    				if(logInOption<1 || logInOption>2) {
    					System.out.println("Please input a positive integer of 1 or 2.");
    				}
    			}while(logInOption<1 || logInOption>2);
    			scan.nextLine();
    		}
        }while(logInOption == 1);
	}
}
