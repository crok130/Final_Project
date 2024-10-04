package com.sweetpotato.board.controller;
	
	
	


import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.sweetpotato.board.service.BoardService;
import com.sweetpotato.board.vo.BoardVO;
import com.sweetpotato.member.vo.MemberVO;

import lombok.RequiredArgsConstructor;
	
	@Controller
	@RequiredArgsConstructor
	public class BoardController {
	
	    private final BoardService bs;
	    private final ServletContext servletContext; 
	
	    
	    @GetMapping("rewrite")
	    public String rewrite(@RequestParam("boardno") int boardno, Model model) throws Exception {
	        BoardVO vo = bs.read(boardno);
	        model.addAttribute("boardVO", vo);
	        return "rewrite";
	    }

	    @PostMapping("update")
	    public String update(BoardVO vo,
	                         @RequestPart("imgs") List<MultipartFile> multipartFile,
	                         HttpSession session) throws Exception {

	        MemberVO member = (MemberVO) session.getAttribute("userInfo");

	        if (member == null) {
	            throw new IllegalStateException("로그인이 필요합니다.");
	        }

	        vo.setMemberno(member.getMemberno());

	        String path = servletContext.getRealPath("\\resources\\imgs\\");
	        System.out.println(path);

	        if (!multipartFile.isEmpty()) {
	            StringBuilder imgFilenames = new StringBuilder();
	            for (MultipartFile mpr : multipartFile) {
	                String orgFilename = mpr.getOriginalFilename();
	                String uniqueFilename = UUID.randomUUID().toString() + "_" + orgFilename;
	                File targetFile = new File(path + File.separator + uniqueFilename);
	                mpr.transferTo(targetFile);
	                imgFilenames.append(uniqueFilename).append(",");
	            }
	            vo.setImg(imgFilenames.substring(0, imgFilenames.length() - 1));
	        }

	        bs.update(vo);
	        return "redirect:/trade_board?boardno=" + vo.getBoardno();
	    }
	    
	    
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
	    public void write(BoardVO vo,
                @RequestPart("imgs") List<MultipartFile> multipartFile,
                HttpSession session
               ) throws Exception {

	        MemberVO member = (MemberVO) session.getAttribute("userInfo");
	        
	        if (member == null) {
	            // 로그인이 되어있지 않은 경우 처리 (예: 로그인 페이지로 리다이렉트)
	            throw new IllegalStateException("로그인이 필요합니다.");
	        }

	        // 게시글 작성자 정보 설정 (예시: 작성자 ID 또는 이름)
	        vo.setMemberno(member.getMemberno());
		  // 동적으로 파일 저장 경로 설정
			  String path = servletContext.getRealPath("\\resources\\imgs\\");
			  System.out.println(path);
			
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
			      vo.setImg(imgFilenames.substring(0, imgFilenames.length() - 1)); // 마지막 ',' 제거
			  }
			
			  bs.regist(vo);
		}
	    
	    @PostMapping("search")
	    public String searchItems(String search, Model model) {
	    	List<BoardVO> searchResults = bs.searchlist(search);  
	        model.addAttribute("searchResults", searchResults);  
	        return "search";  
	    }
	    
	    @GetMapping("/mypage")
	    public String myPage(HttpSession session, Model model) {
	        MemberVO userInfo = (MemberVO) session.getAttribute("userInfo");

	        if (userInfo != null) {
	            int memberno = userInfo.getMemberno();
	            // memberno로 게시물 목록 조회
	            List<BoardVO> myBoardList = bs.getBoardsByMemberno(memberno);
	            System.out.println(myBoardList);
	            model.addAttribute("myBoardList", myBoardList);  // 게시물 목록을 JSP로 전달
	        }

	        return "mypage";
	    }
	    
	    @PostMapping("deleteBoard")
	    public String deleteBoard(int boardno) throws Exception {
	    	bs.delete(boardno);
	    	return "redirect:/trade";
	    }
	    
	        
	}