package com.sweetpotato.member.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sweetpotato.util.EmailUtil;

// 이메일 인증을 처리하는 서블릿
@WebServlet("/sendEmail")
public class EmailAuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SUBJECT = "고구마 마켓 회원가입 인증 코드입니다"; // 이메일 제목

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트로부터 전달받은 이메일 주소
		String email = request.getParameter("memberemail");

		if (email != null && !email.isEmpty()) {
			// 6자리 랜덤 인증 코드 생성
			String authCode = String.format("%06d", new Random().nextInt(1000000));
			String body = "본 메일은 고구마 마켓 회원가입 인증 메일입니다. \n회원가입 인증 코드: " + authCode
					+ "입니다.\n 가입을 진심으로 환영합니다.\n 인증코드를 코드란에 입력 후 인증버튼을 눌러주세요.";

			try {
				// EmailUtil 객체를 생성하여 이메일 전송
				EmailUtil emailUtil = new EmailUtil();
				emailUtil.sendEmail(email, SUBJECT, body);

				// 생성한 인증 코드를 세션에 저장하여 후속 검증에 사용
				request.getSession().setAttribute("authCode", authCode);

				// 이메일 전송 성공 응답
				response.getWriter().write("success");
			} catch (Exception e) {
				// 이메일 전송 실패 응답
				response.getWriter().write("failure");
			}
		} else {
			// 이메일 주소가 null이거나 빈 문자열일 경우 실패 응답
			response.getWriter().write("failure");
		}
	}
}
