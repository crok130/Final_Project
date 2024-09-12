package com.sweetpotato.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verifyCode")
public class EmailVerifyController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String inputCode = request.getParameter("authCode");
		String sessionCode = (String) request.getSession().getAttribute("authCode");
		
		if(inputCode != null && inputCode.equals(sessionCode)) {
			response.getWriter().write("success");
		}else {
			response.getWriter().write("faliure");
		}
	}

}
