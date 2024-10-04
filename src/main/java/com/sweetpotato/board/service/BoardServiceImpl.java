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
	public void regist(BoardVO vo) throws Exception {
		dao.create(vo);
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

	@Override
	public List<BoardVO> searchlist(String search) {
	    return dao.searchlist(search);
	}

	@Override
	public void delete(int boardno) {
		dao.delete(boardno);
		
	}

	
	
	@Override
	       
	public void update(BoardVO vo) throws Exception{
		dao.update(vo);
		
	}


	@Override
	public List<BoardVO> getBoardsByMemberno(int memberno) {
		return dao.selectList(memberno);
	}
	
	


}