package com.sweetpotato.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sweetpotato.board.vo.BoardVO;
import com.sweetpotato.util.Criteria;



public interface BoardDAO {

    @Insert("INSERT INTO board(memberno,main_category,sub_category,price,img,title,content,region) " +
            "VALUES(#{memberno}, #{main_category}, #{sub_category}, #{price}, #{img}, #{title}, #{content}, #{region})")
    int create(BoardVO vo) throws Exception;

	/**
	 * 전체 게시글 목록
	 * 
	 * @return - 조회된 전체 게시글 목록
	 */
	@Select("SELECT * FROM board ORDER BY boardno DESC")
	List<BoardVO> listAll() throws Exception;
	
	/**
	 * 게시글 상세보기
	 * 
	 * @param bno - 상세보기할 게시글 번호
	 * @return - 조회된 게시글 정보를 BoardVO 타입으로 반환
	 */
	@Select("SELECT * FROM board WHERE boardno = #{boardno}")
	BoardVO read(int boardno) throws Exception;

	
	@Select("SELECT * FROM board WHERE title LIKE CONCAT('%', #{search}, '%')")
	List<BoardVO> searchlist(String search);

	@Delete("DELETE FROM board WHERE boardno = #{boardno}")
	void delete(int boardno);

	@Select("SELECT * FROM board ORDER BY boardno DESC LIMIT #{limit} OFFSET #{offset}")
	List<BoardVO> listAllWithPaging(int offset, int limit) throws Exception;

	
    @Update("UPDATE board SET title = #{title}, price = #{price}, content = #{content}, region = #{region}, img = #{img} WHERE boardno = #{boardno}")
    void update(BoardVO vo) throws Exception;

    @Select("SELECT * FROM board WHERE memberno = #{memberno}")
	List<BoardVO> selectList(int memberno);


    
}