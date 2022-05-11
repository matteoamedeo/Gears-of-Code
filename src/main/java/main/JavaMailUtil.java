package main;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

public class JavaMailUtil {

	public static void main(String[] args) {

		inviaMail("simonemattei.rm@gmail.com","username utente");

	}
	
	public static void inviaMail(String to, String username) {
		String from = "pwgruppo2.jaita50@gmail.com";
		String password = "JAITA50.";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port","465");
		prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Oggetto secondo messaggio");
			message.setText("Welcome " + username + ", thank you for your registration");
			Transport.send(message);
			System.out.println("Messaggio inviato");
		}catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("ERRORE");
		}
	}
public static void inviaCambioMail(String to, String username) {
		
		String from = "pwgruppo2.jaita50@gmail.com";
		String password = "JAITA50.";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port","465");
		prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Gears Of Code Change E-Mail");
			message.setText("Hello " + username.toUpperCase() + ", tour e-mail has been replaced.");
			Transport.send(message);
			System.out.println("Messaggio inviato");
		}catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("ERRORE");
		}
	}
}
