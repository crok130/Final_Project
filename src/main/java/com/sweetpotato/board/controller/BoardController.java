
package com.sweetpotato.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sweetpotato.board.vo.BoardVO;

@Controller
public class BoardController {

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
	
	

}
