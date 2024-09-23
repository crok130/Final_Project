package com.sweetpotato.member.service;

import org.springframework.stereotype.Service;
import com.sweetpotato.member.dao.MemberDAO;
import com.sweetpotato.member.vo.MemberVO;

import lombok.RequiredArgsConstructor;

// MemberService 인터페이스의 구현 클래스
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    // MemberDAO를 주입받기 위한 필드
    final private MemberDAO md;

    // 회원가입 처리
    @Override
    public String register(MemberVO vo) throws Exception {
        // MemberDAO를 사용하여 회원 정보를 데이터베이스에 삽입
        int result = md.insertMember(vo);
        // 삽입 결과에 따라 성공 또는 실패 메시지 반환
        return (result == 1) ? "회원가입 성공" : "회원가입 실패";
    }

    // 비밀번호 재설정 처리
    @Override
    public String resetPasswordByIdAndEmail(MemberVO memberVO) throws Exception {
        // 주어진 아이디와 이메일로 회원 정보를 조회
        MemberVO member = md.findMemberByIdAndEmail(memberVO.getMemberid(), memberVO.getMemberemail());
        if (member != null) {
            // 회원이 존재하면 비밀번호를 업데이트
            md.updateMemberPasswordByEmail(memberVO.getMemberemail(), memberVO.getMemberpass());
            return "비밀번호 변경 성공";
        } else {
            // 회원이 존재하지 않으면 오류 메시지 반환
            return "아이디 또는 이메일이 올바르지 않습니다.";
        }
    }

    // 로그인 처리
    @Override
    public MemberVO login(MemberVO vo) throws Exception {
        // MemberVO 객체에서 memberid와 memberpass 값을 추출
        MemberVO result = md.login(vo.getMemberid(), vo.getMemberpass());
        // 로그인 결과에 따라 성공 또는 실패 메시지 반환
        return result;
    }

}
