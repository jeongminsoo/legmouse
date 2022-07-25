package com.lec.ch19.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lec.ch19.dao.MemberDao;
import com.lec.ch19.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
	@Override
	public int idCheck(String mid) { 
		return memberDao.idCheck(mid);
	}
	
	@Override
	public Member getmember(String mid) {
		return memberDao.getmember(mid);
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession session) {
		String result = "로그인 성공";
		Member member = memberDao.getmember(mid);
		if (member == null) {
			result = "유효하지 않은 아이디입니다";
		} else if (!mpw.equals(member.getMpw())) {
			result = "비밀번호가 다릅니다";
		} else {
			session.setAttribute("member", member);
		}
		return result;
	}

	@Override
	public int join(final Member member) {
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = "<div style=\"width : 500px; margin : 0 auto; text-align : center;\">\n" + 
					"	<h1 style=\"color : blue;\">" + member.getMname() + "님 회원가입 감사합니다</h1>\n" + 
					"	<div>\n" + 
					"		<p>우리 사이트에서만 쓰실 수 있는 감사 쿠폰을 드립니다</p>\n" + 
					"		<p>\n" + 
					"			<img src=\"http://localhost:8090/ch19/img/coupon.jpg\">\n" + 
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
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMemail())); // 받는메일
				mimeMessage.setFrom(new InternetAddress("rnsqkflalsrjf@gmail.com"));
				mimeMessage.setSubject("[가입인사]" + member.getMname() + "님의 회원가입을 축하드립니다");
				mimeMessage.setText(content, "utf-8", "html");
				
			}
		};
		mailSender.send(message);
		return memberDao.join(member);
	}

	@Override
	public int modify(HttpSession session, Member member) {
		session.removeAttribute("member");
		session.setAttribute("member", member);
		return memberDao.modify(member);
	}

	

}
