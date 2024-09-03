package com.sweetpotato.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sweetpotato.board.vo.BoardVO;

public interface BoardDAO {

    @Insert("INSERT INTO board(memberno,main_category,sub_category,price,img,title,content,region) " +
            "VALUES(1, #{main_category}, #{sub_category}, #{price}, #{img}, #{title}, #{content}, #{region})")
    int create(BoardVO vo) throws Exception;

	/**
	 * 전체 게시글 목록
	 * 
	 * @return - 조회된 전체 게시글 목록
	 */
	@Select("SELECT * FROM board ORDER BY boardno DESC")
	List<BoardVO> listAll() throws Exception;
    
}
