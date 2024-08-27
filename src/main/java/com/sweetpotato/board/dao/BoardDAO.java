package com.sweetpotato.board.dao;

import org.apache.ibatis.annotations.Insert;

import com.sweetpotato.board.vo.BoardVO;

public interface BoardDAO {

	
	/**
	 * 게시글 작성
	 * 
	 * @param BoardVO db에 등록할 게시글 정보
	 * @return 등록된 게시글 개수를 수로 반환
	 */
	@Insert("INSERT INTO board(memberno,boardcategory,boardprice,status,boardimg,boardtitle,boardcontent) VALUES(#{memberno}, #{boardcategory}, #{boardprice), #{status}, #{boardimg}, #{boardtitle}, #{boardcontent}")
	int create(BoardVO vo)throws Exception;
	
}
