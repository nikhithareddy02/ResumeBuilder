package com.smartResume.helper;

import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  


public class Mailer {  
	public static void send(String to,String subject,String msg){  

		

		System.setProperty("http.proxyHost", "proxy.iiit.ac.in");
		System.setProperty("http.proxyPort", "8080");
		
		
		final String user="nikhithareddy02@gmail.com";//change accordingly  
		final String pass="nickyreddy.02";  

		//1st step) Get the session object    
		Properties props = new Properties();  
		//props.put("mail.smtp.host", "mail.gmail.com");//change accordingly  
		//props.put("mail.smtp.auth", "true");  

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		//props.setProperty("mail.smtp.user", user); // Needed if not authenticating
       // props.setProperty("mail.smtp.password", pass);
		
		Session session = Session.getDefaultInstance(props,  
				new javax.mail.Authenticator() {  
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {  
				return new PasswordAuthentication(user,pass);  
			}  
		});  
		//2nd step)compose message  
		
		try {  
			MimeMessage message = new MimeMessage(session);  
			message.setFrom(new InternetAddress(user));  
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			message.setSubject(subject);  
			message.setText(msg);  

			//3rd step)send message  
			Transport.send(message);  

			System.out.println("Done");  

		} catch (MessagingException e) {  
			throw new RuntimeException(e);  
		}  

	}  
	public static void main(String[] args) {
		Mailer.send("nikhithareddy02@gmail.com", "hi", "msg");
	}
}  