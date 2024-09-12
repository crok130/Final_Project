package com.sweetpotato.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sweetpotato.member.service.MemberService;
import com.sweetpotato.member.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	final private MemberService ms;
	@PostMapping("reg")
	public String register(MemberVO vo) throws Exception {
		String message = ms.register(vo);
		System.out.println(message);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile() {
		return "profile";
	}
	
	
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public String mypage() {
		return "mypage";
	}
	
	@PostMapping("resetPassword")
		public String resetPassword(String memberpass){
			ms.resetpass(memberpass);
			return "resetPassword";
		}
	
}
