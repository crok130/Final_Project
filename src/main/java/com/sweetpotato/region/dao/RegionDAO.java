package com.sweetpotato.region.dao;

import org.apache.ibatis.annotations.Update;

import com.sweetpotato.member.vo.MemberVO;

public interface RegionDAO {

	@Update("UPDATE member SET memberaddr = #{memberaddr} WHERE memberno = #{memberno}")
	void updateAddress(MemberVO member);

    
}