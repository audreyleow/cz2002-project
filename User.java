import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * unique identifier of this user to log in to the system
	 */
	private String userName;
	/**
	 * password which this user uses to log in to the system
	 */
	private String pwd;
	/**
	 * name of this user
	 */
	private String name;
	/**
	 * gender (male/female) of this user
	 */
	private String gender;
	/**
	 * country where this user comes from
	 */
	private String nationality;
	
	/**
	 * Constructor for new user that wants to use the system
	 * @param userName
	 * @param pwd
	 * @param name
	 * @param gender
	 * @param nationality
	 */
	public User(String userName, String pwd, String name, String gender, String nationality) {
		this.userName = userName;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.nationality = nationality;
	}
	
	/**
	 * Gets the unique username that this user uses to log in to the system
	 * @return username of the user
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * sets new unique username that this user uses to log in to the system
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	/**
	 * gets the password that this user needs to log in to the system
	 * @return password of the user
	 */
	public String getPwd() {
		return pwd;
	}
	
	/**
	 * sets new password that this user uses to log in to the system
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	/**
	 * gets the name of this user
	 * @return name of this user
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the name of this new user
	 * @param name 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * gets the gender of this user
	 * @return gender (male/female) of this user
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * sets the gender of new user
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * gets the nationality of this user
	 * @return country where this user comes from
	 */
	public String getNationality() {
		return nationality;
	}
	
	/**
	 * sets the country where this new user comes from 
	 * @param nationality
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
}
