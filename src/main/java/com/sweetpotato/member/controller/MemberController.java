package com.sweetpotato.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.sweetpotato.member.service.MemberService;
import com.sweetpotato.member.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	final private MemberService ms;
	@PostMapping("rig")
	
	public String register(MemberVO vo) throws Exception {
		String message = ms.register(vo);
		System.out.println(message);
		return "redirect:/login";
	}
}
