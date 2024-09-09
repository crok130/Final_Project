	package com.sweetpotato.board.controller;
	
	
	
	import java.io.File;
	import java.util.List;
	import java.util.UUID;
	
	import javax.servlet.ServletContext;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RequestPart;
	import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sweetpotato.board.service.BoardService;
	import com.sweetpotato.board.vo.BoardVO;
	
	import lombok.RequiredArgsConstructor;
	
	@Controller
	@RequiredArgsConstructor
	public class BoardController {
	
	    private final BoardService bs;
	    private final ServletContext servletContext; 
	
	    @GetMapping("write")
	    public void write() throws Exception {
	        // write.jsp 페이지를 반환
	    }
	
	    @GetMapping("trade")
	    public String trade(Model model) throws Exception {
	        List<BoardVO> popularItems = bs.listAll(); 
	        model.addAttribute("popularItems", popularItems);
	        return "trade";
	    }
	    
	    @GetMapping("trade_board")
	    public String trade_board(int boardno, Model model) throws Exception {
	    	BoardVO vo = bs.read(boardno);
	    	model.addAttribute(vo);
	    	return "trade_board";
	    }
	
	    // 게시글 작성 받는 post매핑
	    @PostMapping("write")
	    public void write(@RequestParam("title") String title,
	                      @RequestParam("price") int price,
	                      @RequestParam("status") String status,
	                      @RequestParam("main_category") String mainCategory,
	                      @RequestParam("sub_category") String subCategory,
	                      @RequestParam("content") String content,
	                      @RequestParam("region") String region,
	                      @RequestPart("img") List<MultipartFile> multipartFile
	                     ) throws Exception {
	
	        // 동적으로 파일 저장 경로 설정
	        String path = servletContext.getRealPath("\\resources\\imgs\\");
	        System.out.println(path);
	
	        BoardVO boardVO = new BoardVO();
	        boardVO.setTitle(title);
	        boardVO.setPrice(price);
	        boardVO.setStatus(status);
	        boardVO.setMain_category(mainCategory);
	        boardVO.setSub_category(subCategory);
	        boardVO.setContent(content);
	        boardVO.setRegion(region);
	
	        // 파일 저장 로직
	        if (!multipartFile.isEmpty()) {
	            StringBuilder imgFilenames = new StringBuilder();
	            for (MultipartFile mpr : multipartFile) {
	                String orgFilename = mpr.getOriginalFilename();
	                
	                String uniqueFilename = UUID.randomUUID().toString() + "_" + orgFilename;
	
	                // 대상 파일 생성
	                File targetFile = new File(path + File.separator + uniqueFilename);
	                mpr.transferTo(targetFile);
	
	                // 파일 이름만 추가
	                imgFilenames.append(uniqueFilename).append(",");
	            }
	            // 이미지 이름만 설정
	            boardVO.setImg(imgFilenames.substring(0, imgFilenames.length() - 1)); // 마지막 ',' 제거
	        }
	        
	        System.out.println("BoardVO: " + boardVO);
	
	        bs.regist(boardVO);
	    }
	    
	
	}