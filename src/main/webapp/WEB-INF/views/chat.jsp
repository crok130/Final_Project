<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	  <link rel="stylesheet" type="text/css" href="resources/css/reset.css"/>
	  <link rel="stylesheet" type="text/css" href="resources/css/footer.css"/>
	  <link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
	  <link rel="stylesheet" type="text/css" href="resources/css/nav.css"/>
	  <link rel="stylesheet" type="text/css" href="resources/css/global.css"/>
	  <link rel="stylesheet" type="text/css" href="resources/css/chat.css"/>
	  <link rel="stylesheet" type="text/css" href="resources/css/test.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="https://blog.kakaocdn.net/dn/S0wSJ/btqDogzoUNX/kZBkpKPGjdGKJSvKKs35D0/img.png">
    <title>채팅하기</title>
  </head>

  <body class="back-ye">
    <%@ include file="nav.jsp" %>
    <div class="content-box">
      <div class="container column">
        <div class="post-box flex-box">

          <!-- 채팅선택창 -->
          <div class="chat-select-container">
            <div class="flex-box">

              <!-- 아이디및 체크박스 -->
              <div class="id-box flex-box between">
                아이디
                <div>
                   <label>
                    안읽은 메세지만 보기
                    <input type="checkbox" name="" id="">
                  </label> 
                </div>
              </div>
            </div>

            <!-- 채팅 리스트 -->
            <div class="chat-list-box flex-box column">
              <!-- 봇 -->
              <div class="chat-box flex-box" style="cursor: pointer;" onclick='location.href="{% url 'chatbot' %}";'>
                <div class="ai-profile">
                  <img src="resources/img/icon_aibot.png" alt="">
                </div>
                <div>
                  <p class="bold">AI 챗봇</p>
                  <p class="chat-thumb-text">궁금한 내용을 물어보세요!</p>
                </div>
              </div>
              <!-- 채팅방리스트 -->
              <div class="flex-box chat-box between" style="cursor: pointer;" onclick='location.href="{% url 'chatroom_ws' chatroom.chatroom.id%}";'>
                <div>
                  <div class="flex-box">
                    <p class="bold">sakd130</p>
                    <p class="s-text">2024</p>
                    <p class="s-text">09.13</p>
                     <p class="s-text">10:16 am</p> 
                    
                  </div>
                  <p class="chat-thumb-text">사겠습니다</p>
                </div>
                <div class="thumbnail-box">
                  <img src="" alt="상품사진">
                </div>
              </div>

            </div>
          </div>
          <!-- 채팅창-->

            <div class="chat-main-container">
            <div>
                <div class="contact-info flex-box">

                    <div class="temp">

                    </div>
                </div>

              <!--물품정보-->
              <div class="goods-box flex-box between">
                <div class="flex-box">
                  <div class="selected-thumbnail-box">
                    <img src="" alt="상품사진">
                  </div>
                  <div class="goods-info-box">
                    <p>제목</p>
                    <p class="bold">가격</p>
                  </div>
                </div>


                    <form method="post" action="{% url 'confirm_deal' product.id %}">

                          <button type="submit">거래확정하기</button>
                    </form>

                    <button type="button">거래완료</button>


                    <button type="button">거래진행중</button>
                  <button type="button">거래완료</button>

              </div>

              <!--채팅창 메인-->
                <div class="chat-container">
                          <div class="message-box from-me">
                              <p class="s-text">#</p>
                              <div class="message-text">#</div>
                          </div>
                          <div class="message-box from-you">
                              <div class="message-text">#</div>
                              <p class="s-text">#</p>
                          </div>
                </div>
                  <div class="chat-container">

                            <div class="message-box from-me">
                                <p class="s-text">#</p>
                                <div class="message-text">#</div>
                            </div>
                            <div class="message-box from-you">
                                <div class="message-text">#</div>
                                <p class="s-text">#</p>
                            </div>
                            <div class="message-box from-you">
                              <div class="message-text">
                                <p>물건 거래가 완료되었습니다. 리뷰 작성을 원하신다면 <a href="#"> "여기를 클릭하세요" </a></p>
                              </div>
                            </div>
              </div>

            <form class="chat-input">
              <textarea name="" id="message-textarea" cols="30" rows="10" placeholder="메세지를 입력해주세요"></textarea>
              <div>
                <button id="sendButton">전송</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
   <%@ include file="footer.jsp" %>
    
  </body>

</html>