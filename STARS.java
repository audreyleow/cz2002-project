import java.util.ArrayList;

public class STARS {
	
	
	private ArrayList<String> Student = new ArrayList<String>();

	private ArrayList<String> Admin = new ArrayList<String>();
	
	private ArrayList<String> Course = new ArrayList<String>();
	
	private long studentAccessPeriod;
	
	private long studentAccessDuration;
	
	public void checkVacancies(int indexNumber) {
		//verification
		if (verifyClassIndex(indexNumber)==false) {
			System.out.println("Course index "+indexNumber+" does not exist");
		}
		ClassIndex classIndex = findClassIndex(indexNumber);
		int classVacancy= classIndex.getClassVacancy();
		System.out.println("Course index "+indexNumber+" has "+classVacancy+" slot(s) left");
	}
	
	public void showErrorMessage() {
		System.out.println("Error! Please input again!");
	}
}

