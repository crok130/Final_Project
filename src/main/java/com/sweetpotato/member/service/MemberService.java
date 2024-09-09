package com.sweetpotato.member.service;

import org.apache.ibatis.session.SqlSession;

import com.sweetpotato.member.dao.MemberDAO;
import com.sweetpotato.member.vo.MemberVO;

public class MemberService {
	private SqlSession sqlSession;
	private MemberDAO memberDAO;
	
	public MemberService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		this.memberDAO = sqlSession.getMapper(MemberDAO.class);
	}
	
	// 회원가입
	public void registerMember(MemberVO member) {
		memberDAO.insertMember(member);
	}
	
	// 이메일을 통한 비밀번호 재설정
	public void resetPasswordByEmail(String memberemail, String newPassword) {
		memberDAO.updateMemberPasswordByEmail(memberemail, newPassword);
	}
}
