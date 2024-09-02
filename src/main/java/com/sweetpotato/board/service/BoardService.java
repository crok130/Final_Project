package com.sweetpotato.board.service;

import com.sweetpotato.board.vo.BoardVO;

public interface BoardService {
	/**
	 * 게시글 작성 - 성공 유무에 따라 메세지 전달
	 * 
	 * @param 게시글 등록 정보
	 * @return 성공 유무 메세지
	 */
	String regist(BoardVO board) throws Exception;

	/**
	 * 조회수 증가
	 * 
	 * @param bno 조회수 증가 시킬 게시글 번호
	 */
	void updateCnt(int bno) throws Exception;
}
