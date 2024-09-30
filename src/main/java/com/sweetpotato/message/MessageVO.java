package com.sweetpotato.message;

import java.util.Date;

import lombok.Data;

@Data
public class MessageVO {

	private int message_id;
	private int chat_id;
	private int sender_id;
	private String content;
	private Date timestamp;
	private boolean is_read;
	
}
