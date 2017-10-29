package com.appium.maas.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

public class SendMail {
	@Test
	public static void sendEmail() {

		final Properties mailProps = new Properties();
		try {

			FileInputStream fileinput = new FileInputStream(System.getProperty("user.dir") + "/Data/mail.properties");
			mailProps.load(fileinput);

			// creates a new session with an authenticator

			Authenticator auth = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mailProps.getProperty("mail.user"),
							mailProps.getProperty("mail.password"));
				}
			};
			Session session = Session.getInstance(mailProps, auth);

			// creates a new e-mail message
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(mailProps.getProperty("mail.user")));
			
			//To use multiple mail accounts in to filed provide space between two mails
			InternetAddress[] toAddresses = InternetAddress.parse(mailProps.getProperty("toAddress"), false) ;
			msg.setRecipients(Message.RecipientType.TO,toAddresses );
			msg.setSubject(mailProps.getProperty("subject"));
			msg.setSentDate(new Date());

			// creates message part

			MimeBodyPart messagebodyPart = new MimeBodyPart();
			messagebodyPart.setText("TestNg run report");

			// Create multi part

			MimeMultipart multiPart = new MimeMultipart();
			multiPart.addBodyPart(messagebodyPart);

			// add attachment

			MimeBodyPart attachPart = new MimeBodyPart();
			attachPart.attachFile(System.getProperty("user.dir")+mailProps.getProperty("filepath"));
			//attachPart.setContent("html", "text/html; charset=utf-8");
			multiPart.addBodyPart(attachPart);
			

			// sets the multi-part as e-mail's content

			msg.setContent(multiPart);

			// sends the e-mail
			Transport.send(msg);
		}

		catch (IOException | MessagingException e) {
			
			e.printStackTrace();

		}
	}
}
