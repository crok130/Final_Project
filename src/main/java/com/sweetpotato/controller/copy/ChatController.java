package com.sweetpotato.controller.copy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;

@Controller
public class ChatController {

    @GetMapping("/chat")
    public String chat(HttpSession session, Model model) {
        // 현재 로그인한 사용자 정보 (userInfo)와 게시글 작성자 정보를 chat.jsp로 전달
        model.addAttribute("loggedInUser", session.getAttribute("userInfo"));
        return "chat";
    }
}
