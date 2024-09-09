package com.sweetpotato.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

import com.sweetpotato.member.dao.MemberDAO;
import com.sweetpotato.member.vo.MemberVO;
import com.sweetpotato.util.MyBatisUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private MemberDAO memberDAO;

    @Override
    public void init() throws ServletException {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        memberDAO = sqlSessionFactory.openSession().getMapper(MemberDAO.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberId = request.getParameter("memberid");
        String memberPass = request.getParameter("memberpass");

        MemberVO member = new MemberVO();
        member.setMemberid(memberId);
        member.setMemberpass(memberPass);

        MemberVO loggedInMember = memberDAO.login(member);

        if (loggedInMember != null) {
            // 로그인 성공
            response.sendRedirect("main.jsp");
        } else {
            // 로그인 실패
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}
