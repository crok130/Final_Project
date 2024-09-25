package com.sweetpotato.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class DuplicateLoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
     
        // 세션에 userInfo가 있는 경우, 이미 로그인한 상태
        if(session.getAttribute("userInfo") != null) {
        	// 경고 메시지를 세션에 저장
        	session.setAttribute("alertMessage", "이미 로그인 중입니다.");
        	// 로그인 페이지로 리다이렉트
        	response.sendRedirect(request.getContextPath() + "login");
        	return false; // 요청 처리 중단
        }
        return true; // 요청 처리 계속 진행
	}
}
