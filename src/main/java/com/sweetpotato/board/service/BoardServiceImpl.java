package com.sweetpotato.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sweetpotato.board.dao.BoardDAO;
import com.sweetpotato.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardDAO dao;
	
	@Override
	public String regist(BoardVO vo) throws Exception {
		int result = dao.create(vo);
		String message = (result == 1) ? "SUCCESS" : "FAILED";
		return message;
	}

	@Override
	public void updateCnt(int boardno) throws Exception {
		
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public BoardVO read(int boardno) throws Exception {
		return dao.read(boardno);
	}
	


}
