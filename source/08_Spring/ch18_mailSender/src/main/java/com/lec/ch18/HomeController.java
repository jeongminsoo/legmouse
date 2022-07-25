package com.lec.ch18;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "join";
	}
	
	@RequestMapping(value="textMail", method = RequestMethod.GET)
	public String textMail(String name, String email, Model model) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("rnsqkflalsrjf@gmail.com"); // 보내는 사람 메일
		message.setTo(email); // 받는 사람 메일
		message.setSubject("[가입인사]" + name + "님 회원가입 감사합니다");
		String content = name + "님 회원가입 감사합니다\n";
		message.setText(content);
		
		mailSender.send(message);
		model.addAttribute("mailSendResult", "TEXT메일이 발송되었습니다");
		return "sendResult";
	}
	
	@RequestMapping(value="htmlMail", method = RequestMethod.GET)
	public String htmlMail(final String name, final String email, Model model) {
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = "<div style=\"width : 500px; margin : 0 auto; text-align : center;\">\n" + 
					"	<h1 style=\"color : blue;\">" + name + "님 회원가입 감사합니다</h1>\n" + 
					"	<div>\n" + 
					"		<p>우리 사이트에서만 쓰실 수 있는 감사 쿠폰을 드립니다</p>\n" + 
					"		<p>\n" + 
					"			<img src=\"http://localhost:8090/ch18/resources/coupon.jpg\">\n" + 
					"		</p>\n" + 
					"	</div>\n" + 
					"	<div>\n" + 
					"		<p style=\"color : red;\">빨간글씨부분</p>\n" + 
					"		<p style=\"color : blue;\">파란글씨부분</p>\n" + 
					"		<img src=\"https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAxMjFfMiAg%2FMDAxNjQyNzM2MTMwNTA3.nlWqDz9hFQHz0zuFpjuE46rDMLI5UvXNRcXGa42slSsg.FfwFX__g36oWuPcz-C-Mj_mfipgoI2-Bkc6EhWzTdXQg.JPEG.kkokko8526%2Fphoto-1588988949118-c86ba9c9c225.jpg&type=a340\">\n" + 
					"	</div>\n" + 
					"</div>"; // 메일내용
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// 보내는 메일, 받는 메일, 메일 제목, utf-8 처리
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email)); // 받는메일
				mimeMessage.setFrom(new InternetAddress("rnsqkflalsrjf@gmail.com"));
				mimeMessage.setSubject("[가입인사]" + name + "님 감사감사");
				mimeMessage.setText(content, "utf-8", "html");
				
			}
		};
		mailSender.send(message);
		model.addAttribute("mailSendResult", "HTML 메일이 발송되었습니다");
		
		return "sendResult";
	}
}
