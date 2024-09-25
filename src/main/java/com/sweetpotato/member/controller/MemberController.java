package com.sweetpotato.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public String login(MemberVO memberVO, Model model, HttpSession session, HttpServletResponse response) {
        try {
            // 로그인 시도
            MemberVO result = ms.login(memberVO);
            model.addAttribute("message", result);
            if (result != null) {
                // 로그인 성공 시 세션에 사용자 정보 저장
                session.setAttribute("userInfo", result); // 필요에 따라 더 많은 정보를 저장 가능

                // 자동 로그인 체크 시 쿠키 설정
                if (memberVO.isRememberMe()) { // 자동 로그인 체크박스의 상태 확인
                    Cookie loginCookie = new Cookie("memberid", result.getMemberid());
                    loginCookie.setMaxAge(60 * 60 * 24 * 30); // 30일 동안 유지
                    response.addCookie(loginCookie);
                }

                return "redirect:/main"; // 실제 로그인 후 이동할 페이지 경로로 변경
            } else {
                // 로그인 실패 시 로그인 페이지로 이동
                return "login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "로그인 처리 중 오류가 발생했습니다.");
            return "login";
        }
    }


    // 로그아웃 처리
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
    	// 세션 무효화
    	session.invalidate();
    	return "redirect:/login"; // 로그아웃 후 로그인 페이지로 이동
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
    public String mypage(Model model, HttpSession session) {
        // 세션에서 사용자 정보를 가져옵니다.
        MemberVO userInfo = (MemberVO) session.getAttribute("userInfo");

        // userInfo가 null이 아닐 경우에만 모델에 추가합니다.
        if (userInfo != null) {
            // model.addAttribute("userInfo", userInfo); // 모델에 사용자 정보 추가
            return "mypage"; // JSP 파일명
        } else {
            // 사용자가 로그인하지 않았을 경우 처리할 로직을 추가할 수 있습니다.
            // 예: 로그인 페이지로 리다이렉트
            return "redirect:/login"; // 로그인 페이지로 리다이렉트
        }
    }

    // 비밀번호 재설정 페이지 요청
    @RequestMapping(value = "passwordResetPage", method = RequestMethod.GET)
    public String passwordResetPage() {
        return "passwordResetPage"; // 비밀번호 재설정 페이지의 JSP 파일 이름
    }

}
