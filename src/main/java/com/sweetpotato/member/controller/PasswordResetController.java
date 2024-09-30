package com.sweetpotato.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sweetpotato.member.service.MemberService;
import com.sweetpotato.member.vo.MemberVO;

import lombok.RequiredArgsConstructor;

// 비밀번호 재설정을 처리하는 컨트롤러
@Controller
@RequiredArgsConstructor
public class PasswordResetController {

    // MemberService를 주입받는 필드
    private final MemberService ms;
    
    /**
     * 비밀번호 재설정 페이지 요청을 처리하는 메서드
     * @return 비밀번호 재설정 페이지의 JSP 파일 이름
     */
    @RequestMapping("/forgotPassword")
    public String forgotPasswordPage() {
        return "forgotPassword"; // 비밀번호 재설정 페이지의 JSP 파일 이름
    }
    
    /**
     * 비밀번호 재설정 요청을 처리하는 메서드
     * @param memberVO 비밀번호를 재설정할 회원의 정보를 담고 있는 MemberVO 객체
     * @param model 뷰로 전달할 데이터를 설정하는 Model 객체
     * @return 비밀번호 재설정 결과 페이지의 JSP 파일 이름
     */
    @PostMapping("/resetPassword")
    public String resetPassword(MemberVO memberVO, Model model) {
        try {
            String result = ms.resetPasswordByIdAndEmail(memberVO);
            // 비밀번호 재설정 성공 시
            return "redirect:/forgotPassword?message=success";
        } catch (Exception e) {
            e.printStackTrace();
            // 비밀번호 재설정 실패 시
            return "redirect:/forgotPassword?message=error";
        }
    }


}
