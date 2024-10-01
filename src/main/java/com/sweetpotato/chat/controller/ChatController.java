package com.sweetpotato.chat.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sweetpotato.chat.service.ChatService;
import com.sweetpotato.chat.vo.ChatVO;
import com.sweetpotato.member.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {
	   
	final private ChatService chatService;

    @GetMapping("/chat")
    public String chat(@RequestParam int boardno,@RequestParam int memberno ,HttpSession session, Model model) throws Exception {
        // 로그인한 사용자 정보를 가져옵니다.
        MemberVO userInfo = (MemberVO) session.getAttribute("userInfo"); // userInfo 세션에서 MemberVO를 가져옵니다.
        int currentMemberNo = userInfo.getMemberno();
        
        model.addAttribute("currentTime", new Date());
        
        ChatVO vo = new ChatVO(memberno, currentMemberNo, boardno);
        
        chatService.createChatRoom(vo); // 채팅방 생성
        return "chat"; // chat.jsp로 포워딩
    }
}
