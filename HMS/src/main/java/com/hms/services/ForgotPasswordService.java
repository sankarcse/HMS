package com.hms.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.entities.LoginEntity;
import com.hms.entities.UserVerification;
import com.hms.repositories.LoginRepo;
import com.hms.repositories.UserVerificationRepo;

@Service
public class ForgotPasswordService {

	@Autowired
	private LoginRepo repository;

	@Autowired
	private UserVerificationRepo userVerificationRepo;

	@Autowired
	private LoginRepo loginRepo;

	public String testUserName(LoginEntity loginEntity) throws JsonProcessingException {

		Map<String, String> map = new HashMap<String, String>();
		ObjectMapper objectMapper = new ObjectMapper();
		LoginEntity user = repository.findByUserName(loginEntity.getUserName());
		if (user != null) {
			map.put("validation", "valid");
			String json = objectMapper.writeValueAsString(map);
			return json;
		} else {
			map.put("validation", "invalid");
			String json = objectMapper.writeValueAsString(map);
			return json;
		}
	}

	public String sendMailUtil(LoginEntity loginEntity) throws JsonProcessingException {
		Map<String, String> map = new HashMap<String, String>();
		ObjectMapper objectMapper = new ObjectMapper();
		String recipientMail = repository.findEmailByUserName(loginEntity.getUserName());
		String flag = "";

		Properties props = new Properties();
		/*props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");*/
		
		
		props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        

		// Sender's email ID needs to be mentioned
		String from = "gn3ssankarcse@gmail.com";
		final String password = "S@nkar143";// change accordingly

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientMail));
			message.setSubject("HMS Validation Code");
			Random rand = new Random();
			int validCode = rand.nextInt(9999);
			message.setText("This is the validation code for your HMS forgot password  " + validCode + "");
			Transport.send(message);

			UserVerification userVerification = new UserVerification(loginEntity.getUserName(), "" + validCode);
			UserVerification verification = userVerificationRepo.save(userVerification);
			if (verification != null) {
				map.put("confirmation", "sent");
				flag = objectMapper.writeValueAsString(map);
			}

		} catch (Exception exception) {

			map.put("confirmation", "notsent");
			flag = objectMapper.writeValueAsString(map);

			exception.printStackTrace();
		}
		return flag;

	}

	public String changePassword(String code, UserVerification userVerification) throws JsonProcessingException {
		Map<String, String> map = new HashMap<String, String>();
		ObjectMapper objectMapper = new ObjectMapper();
		String vCode = userVerificationRepo.findVerificationCodeByUserName(userVerification.getUserName());
		if (code.equals(vCode)) {
			map.put("validation", "valid");
			String json = objectMapper.writeValueAsString(map);
			return json;
		} else {
			map.put("validation", "invalid");
			String json = objectMapper.writeValueAsString(map);
			return json;
		}

	}

	public String updatePassword(LoginEntity loginEntity) throws JsonProcessingException {
		Map<String, String> map = new HashMap<String, String>();
		ObjectMapper objectMapper = new ObjectMapper();
		
		int validation = loginRepo.updatePassword(loginEntity.getUserName(),loginEntity.getUserPassword());

		if (validation !=0) {
			map.put("validation", "valid");
			String json = objectMapper.writeValueAsString(map);
			return json;
		} else {
			map.put("validation", "invalid");
			String json = objectMapper.writeValueAsString(map);
			return json;
		}

	}
}
