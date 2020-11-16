public class STARS {
	
	public static void checkVacancies(int indexNumber) {
		//verification
		if (UniDataBase.verifyClassIndex(indexNumber)==false) {
			System.out.println("Course index "+indexNumber+" does not exist");
			return;
		}
		ClassIndex classIndex = UniDataBase.findClassIndex(indexNumber);
		int classVacancy= classIndex.getClassVacancy();
		System.out.println("Course index "+indexNumber+" has "+classVacancy+" slot(s) left");
	}
	
	public static void showErrorMessage() {
		System.out.println("Error! Please input again!");
	}
}

