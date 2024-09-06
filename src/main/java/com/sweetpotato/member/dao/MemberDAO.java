package com.sweetpotato.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sweetpotato.member.vo.MemberVO;
import com.sweetpotato.util.MyBatisUtil;

public class MemberDAO{
	private SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
	
	// 이메일 존재 여부 확인
	public boolean emailExists(String email) {
		try(SqlSession session = sqlSessionFactory.openSession()){
			return session.selectOne("com.sweetpotato.member.dao.MemberMapper.emailExists", email);
		}
	}
	
	// 회원 아이디로 비밀번호 업데이트
	public boolean updatePasswordByUserId(MemberVO member) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int rowsUpdated = session.update("com.sweetpotato.member.dao.MemberMapper.updatePasswordByUserId", member);
            session.commit();
            return rowsUpdated > 0;
        }
    }
	
	// 회원정보 조회
	public MemberVO getMemberById(String memberId) {
		try(SqlSession session = sqlSessionFactory.openSession()){
			return session.selectOne("com.sweetpotato.member.dao.MemberMapper.getMemberById", memberId);
		}
	}
	
	// 회원 정보 추가
    public void addMember(MemberVO member) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.sweetpotato.member.dao.MemberMapper.addMember", member);
            session.commit();
        }
    }
    
    // 회원 정보 수정
    public void updateMember(MemberVO member) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("com.sweetpotato.member.dao.MemberMapper.updateMember", member);
            session.commit();
        }
    }
}