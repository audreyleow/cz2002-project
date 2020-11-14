import java.io.Serializable;

public class User implements Serializable{
	
	private String userName;
	private String pwd;
	private String name;
	private String gender;
	private String nationality;
	
	public User(String userName, String pwd, String name, String gender, String nationality) {
		this.userName = userName;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.nationality = nationality;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
}
