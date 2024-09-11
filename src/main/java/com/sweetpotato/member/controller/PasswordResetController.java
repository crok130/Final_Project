package com.sweetpotato.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sweetpotato.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PasswordResetController {

    private final MemberService ms;
    
    // 비밀번호 재설정 페이지 요청 처리
    @RequestMapping("/forgotPassword")
    public String forgotPasswordPage() {
        return "forgotPassword"; // 비밀번호 재설정 페이지의 JSP 파일명
    }

    // 비밀번호 재설정 요청 처리
    @PostMapping("/resetPassword")
    @ResponseBody
    public String resetPassword(@RequestParam("membername") String membername, 
                                @RequestParam("memberemail") String memberemail, 
                                @RequestParam("newPassword") String newPassword) {
        try {
            String result = ms.resetPasswordByEmailAndId(membername, memberemail, newPassword);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "비밀번호 재설정 중 오류가 발생했습니다.";
        }
    }
}
