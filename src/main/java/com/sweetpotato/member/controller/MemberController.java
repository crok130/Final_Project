package com.sweetpotato.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("login")
    public String login() {
        return "login";
    }
    
    // 로그인 처리
    @PostMapping("login")
    public String login(MemberVO memberVO, Model model, HttpSession session, HttpServletResponse response) {
        try {
            // 로그인 시도
            MemberVO result = ms.login(memberVO);
            if (result == null) {
                model.addAttribute("message", "로그인 실패: 잘못된 아이디 또는 비밀번호입니다.");
                return "login";
            }

            // 로그인 성공 : 세션에 사용자 정보 저장
            session.setAttribute("userInfo", result);

            // 자동 로그인 체크 시 쿠키 설정
            if (memberVO.isRememberMe()) {
                Cookie loginCookie = new Cookie("memberid", result.getMemberid());
                loginCookie.setMaxAge(60 * 60 * 24 * 30); // 30일 동안 유지
                response.addCookie(loginCookie);
            }

            return "redirect:/main"; // 로그인 후 이동할 페이지
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "로그인 처리 중 오류가 발생했습니다.");
            return "login";
        }
    }

    // 로그아웃 처리
    @GetMapping("logout")
    public String logout(HttpSession session) {
        // 세션 무효화 처리
        session.invalidate();
        return "redirect:/login"; // 로그아웃 후 로그인 페이지로 이동
    }
    
    // 회원가입 페이지 요청
    @GetMapping("register")
    public String register() {
        return "register";
    }

    // 프로필 페이지 요청
    @GetMapping("profile")
    public String profile() {
        return "profile";
    }


    // 비밀번호 재설정 페이지 요청
    @GetMapping("passwordResetPage")
    public String passwordResetPage() {
        return "passwordResetPage"; // 비밀번호 재설정 페이지의 JSP 파일 이름
    }
}
