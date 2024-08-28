package com.sweetpotato.board.vo;

import lombok.Data;

@Data
public class BoardVO {

	private int boardno;
	private String memberno;
	private String boardcategory;
	private int boardprice;
	private String status;
	private String boardimg;
	private String boardtitle;
	private String boardcontent;
	private int view;
	private String region;
	
}
