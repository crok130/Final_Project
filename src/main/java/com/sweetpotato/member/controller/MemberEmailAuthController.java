package com.sweetpotato.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.sweetpotato.util.EmailUtil;
import java.util.Random;

@RestController
public class MemberEmailAuthController {

    @Autowired
    private EmailUtil emailUtil;

    // 인증 코드 생성 메소드
    private String generateAuthCode() {
        Random random = new Random();
        StringBuilder authCode = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            authCode.append(random.nextInt(10)); // 6자리 숫자 생성
        }
        return authCode.toString();
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam("email") String email, HttpServletRequest request) {
        String authCode = generateAuthCode();
        
        // 세션에 인증코드 저장
        HttpSession session = request.getSession();
        session.setAttribute("authCode", authCode);

        // 이메일 전송 로직
        String subject = "고구마 마켓 회원가입 인증 코드 메일입니다.";
        String body = "인증 코드 번호 : " + authCode + "입니다.";
        try {
            emailUtil.sendEmail(email, subject, body);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @PostMapping("/verifyCode")
    public String verifyCode(@RequestParam("authCode") String authCode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionAuthCode = (String) session.getAttribute("authCode");

        // 세션의 인증 코드와 사용자가 입력한 인증 코드 비교
        if (sessionAuthCode != null && sessionAuthCode.equals(authCode)) {
            return "success";
        } else {
            return "fail";
        }
    }
}
