package com.sweetpotato.member.service;


import com.sweetpotato.member.vo.MemberVO;

public interface MemberService {

    // 회원가입
    String register(MemberVO vo) throws Exception;

    // 이메일과 아이디를 통한 비밀번호 재설정
    String resetPasswordByIdAndEmail(MemberVO memberVO) throws Exception;

    // 로그인
    MemberVO login(MemberVO vo) throws Exception;
    
    // memberid 사용자 아이디로 사용자 정보 검색
    MemberVO getMemberById(String memberid) throws Exception;

}
