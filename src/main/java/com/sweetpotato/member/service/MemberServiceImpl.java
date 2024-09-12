package com.sweetpotato.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sweetpotato.member.dao.MemberDAO;
import com.sweetpotato.member.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    final private MemberDAO md;

    @Override
    public String register(MemberVO vo) throws Exception {
        int result = md.insertMember(vo);
        return (result == 1) ? "회원가입 성공" : "회원가입 실패";
    }

    @Override
    public String resetPasswordByIdAndEmail(String memberid, String memberemail, String newPassword) throws Exception {
        MemberVO member = md.findMemberByIdAndEmail(memberid, memberemail);
        if (member != null) {
            md.updateMemberPasswordByEmail(memberemail, newPassword); // 메서드 이름과 파라미터 수정
            return "비밀번호 변경 성공";
        } else {
            return "아이디 또는 이메일이 올바르지 않습니다.";
        }
    }

    @Override
    public String login(MemberVO vo) throws Exception {
        MemberVO result = md.login(vo);
        return (result != null) ? "로그인 성공" : "로그인 실패";
    }

	@Override
	public String resetpass(String memberpass) {
		return md.restpass(memberpass);
	}
}
