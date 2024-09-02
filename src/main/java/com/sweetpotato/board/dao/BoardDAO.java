package com.sweetpotato.board.dao;

import org.apache.ibatis.annotations.Insert;
import com.sweetpotato.board.vo.BoardVO;

public interface BoardDAO {

    @Insert("INSERT INTO board(memberno,main_category,sub_category,price,img,title,content,region) " +
            "VALUES(1, #{main_category}, #{sub_category}, #{price}, #{img}, #{title}, #{content}, #{region})")
    int create(BoardVO vo) throws Exception;

}
