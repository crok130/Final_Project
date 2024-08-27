package com.sweetpotato.message;

import java.util.Date;

import lombok.Data;

@Data
public class MessageVO {

	private String message_id;
	private String chat_id;
	private String sender_id;
	private String content;
	private Date timestamp;
	private boolean is_read;
	
}
