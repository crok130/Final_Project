package com.sweetpotato.member.vo;

import lombok.Data;

@Data
public class MemberVO {
    private int memberno;
    private String memberid;
    private String memberpass;
    private String membername;
    private String memberbirth;
    private String memberphone;
    private String memberemail;
    
    // 자동 로그인 체크박스 상태를 저장할 필드
    private boolean rememberMe;

    // 자동 로그인 상태를 가져오는 메서드
    public boolean isRememberMe() {
        return rememberMe;
    }
    
    // 자동 로그인 상태를 설정하는 메서드
    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
