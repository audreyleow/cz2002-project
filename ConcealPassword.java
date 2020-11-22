import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConcealPassword {
	// Handles console input when running outside of Eclipse
		  public static String getPasswordMasked(Console cons) {
		    char[] pswd;
		    while (true) {
		    	System.out.println("Please input password:");
		    	pswd = cons.readPassword();
		      if (pswd != null) {
		        if (pswd.length > 0) {
		          return new String(pswd);
		        } else {
		          System.out.println("Invalid input\n");
		        }
		      }
		    }
		  }

		   // Handles console input when running inside of Eclipse;
		   // @throws IOException if password is zero-length
		  public static String getPasswordWithinEclipse() throws IOException {
		    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		    System.out.println("Please input password:");
		    String password = reader.readLine();
		    if (password != null) {
		      if (password.length() <= 0) {
		        System.out.println("Invalid input\n");
		        throw new IOException("Error reading in password");
		      }
		    }
		    return password;
		  }
}
