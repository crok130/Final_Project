package com.sweetpotato.board.controller;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    // 게시글 작성 받는 post매핑
    /*
    @PostMapping("write")
    public String createBoard(
            @RequestParam(value = "img", required = false) List<MultipartFile> img,
            @RequestParam("main_category") String mainCategory,
            @RequestParam("sub_category") String subCategory,
            @RequestParam("price") int price,
            @RequestParam("status") String status,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("region") String region) throws Exception {

        // BoardVO 객체 생성 및 필드 설정
        BoardVO vo = new BoardVO();
        vo.setMain_category(mainCategory);
        vo.setSub_category(subCategory);
        vo.setPrice(price);
        vo.setStatus(status);
        vo.setTitle(title);
        vo.setContent(content);
        vo.setRegion(region);

        // 이미지 처리
        if (img != null && !img.isEmpty()) {
            String uploadDir = "C:/upload/images/";
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            List<String> imgPaths = new ArrayList<>();
            
            for (MultipartFile image : img) {
                if (!image.isEmpty()) {
                    String originalFileName = image.getOriginalFilename();
                    String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                    String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFileName;
                    Path filePath = Paths.get(uploadDir + uniqueFileName);
                    
                    try {
                        image.transferTo(new File(filePath.toString()));
                        imgPaths.add(uniqueFileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return "FAILED";
                    }
                }
            }
            
        }
        // 게시글 등록 처리
        String result = bs.regist(vo);

        return "redirect:/trade";

    }
    */
    @PostMapping("write")
    public String write(@RequestParam(value = "img", required = false) List<MultipartFile> img,
                        @RequestParam("main_category") String mainCategory,
                        @RequestParam("sub_category") String subCategory,
                        @RequestParam("price") int price,
                        @RequestParam("status") String status,
                        @RequestParam("title") String title,
                        @RequestParam("content") String content,
                        @RequestParam("region") String region) throws Exception {

        BoardVO vo = new BoardVO();
        vo.setMain_category(mainCategory);
        vo.setSub_category(subCategory);
        vo.setPrice(price);
        vo.setStatus(status);
        vo.setTitle(title);
        vo.setContent(content);
        vo.setRegion(region);

        String path = "c:\\Repository\\file\\";  // 실제 파일 저장 경로
        StringBuilder imgPaths = new StringBuilder();  // 이미지 경로를 저장할 StringBuilder

        if (img != null && !img.isEmpty()) {
            for (MultipartFile mpr : img) {
                String originalFilename = mpr.getOriginalFilename();
                File targetFile = new File(path + originalFilename);
                mpr.transferTo(targetFile);

                imgPaths.append(originalFilename).append(";");
                System.out.println("Uploaded file: " + targetFile);
            }
        }

        vo.setImg(imgPaths.toString());  // 이미지 경로를 ';'로 구분하여 VO에 저장
        bs.regist(vo);

        return "redirect:/trade";
    }


}
