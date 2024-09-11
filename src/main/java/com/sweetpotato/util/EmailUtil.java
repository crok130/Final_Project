package com.sweetpotato.util;

import java.util.Properties;

import org.springframework.stereotype.Component;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {

    private static final String HOST = "smtp.naver.com";
    private static final String PORT = "465"; // SSL을 사용하는 경우
    private static final String EMAIL = "star8795@naver.com";
    private static final String PASSWORD = "Kim168017**"; // 실제 네이버 계정의 앱 비밀번호 (2단계 인증 사용 시)

    public static void sendEmail(String toEmail, String subject, String body) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true"); // SSL을 사용할 경우

        // TLS를 사용할 경우:
        // props.put("mail.smtp.starttls.enable", "true"); // 포트 587을 사용할 경우
        // props.put("mail.smtp.ssl.enable", "false"); // 포트 465을 사용할 경우

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, PASSWORD);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setContent(body, "text/html; charset=UTF-8"); // HTML 형식으로 설정

            Transport.send(message);
            System.out.println("이메일 전송 성공");
        } catch (MessagingException e) {
            System.err.println("이메일 전송 실패: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
