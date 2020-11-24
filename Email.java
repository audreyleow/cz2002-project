import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email implements Notification{
	
	/**
	 * send notification about courses to student via email 
	 * @param student The student that will receive the notification
	 * @param messageSubject The title of the notification that student will receive
	 * @param messageContent The content of the notification about the courses
	 */
	public void sendNotification(Student student,String messageSubject,String messageContent) {
		final String username = "CZ2002Group5"; 
		final String password = "testUser0"; 

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("CZ2002Group5@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(student.getEmail())); 
			message.setSubject(messageSubject);	
			message.setText(messageContent);
			Transport.send(message);
			System.out.println("Notification Sent.");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
