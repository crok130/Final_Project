package com.sweetpotato.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    // 회원가입 처리
    @PostMapping("reg")
    public String register(MemberVO vo) throws Exception {
        String message = ms.register(vo);
        System.out.println(message);
        return "redirect:/login";
    }

    // 로그인 페이지 요청
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    
    // 로그인 처리
    @PostMapping("login")
    public String login(MemberVO memberVO, Model model) {
    	try {
    		// 로그인 시도
    		String result = ms.login(memberVO);
    		model.addAttribute("message", result);
    		if("로그인 성공".equals(result)) {
    			// 로그인 성공 시 이동할 페이지
    			return "redirect:/main"; // 실제 로그인 후 이동할 페이지 경로로 변경
    		}else {
    			// 로그인 실패 시 로그인 페이지로 이동
    			return "login";
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		model.addAttribute("message", "로그인 처리 중 오류가 발생했습니다.");
    		return "login";
    	}
    }

    // 회원가입 페이지 요청
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    // 프로필 페이지 요청
    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile() {
        return "profile";
    }

    // 마이페이지 요청
    @RequestMapping(value = "mypage", method = RequestMethod.GET)
    public String mypage() {
        return "mypage";
    }

    // 비밀번호 재설정 페이지 요청
    @RequestMapping(value = "passwordResetPage", method = RequestMethod.GET)
    public String passwordResetPage() {
        return "passwordResetPage"; // 비밀번호 재설정 페이지의 JSP 파일 이름
    }
}
