public class NotificationApp {
	private Notification notification;
	/**
	 * Initialises Notification application (to allow for notification of successful course allocation for a student)
	 * @param notification
	 */
	public NotificationApp(Notification notification) {
		this.notification=notification;
	}
	/**
	 * Notification message created to notify student when a course gets allocated to him/her
	 * @param student
	 * @param indexNum
	 */
	public void courseAllocated(Student student,int indexNum){
	ClassIndex classIndex = UniDataBase.findClassIndex(indexNum);
	String messageSubject = "Course Allocated";
	String messageContent = "Name:"+student.getName() +
			"\nMatric No.: " + student.getMatricNo() +
			"\nWe are pleased to inform you that you have been allocated the following course: "+
		 	"\nCourse Code: " + classIndex.getCourseCode() +
			"\nCourse Name: " + classIndex.getCourseName() +
			"\nCourse Index: " + classIndex.getIndexNum() +
			"\n\nRegards\nAdmin of MySTARS\n\nThis is a computer-generated document, no signature is required.";
	notification.sendNotification(student, messageSubject, messageContent);
	}
}
