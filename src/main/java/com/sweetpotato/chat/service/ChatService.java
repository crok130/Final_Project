package com.sweetpotato.chat.service;

import org.springframework.stereotype.Service;

import com.sweetpotato.chat.dao.ChatDAO;
import com.sweetpotato.chat.vo.ChatVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

    
    final private ChatDAO dao;

    public void createChatRoom(ChatVO vo)throws Exception {
        int count = dao.countExistingChat(vo);
        if (count == 0) {
            dao.createChat(vo);
        } else {
            // 이미 존재하는 경우의 처리 (예: 예외 던지기, 메시지 반환 등)
            System.out.println("채팅방이 이미 존재합니다.");
        }
    }

    
    public void saveMessage(int chatId, int senderId, String content) {
        // 메시지 저장 로직
        dao.saveMessage(chatId, senderId, content);
    }
}
