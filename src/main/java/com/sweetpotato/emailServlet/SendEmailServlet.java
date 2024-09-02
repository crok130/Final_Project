package com.sweetpotato.emailServlet;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sweetpotato.util.EmailUtil;

public class SendEmailServlet extends HttpServlet {

    private static final long serialVersionUID = -4771076768189211763L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String authCode = generateAuthCode();

        // 세션에 인증 코드를 저장합니다.
        request.getSession().setAttribute("authCode", authCode);

        // 이메일 제목 및 본문 설정
        String subject = "고구마 마켓 이메일 인증 코드";
        String body = "<!DOCTYPE html>"
            + "<html lang='ko'>"
            + "<head><meta charset='UTF-8'></head>"
            + "<body>"
            + "<p>안녕하세요,</p>"
            + "<p>고구마 마켓에 가입해 주셔서 감사합니다!</p>"
            + "<p>이메일 인증을 완료하시려면 아래의 인증 코드를 입력해 주세요:</p>"
            + "<p><strong>인증 코드: " + authCode + "</strong></p>"
            + "<p>이 인증 코드는 10분 동안 유효합니다. 만약 인증 코드가 만료되었거나 잘못된 경우, 다시 시도해 주세요.</p>"
            + "<h3>인증 코드 입력 방법</h3>"
            + "<ol>"
            + "<li>고구마 마켓 웹사이트로 돌아가셔서 가입 양식을 완성해 주세요.</li>"
            + "<li>위에서 제공한 인증 코드를 '인증 코드 입력'란에 입력해 주세요.</li>"
            + "<li>인증 코드 입력 후, 가입 절차를 완료하실 수 있습니다.</li>"
            + "</ol>"
            + "<p>문제가 있으시거나 도움이 필요하시면 언제든지 고객 지원팀(support@sweetpotato.com)으로 문의해 주세요.</p>"
            + "<p>감사합니다,<br>고구마 마켓 팀</p>"
            + "<hr>"
            + "<p>이 이메일은 자동으로 생성된 이메일입니다. 답장하실 수 없습니다.</p>"
            + "</body>"
            + "</html>";

        try {
            // 인증 코드를 이메일로 전송합니다.
            EmailUtil.sendEmail(email, subject, body);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("이메일이 성공적으로 전송되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("이메일 전송에 실패했습니다. 다시 시도해 주세요.");
        }
    }

    private String generateAuthCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }
}
