package com.sweetpotato.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sweetpotato.member.vo.MemberVO;

public interface MemberDAO {

    // 회원가입
    @Insert("INSERT INTO member VALUES(null, #{memberid}, #{memberpass}, #{membername}, #{memberbirth}, #{memberphone}, #{memberemail}, #{memberaddr})")
    int insertMember(MemberVO member);

    // 이메일을 이용한 비밀번호 수정
    @Update("UPDATE member SET memberpass = #{newPassword} WHERE memberemail = #{memberemail}")
    void updateMemberPasswordByEmail(@Param("memberemail") String memberemail, @Param("newPassword") String newPassword);

    // 아이디와 이메일로 회원 조회
    @Select("SELECT * FROM member WHERE memberid = #{memberid} AND memberemail = #{memberemail}")
    MemberVO findMemberByIdAndEmail(@Param("memberid") String memberid, @Param("memberemail") String memberemail);

    // 로그인 처리 메서드
    @Select("SELECT * FROM member WHERE memberid = #{memberid} AND memberpass = #{memberpass}")
    MemberVO login(MemberVO member);
    
    @Update("SELECT * FROM member memberpass = #{memberpass} WHERE meberid = #{memberid}")
	String restpass(String memberpass);
}
