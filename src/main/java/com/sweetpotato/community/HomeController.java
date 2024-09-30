package com.sweetpotato.community;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sweetpotato.board.service.BoardService;
import com.sweetpotato.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequiredArgsConstructor
public class HomeController {

	private final BoardService bs;
	
	@GetMapping("/")
	public String main(Model model) throws Exception {
	    List<BoardVO> popularItems = bs.listAll(); // 모든 데이터를 가져옵니다. 실제로는 인기매물 필터링이 필요할 수도 있습니다.
	    model.addAttribute("popularItems", popularItems);
	    return "main";
	}
	
	@GetMapping("main")
    public String mainPage(Model model) throws Exception {
        List<BoardVO> popularItems = bs.listAll(); // 모든 데이터를 가져옵니다. 실제로는 인기매물 필터링이 필요할 수도 있습니다.
        model.addAttribute("popularItems", popularItems);
        return "main";
    }

	
	@GetMapping("location")
	public String location() {
		return "location";
	}

}
