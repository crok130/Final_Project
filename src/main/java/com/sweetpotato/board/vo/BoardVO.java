package com.sweetpotato.board.vo;

import java.util.List;

import lombok.Data;

@Data
public class BoardVO {

	private int boardno;
	private int memberno;
	private String main_category;
	private String sub_category;
	private int price;
	private String status;
	private String img;
	private String title;
	private String content;
	private int viewcnt;
	private String region;
	

}
