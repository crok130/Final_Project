package com.sweetpotato.chat.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



import lombok.RequiredArgsConstructor;

@Controller

public class ChatController {
	   

    @GetMapping("/chat")
    public String chat() throws Exception {

        return "chat"; 
    }
}
