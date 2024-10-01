package com.sweetpotato.chat.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sweetpotato.chat.vo.ChatVO;


public interface ChatDAO {

    
	@Select("SELECT COUNT(*) FROM Chats WHERE memberno1 = #{memberno1} AND memberno2 = #{memberno2} AND boardno = #{boardno}")
	int countExistingChat(ChatVO vo);
	
    @Insert("INSERT INTO Chats (memberno1, memberno2, boardno) VALUES (#{memberno1}, #{memberno2}, #{boardno})")
    String createChat(ChatVO vo) throws Exception;

    @Insert("INSERT INTO Messages (chat_id, sender_id, content) VALUES (#{chatId}, #{senderId}, #{content})")
    void saveMessage(int chatId, int senderId, String content);
}
