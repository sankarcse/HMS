package com.hms.utils;
import java.util.Properties;
import java.util.Random;

import javax.mail.*;  
import javax.mail.internet.*;  
  
public class MailApi {  
 public static void main(String[] args) {  
  
  String host="mail.javatpoint.com";  
  final String user="sankarcse05@gmail.com";//change accordingly  
  final String password="sank3a4r1";//change accordingly  
    
  String to="gn3ssankarcse@gmail.com";//change accordingly  
  
   //Get the session object  
   Properties props = new Properties();  
   props.put("mail.smtp.host",host);  
   props.put("mail.smtp.auth", "true");  
     
   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
    try {  
     MimeMessage message = new MimeMessage(session);  
     message.setFrom(new InternetAddress(user));  
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
     message.setSubject("HMS VERIFICATION CODE");  
     
     Random objGenerator = new Random();
     int number=objGenerator.nextInt(10000);
     
     message.setText("This is simple program of sending email using JavaMail API");  
       
    //send the message  
     Transport.send(message);  
  
     System.out.println("message sent successfully...");  
   
     } catch (MessagingException e) {e.printStackTrace();}  
 }  
}  