package com.sweetpotato.member.service;

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
		String message = (result == 1) ? "회원가입 성공" : "회원가입 실패";
		return message;
	}
	
	


	

}
