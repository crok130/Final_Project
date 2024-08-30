package com.sweetpotato.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sweetpotato.board.service.BoardService;
import com.sweetpotato.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService bs;

    @GetMapping("write")
    public void write() throws Exception {
        // write.jsp 페이지를 반환
    }

    @GetMapping("trade")
    public String trade() throws Exception{
    	return "trade";
    }
    
    @PostMapping("write")
    public String createBoard(@ModelAttribute BoardVO boardVO,
                              @RequestParam(value = "img", required = false) MultipartFile[] files) throws Exception {

        // 이미지 파일 처리
        if (files != null && files.length > 0 && !files[0].isEmpty()) {
            boardVO.setImg(files[0].getOriginalFilename()); 
            // 실제 파일 저장 로직 추가 필요
        } else {
            boardVO.setImg(null); 
        }

        
        String result = bs.regist(boardVO);

        
        if ("SUCCESS".equals(result)) {
            return "redirect:/trade_board"; // 성공 시 게시판 페이지로 리다이렉트
        } else {
            return "redirect:/write"; // 실패 시 다시 작성 페이지로 리다이렉트
        }
    }
}
