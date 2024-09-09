package com.sweetpotato.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.sweetpotato.member.dao.MemberDAO;
import com.sweetpotato.util.EmailUtil;
import com.sweetpotato.util.MyBatisUtil;

import jakarta.mail.MessagingException;

@WebServlet("/passwordReset")
public class PasswordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// POST방식으로 비밀번호 재설정 링크 발송 또는 비밀번호 재설정 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("sendLink".equals(action)) {
			sendResetLink(request, response);
		} else if ("resetPassword".equals(action)) {
			resetPassword(request, response);
		} else {
			response.sendRedirect("login.jsp?message=invalidAction");
		}
	}

	// 비밀번호 재설정 링크 발송 처리
	private void sendResetLink(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");

		// 비밀번호 재설정 링크 생성
		String resetLink = "http://localhost:8080/resetPassword.jsp?email=" + email;
		String subject = "비밀번호 재설정 링크";
		String body = "비밀번호 재설정을 위해 아래 링크를 클릭하세요:\n" + resetLink;

		try {
			// EmailUtil을 사용해 이메일 전송
			EmailUtil.sendEmail(email, subject, body);

			// 성공 메시지 처리
			response.sendRedirect("login.jsp?message=resetLinkSent");
		} catch (MessagingException e) {
			e.printStackTrace();
			// 실패 메시지 처리
			response.sendRedirect("login.jsp?error=emailSendFailed");
		}
	}

	// 비밀번호 재설정 처리
	private void resetPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!newPassword.equals(confirmPassword)) {
			response.sendRedirect("resetPassword.jsp?error=PasswordsDoNotMatch&email=" + email);
			return;
		}

		// 비밀번호 업데이트 로직
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		memberDAO.updateMemberPasswordByEmail(email, newPassword);
		sqlSession.commit();
		sqlSession.close();

		response.sendRedirect("login.jsp?message=passwordResetSuccess");
	}

}
