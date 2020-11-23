import java.io.Serializable;
public class Admin extends User implements Serializable{
	
	/**
	 * Admin Identification Number
	 */
	private String staffID;
	
	/**
	 * Constructor for creating an Admin
	 * @param userName Admin Account Username
	 * @param pwd Admin Account Password
	 * @param name Admin's name
	 * @param gender Admin's gender
	 * @param nationality Admin's nationality
	 * @param staffID Admin's identification Number
	 */
	public Admin(String userName, String pwd, String name, String gender, String nationality, String staffID) {
		super(userName, pwd, name, gender, nationality);
		this.staffID = staffID;
	}
	
	/**
	 * Get the Admin's Identification number
	 * @return this Admin's Identification number
	 */
	public String getStaffID() {
		return staffID;
	}
	
	/**
	 *  Change the Admin's Identification number
	 * @param staffID the Admin's new Identification number
	 */
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	
	

}
