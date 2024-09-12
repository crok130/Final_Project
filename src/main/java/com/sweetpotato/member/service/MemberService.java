package com.sweetpotato.member.service;

import java.util.List;

import com.sweetpotato.member.vo.MemberVO;

public interface MemberService {

    // 회원가입
    String register(MemberVO vo) throws Exception;

    // 이메일과 아이디를 통한 비밀번호 재설정
    String resetPasswordByIdAndEmail(String memberid, String memberemail, String newPassword) throws Exception;

    // 로그인
    String login(MemberVO vo) throws Exception;

	String resetpass(String memberpass);
}
