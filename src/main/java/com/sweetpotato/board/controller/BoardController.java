
package com.sweetpotato.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sweetpotato.board.service.BoardService;
import com.sweetpotato.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService bs;
	
	@GetMapping("write")
	public void write() throws Exception {
		
	}
	
	@GetMapping("search")
	public String search() throws Exception{
		return "search";
	}
	
	@GetMapping("trade")
	public String trade() throws Exception{
		return "trade";
	}
	
	@GetMapping("trade_board")
	public String trade_board() throws Exception{
		return "trade_board";
	}
	
	@PostMapping("write")
	public String write(BoardVO vo) throws Exception{
		System.out.println(vo);
		String message = bs.regist(vo);
		System.out.println(message);
		return "redirect:/trade";
	}
	
	@GetMapping("dd")
	public String dd() throws Exception{
		return "dd";
	}

}
