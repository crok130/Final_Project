package com.sweetpotato.emailServlet;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@WebServlet("/sendResetLink")
public class SendResetLinkServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userEmail = request.getParameter("email");

		// generateResetToken() 메소드를 호출하여 토큰 생성
		String token = generateResetToken();
		
		// 비밀번호 재설정 링크 생성
		String resetLink = "도메인 주소";

		// 이메일 발송 로직
		String host = "smtp.naver.com";
		String from = "star8795@naver.com";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);

		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
			message.setSubject("비밀번호 재설정 요청");
			message.setText("비밀번호를 재설정하시려면 아래 링크를 클릭하세요.: \n" + resetLink);

			Transport.send(message);
			response.getWriter().println("비밀번호 재설정 링크가 이메일로 전송되었습니다.");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	private String generateResetToken() {
		// 토큰 생성 로직 (UUID를 사용하거나 특정 알고리즘 적용)
		return java.util.UUID.randomUUID().toString();
	}
}