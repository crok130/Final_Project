package com.sweetpotato.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이메일 인증 코드 검증을 처리하는 서블릿
@WebServlet("/verifyCode")
public class EmailVerifyController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트로부터 입력받은 인증 코드
        String inputCode = request.getParameter("authCode");
        // 세션에서 저장된 인증 코드
        String sessionCode = (String) request.getSession().getAttribute("authCode");
        
        // 입력받은 인증 코드와 세션의 인증 코드 비교
        if (inputCode != null && inputCode.equals(sessionCode)) {
            // 인증 코드가 일치하면 성공 응답
            response.getWriter().write("success");
        } else {
            // 인증 코드가 일치하지 않거나 입력이 null인 경우 실패 응답
            response.getWriter().write("failure");
        }
    }
}
