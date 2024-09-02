package com.sweetpotato.emailServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyCodeServlet extends HttpServlet{

	private static final long serialVersionUID = 4305352363575863722L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String authCode = request.getParameter("authCode");
		String sessionAuthCode = (String) request.getSession().getAttribute("authCode");
		
		if(authCode != null && authCode.equals(sessionAuthCode)) {
			response.getWriter().write("success");
		}else {
			response.getWriter().write("fail");
		}
	}
}
