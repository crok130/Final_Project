package com.sweetpotato.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

@WebServlet("/sendResetLink")
public class SendResetLinkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        // 여기에 이메일 전송을 위한 SMTP 서버 설정을 추가합니다.
        String host = "smtp.naver.com"; // SMTP 서버 주소
        final String user = "star8795@naver.com"; // 발신 이메일 주소
        final String password = "Kim168017**"; // 발신 이메일 비밀번호

        // SMTP 서버 설정
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");

        // 세션 생성
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            // 메일 메시지 설정
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("비밀번호 재설정 링크");
            message.setText("비밀번호를 재설정하려면 아래 링크를 클릭하세요:\n" +
                            "http://yourdomain.com/resetPassword?email=" + email);

            // 메일 전송
            Transport.send(message);

            response.sendRedirect("resetLinkSent.jsp"); // 링크 전송 후 리다이렉트할 페이지
        } catch (MessagingException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // 에러 페이지로 리다이렉트
        }
    }
}
