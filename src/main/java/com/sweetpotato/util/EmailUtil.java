package com.sweetpotato.util;

import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailUtil {

    // SMTP 서버 호스트
    private static final String HOST = "smtp.naver.com";
    // SMTP 서버 포트 (SSL을 사용할 경우 465)
    private static final String PORT = "465";
    // 이메일 계정
    private static final String EMAIL = "star8795@naver.com";
    // 이메일 계정의 비밀번호 (앱 비밀번호 사용 시)
    private static final String PASSWORD = "Kim168017**"; 

    // 이메일 전송 메서드
    public void sendEmail(String toEmail, String subject, String body) throws MessagingException {
        // 이메일 전송을 위한 프로퍼티 설정
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST); // SMTP 서버 호스트
        props.put("mail.smtp.port", PORT); // SMTP 서버 포트
        props.put("mail.smtp.auth", "true"); // 인증 필요
        props.put("mail.smtp.ssl.enable", "true"); // SSL 사용 설정

        // TLS를 사용할 경우의 설정 (포트 587을 사용할 때)
        // props.put("mail.smtp.starttls.enable", "true"); 
        // props.put("mail.smtp.ssl.enable", "false");

        // 세션 생성 및 인증 정보 설정
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 이메일과 비밀번호를 사용하여 인증
                return new PasswordAuthentication(EMAIL, PASSWORD);
            }
        });

        try {
            // MimeMessage 객체 생성
            MimeMessage message = new MimeMessage(session);
            // 발신자 설정
            message.setFrom(new InternetAddress(EMAIL));
            // 수신자 설정
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            // 제목 설정
            message.setSubject(subject);
            // 본문 설정 (HTML 형식)
            message.setContent(body, "text/html; charset=UTF-8");

            // 이메일 전송
            Transport.send(message);
            System.out.println("이메일 전송 성공");
        } catch (MessagingException e) {
            // 이메일 전송 실패 시 에러 메시지 출력
            System.err.println("이메일 전송 실패: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
