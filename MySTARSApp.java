import java.util.Scanner;
import java.io.Console;
import java.io.IOException;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter; 
	
public class MySTARSApp {

	/**
	 * Interface that handles interaction with the user specifically for logging in
	 * @param args
	 */
	public static void main(String[] args) {
		String userNameLogIn;
		String passwordLogIn = null;
		int logInOption = 1;
		Scanner scan = new Scanner(System.in);
		UniDataBase.loadAllFiles();
        do{
        	System.out.println("Please input your username:");
    		userNameLogIn = scan.nextLine();
    		userNameLogIn = userNameLogIn.trim();									// Remove any whitespace at both ends of String
    		userNameLogIn = userNameLogIn.replaceAll("\\s+","");					// Remove any whitespace in String
    		Console cons = System.console();
    	    if (cons == null) {
    	      // In the Eclipse IDE.
    	      try {
    	        System.out.println("Running within Eclipse IDE (Password will not be masked)");
    	        passwordLogIn = ConcealPassword.getPasswordWithinEclipse();
    	      } catch (IOException e) {
    	        System.err.println("Error getting password" + e.getMessage());
    	        System.exit(1);
    	      }
    	    } else {
    	    	passwordLogIn = ConcealPassword.getPasswordMasked(cons);
    	    }
    		passwordLogIn = passwordLogIn.trim();									// Remove any whitespace at both ends of String
    		passwordLogIn = passwordLogIn.replaceAll("\\s+","");					// Remove any whitespace in String
    		String hashedPasswordInput = HashPassword.generateHash(passwordLogIn);
    		 //Call uniDataBase methods for start time and end time object
             LocalDateTime startAccessDate = UniDataBase.getStartAccessDate();
             LocalDateTime endAccessDate = UniDataBase.getEndAccessDate();
             LocalDateTime now = LocalDateTime.now();
        	if(UniDataBase.verifyStudentAccount(userNameLogIn, hashedPasswordInput) == true) { // STUDENT USER
    			if((now.isAfter(startAccessDate) || (now.isEqual(startAccessDate))) && now.isBefore(endAccessDate)) {
    				Student studentLoggedIn = UniDataBase.findStudentByAccount(userNameLogIn, hashedPasswordInput);
    				StudentSTARS.run(studentLoggedIn);
    			}
    			else {
    				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
    				String startAccessDateTimeFormatted = startAccessDate.format(format);
    				String endAccessDateTimeFormatted = endAccessDate.format(format);
    				System.out.println("Not allowed to access now. You may only log in from "+ startAccessDateTimeFormatted + " to "+endAccessDateTimeFormatted+".");
    			}
    		}
    		else if(UniDataBase.verifyAdminAccount(userNameLogIn, hashedPasswordInput) == true) { // ADMIN USER
    			AdminSTARS.run();
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
