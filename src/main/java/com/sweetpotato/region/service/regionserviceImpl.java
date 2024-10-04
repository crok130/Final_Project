package com.sweetpotato.region.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetpotato.member.vo.MemberVO;
import com.sweetpotato.region.dao.RegionDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class regionserviceImpl implements regionservice{

    
    final private RegionDAO dao;

	@Override
	public void updateMemberAddress(MemberVO member) {
		dao.updateAddress(member);
		
	}
	

}
