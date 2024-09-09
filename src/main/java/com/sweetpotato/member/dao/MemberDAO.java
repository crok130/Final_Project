package com.sweetpotato.member.dao;

import org.apache.ibatis.annotations.Insert;

import com.sweetpotato.member.vo.MemberVO;

public interface MemberDAO{
	// 회원가입
	@Insert("INSERT INTO member VALUES(null, #{memberid}, #{memberpass}, #{membername}, #{memberbirth}, #{memberphone}, #{memberemail}, #{memberaddr})")
	void insertMember(MemberVO member);
	
	// 이메일을 이용한 비밀번호 수정
	@Insert("UPDATE member"
			+ "SET memberpass = #{newPassword}"
			+ "WHERE memberemail = #{memberemail}")
	void updateMemberPasswordByEmail(String memberemail, String newPassword);
	
	// 로그인 처리 메소드
	@Insert("SELECT * FROM member"
			+ "WHERE memberid = #{memberid} AND memberpass = #{memberpass}")
	MemberVO login(MemberVO member);
}