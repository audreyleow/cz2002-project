import java.io.Serializable;
public class Admin extends User implements Serializable{
	private String staffID;

	public Admin(String userName, String pwd, String name, String gender, String nationality, String staffID) {
		super(userName, pwd, name, gender, nationality);
		this.staffID = staffID;
	}
	
	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	
	

}

