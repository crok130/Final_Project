package com.sweetpotato.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweetpotato.member.service.MemberService;
import com.sweetpotato.member.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PasswordResetController {

    private final MemberService ms;
    
    // 비밀번호 재설정 페이지 요청 처리
    @RequestMapping("/forgotPassword")
    public String forgotPasswordPage() {
    	return "forPassword";
    }
    
    // 비밀번호 재설정 요청 처리
    @PostMapping("/resetPassword")
    public String resetPassword(MemberVO vo,@RequestParam("memberid") String memberid, @RequestParam("memberemail") String memberemail, @RequestParam("newPassword") String newPassword, Model model) {
    	try {
    		String result = ms.resetPasswordByIdAndEmail(memberid, memberemail, newPassword);
    		model.addAttribute("message", result);
    		return "resetPasswordResult";
    	}catch(Exception e) {
    		e.printStackTrace();
    		model.addAttribute("message", "비밀번호 재설정 중 오류가 발생했습니다.");
    		return "resetPasswordResult";
    	}
    }
}
