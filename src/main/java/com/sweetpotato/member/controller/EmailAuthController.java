package com.sweetpotato.member.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sweetpotato.util.EmailUtil;

@WebServlet("/sendEmail")
public class EmailAuthController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String SUBJECT = "회원가입 인증 코드";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("memberemail");
        
        if (email != null && !email.isEmpty()) {
            // Generate a random 6-digit code
            String authCode = String.format("%06d", new Random().nextInt(1000000));
            String body = "회원가입 인증 코드: " + authCode;
            
            try {
                EmailUtil emailUtil = new EmailUtil();
                emailUtil.sendEmail(email, SUBJECT, body);

                // Store the code in the session for verification
                request.getSession().setAttribute("authCode", authCode);

                response.getWriter().write("success");
            } catch (Exception e) {
                response.getWriter().write("failure");
            }
        } else {
            response.getWriter().write("failure");
        }
    }
}
