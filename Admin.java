
public class Admin extends User{
	private String staffID;

	public Admin(String userName, String pwd, String name, String gender, String nationality, boolean accesslevel, String staffID) {
		super(userName, pwd, name, gender, nationality, accesslevel);
		this.staffID = staffID;
	}
	
	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	
	

}

