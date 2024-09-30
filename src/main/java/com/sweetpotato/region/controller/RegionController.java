package com.sweetpotato.region.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("region")
public class RegionController {

    // POST 요청을 받아 동네 정보를 세션에 저장
    @PostMapping("set_region")
    public String setRegion(@RequestParam("region-setting") String regionSetting, HttpSession session) {
        // 지역 설정 값을 세션에 저장
        session.setAttribute("region", regionSetting);
        
        // 처리 후 다시 원래 페이지로 리다이렉트
        return "redirect:/location";  // "region" 페이지는 지역 설정 화면입니다.
    }

    // 필요 시 세션 초기화 (예를 들어 인증 후 초기화)
    @PostMapping("/clear_region")
    public String clearRegion(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/location";
    }
}

