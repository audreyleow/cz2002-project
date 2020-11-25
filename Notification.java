public interface Notification {
	/**
	 * Creates an abstract method for sending notification to students
	 * @param student
	 * @param messageSubject
	 * @param messageContent
	 */
	public void sendNotification(Student student,String messageSubject,String messageContent);
}
