package com.sweetpotato.member.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sweetpotato.member.vo.MemberVO;

public interface MemberDAO {

    /**
     * 회원가입을 처리하는 메서드
     * @param member 회원 정보가 담긴 MemberVO 객체
     * @return 삽입된 행의 수
     */
    @Insert("INSERT INTO member(" +
            "memberid, memberpass, membername, memberphone, memberbirth, memberemail, memberaddr" +
            ") VALUES (" +
            "#{memberid}, #{memberpass}, #{membername}, #{memberphone}, #{memberbirth}, #{memberemail}, #{memberaddr})")
    int insertMember(MemberVO member);

    /**
     * 이메일을 사용하여 비밀번호를 업데이트하는 메서드
     * @param memberemail 회원의 이메일
     * @param newPassword 새 비밀번호
     */
    @Update("UPDATE member SET memberpass = #{newPassword} WHERE memberemail = #{memberemail}")
    void updateMemberPasswordByEmail(@Param("memberemail") String memberemail, @Param("newPassword") String newPassword);

    /**
     * 아이디와 이메일을 사용하여 회원 정보를 조회하는 메서드
     * @param memberid 회원의 아이디
     * @param memberemail 회원의 이메일
     * @return 일치하는 회원 정보를 담고 있는 MemberVO 객체
     */
    @Select("SELECT * FROM member WHERE memberid = #{memberid} AND memberemail = #{memberemail}")
    MemberVO findMemberByIdAndEmail(@Param("memberid") String memberid, @Param("memberemail") String memberemail);

    /**
     * 로그인 처리를 위한 메서드
     * @param member 로그인 시도할 회원의 아이디와 비밀번호를 담고 있는 MemberVO 객체
     * @return 로그인 성공 시 일치하는 회원 정보를 담고 있는 MemberVO 객체
     */
    @Select("SELECT * FROM member WHERE memberid = #{memberid} AND memberpass = #{memberpass}")
    MemberVO login(@Param("memberid") String memberid, @Param("memberpass") String memberpass) throws Exception;
}
