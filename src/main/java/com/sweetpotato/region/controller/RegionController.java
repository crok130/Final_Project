package com.sweetpotato.region.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweetpotato.member.vo.MemberVO;
import com.sweetpotato.region.service.regionservice;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegionController {

    
    final private regionservice reg;

    @PostMapping("set_region_certification")
    public String setRegionCertification(@RequestParam("simplifiedCurrentLocation") String simplifiedCurrentLocation, HttpSession session) {
        // 세션에서 로그인한 유저 정보 가져오기
        MemberVO userInfo = (MemberVO) session.getAttribute("userInfo");

        // 사용자가 입력한 지역 설정
        userInfo.setMemberaddr(simplifiedCurrentLocation);
        // DB에 업데이트
        reg.updateMemberAddress(userInfo);

        return "main"; // 인증 후 리다이렉트 페이지
    }
}
