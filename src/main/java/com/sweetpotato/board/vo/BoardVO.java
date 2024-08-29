package com.sweetpotato.board.vo;

import lombok.Data;

@Data
public class BoardVO {

	private int boardno;
	private String memberno;
	private String category;
	private int price;
	private String status;
	private String img;
	private String title;
	private String content;
	private int viewcnt;
	private String region;
	
}
