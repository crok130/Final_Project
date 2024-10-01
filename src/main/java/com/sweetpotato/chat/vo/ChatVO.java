package com.sweetpotato.chat.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatVO {
    private int chatId;
    private int memberno1;
    private int memberno2;
    private int boardno;
    private String content;
    
    public ChatVO(int memberno1, int memberno2, int boardno) {
        this.memberno1 = memberno1;
        this.memberno2 = memberno2;
        this.boardno = boardno;
    }
}
