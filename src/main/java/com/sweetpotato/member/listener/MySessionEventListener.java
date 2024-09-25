package com.sweetpotato.member.listener;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sweetpotato.member.vo.MemberVO;


/**
 *	HttpSessionListener - HttpSession 객체 생성, 제거 될때 발생하는 이벤트 감지.
 */
public class MySessionEventListener implements HttpSessionListener, HttpSessionAttributeListener{
	
	public static Hashtable<String, Object> sessionRepository;
	
	
	static {
		sessionRepository = new Hashtable<>();
		System.out.println("정적블럭");
	}
	
	{
		System.out.println("실행블럭");
	}
	
	public MySessionEventListener() {
		System.out.println("MySessionEventListener 생성자 호출");
	}

	/**
	 *  session에 속성 값 추가
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("attributeAdded 호출");
		HttpSession session = event.getSession();
		System.out.printf("SESSION ID : %s %n", session.getId());
		System.out.printf("SESSION add : name : %s, value : %s %n", event.getName(),event.getValue());
		if(event.getName().equals("userInfo")) {
			MemberVO newUser = (MemberVO)event.getValue();
			
			Enumeration<Object> enumeration = sessionRepository.elements();
			while(enumeration.hasMoreElements()) {
				HttpSession ses = (HttpSession)enumeration.nextElement();
				MemberVO user = (MemberVO)ses.getAttribute("userInfo");
				// repository에 저장된 기존에 로그인한 사용자와
				// 새로 로그인하려는 사용자의 u_id값 비교
				if(user != null && user.getMemberid().equals(newUser.getMemberid())) {
					// 중복 로그인 사용자
					// ses.removeAttribute("userInfo");
					ses.setAttribute("expire", "중복로그인으로 로그아웃됩니다.");
				}
			}
			sessionRepository.put(session.getId(), session);
		}
	}

	/**
	 * session에서 속성값 삭제
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("attributeRemoved 호출");
		HttpSession session = event.getSession();
		System.out.printf("SESSION ID : %s %n", session.getId());
		System.out.printf("SESSION remove : name : %s, value : %s %n", event.getName(),event.getValue());
		if(event.getName().equals("userInfo")) {
			sessionRepository.remove(session.getId());
		}
	}

	/**
	 * session에서 속성 값 변경
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("attributeReplaced 호출");
		HttpSession session = event.getSession();
		System.out.printf("SESSION ID : %s %n", session.getId());
		System.out.printf("SESSION replace : name : %s, value : %s %n", event.getName(),event.getValue());
	}

	/**
	 * 사용자가 브라우저를 통해서 최초에 연결요청을 전달하여
	 * Session 객체가 생성되거나 기존의 session 객체가 invalidate(무효화)
	 * 또는 timeout으로 제거 되었을 때 새로 생성된 Session 정보와 함께 
	 * WAS에 의해서 호출되는 method
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.printf("생성된 SESSIONID %s %n", session.getId());
	}

	/**
	 * HttpSession 객체가 timeout 또는 invalidate() 무효화 
	 * 되었을 때 호출되는 method
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.printf("제거된 SESSION ID %s %n", session.getId());
		sessionRepository.remove(session.getId());
	}
	
	
}



