package com.sweetpotato.chat.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

public class UserChatHandler extends TextWebSocketHandler {

    private final Map<Integer, WebSocketSession> sessionMap = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Integer memberno = (Integer) session.getAttributes().get("memberno");
        sessionMap.put(memberno, session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Integer memberno = (Integer) session.getAttributes().get("memberno");
        System.out.println("1 : " +memberno);
        String msg = message.getPayload();
        
        // 메시지를 보낸 사용자에게 전달
        sessionMap.values().forEach(ses -> {
            try {
                ses.sendMessage(new TextMessage(msg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        // Messages 테이블에 메시지 저장 로직 추가
        // chatService.saveMessage(chatId, memberno, msg);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Integer memberno = (Integer) session.getAttributes().get("memberno");
        sessionMap.remove(memberno);
    }
}
