package myapp;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class MailUtil 
{
	
	public static void sendMail(String to, String from, String subject, String body,
			boolean bodyIsHTML, String username, String password) throws MessagingException
	{
		//get the mail session
		System.out.println("reach sendmail");
		System.out.println();
		System.out.println();
		Properties prop=new Properties();
		prop.put("mail.transport.protocol","smtp");// "smtps");
		prop.put("mail.smtps.host", "smtp.gmail.com");
		prop.put("mail.smtps.port", 465);//25);
		//akps
		 prop.put("mail.smtp.debug", "true");
		   prop.put("SOCKET_FACTORY.class","javax.net.ssl.SSLSocketFactory");
		   prop.put("mail.smtp.socketFactory.fallback", "false");
		   prop.put("mail.smtp.starttls.enable", "true");
		    //akps
		prop.put("mail.smtps.auth", "true");
		Session session=Session.getDefaultInstance(prop);
		session.setDebug(true);
		System.out.println("reach message");
		System.out.println();
		System.out.println();
		//Create a message
		Message message=new MimeMessage(session);
		message.setSubject(subject);
		if(bodyIsHTML) message.setContent(body,"text/html");
		else message.setText(body);
		
		//address the message
		Address fromAddress=new InternetAddress(from);
		Address toAddress=new InternetAddress(to);
		message.setFrom(fromAddress);
		message.setRecipient(Message.RecipientType.TO,toAddress);
		
		// send the message
		Transport transport=session.getTransport(toAddress);
		transport.connect("ayekyipyarshwe@gmail.com","moekyiphyu2011");//username,password);
		transport.sendMessage(message,message.getAllRecipients());
		System.out.println("close mail util");
		System.out.println();
		System.out.println();
		transport.close();
		
	}

}
