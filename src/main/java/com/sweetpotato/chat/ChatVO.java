package com.sweetpotato.chat;

import java.util.Date;

import lombok.Data;

@Data
public class ChatVO {

	private String chat_id;
	private int memnerno1;
	private int memberno2;
	private int boardno;
	private Date create_at;

}
