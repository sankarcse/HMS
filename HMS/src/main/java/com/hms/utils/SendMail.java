package com.hms.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;


public class SendMail {



	
	public String sendMail(String toEmail,String subject,String message) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        //mailMessage.setFrom("sankarcse05@gmail.com");

        new JavaMailSenderImpl().send(mailMessage);
        return "success";
    }
}

//http://localhost:9000/sendMail/send?to=sankarcse05@gmail.com&subject=hms login&message=hello

/*package com.hms.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendMail")
public class SendMail {

@Autowired
private JavaMailSender javaMailSender;

	@GetMapping(value="/send",produces = { "application/json" })
	public String sendMail(@RequestParam(value = "to") String toEmail, @RequestParam(value = "subject") String subject, @RequestParam(value = "message") String message) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        //mailMessage.setFrom("sankarcse05@gmail.com");

        javaMailSender.send(mailMessage);
        return "success";
    }
}*/