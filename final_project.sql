

create schema sweetpotato;
select * from board;
create table member(
	memberno int primary key auto_increment,
    memberid varchar(200) not null unique,
    memberpass varchar(200) not null,
    membername varchar(50) not null,
    memberbirth DATE not null,
    memberphone varchar(50) not null,
    memberemail varchar(200) not null unique,
    memberaddr varchar(200)
);
alter table board add column region varchar(50);

create table board(
	boardno int primary key auto_increment,
    memberno int,
    main_category varchar(200),
    sub_category varchar(200),
    price int,
    status enum ('판매중','판매완료','나눔') default '판매중',
    img varchar(200),
    title varchar(200) not null,
    content text,
    region varchar(50),
    viewcnt int,
    foreign key (memberno) REFERENCES member (memberno)
);

CREATE TABLE Chats (
    chat_id INT PRIMARY KEY AUTO_INCREMENT,  -- 채팅 방 고유 ID
    memberno1 INT NOT NULL,                  -- 첫 번째 사용자 ID
    memberno2 INT NOT NULL,                  -- 두 번째 사용자 ID
    boardno INT,                             -- 관련된 게시글 번호 (필요에 따라 사용)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 채팅 방 생성 시간
    UNIQUE (memberno1, memberno2, boardno),  -- 동일 사용자 및 게시글 중복 방지
    FOREIGN KEY (memberno1) REFERENCES member(memberno),  -- 첫 번째 사용자 FK
    FOREIGN KEY (memberno2) REFERENCES member(memberno),  -- 두 번째 사용자 FK
    FOREIGN KEY (boardno) REFERENCES board(boardno)      -- 관련된 게시글 FK
);

CREATE TABLE Messages (
    message_id INT PRIMARY KEY AUTO_INCREMENT,  -- 메시지 고유 ID
    chat_id INT NOT NULL,                       -- 채팅 방 ID
    sender_id INT NOT NULL,                     -- 메시지를 보낸 사용자 ID
    content TEXT NOT NULL,                      -- 메시지 내용
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 메시지가 보내진 시간
    is_read BOOLEAN DEFAULT FALSE,              -- 메시지 읽음 상태
    FOREIGN KEY (chat_id) REFERENCES Chats(chat_id),  -- 채팅 방 FK
    FOREIGN KEY (sender_id) REFERENCES member(memberno)  -- 메시지 보낸 사용자 FK
);
