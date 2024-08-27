<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="resources/css/reset.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/footer.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/trade_post.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/nav.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/global.css"/>
<title>Insert title here</title>
</head>
<body>
    <%@ include file="nav.jsp" %>
    <div class="content-box">
      <div class="container column">
        <div class="post-box">
            <img src="resources/img/ra.PNG" alt="상품판매이미지" class="block-box">
            <div class="flex-box between info-button-box">
              <div class="user-info">
                <h6>최수빈</h6>
                <p>부산</p>
              </div>
              <div class="flex-box button-box">
                <a href="#">
                  <button class="grey">수정하기</button>
                </a>
                <a href="#" onclick="return confirmDelete();"> <!-- 삭제하기 버튼 링크 추가 -->
                  <button class="grey" data-post-id="#">삭제하기</button>
                </a>
                <button class="orange" onclick="openChatroom()">채팅보기</button>
              </div>
              
              <div class="button-box">
                <button class="orange" onclick="openChatroom()">채팅하기</button>
              </div>
              

            </div>
            <hr class="line">
            <div class="post-info-box">
              <div class="flex-box between">
                <h3>제목</h3>
                <h3>20000
                  원</h3>
              </div>
              <p>하자없습니다</p>
              <div class="location-views-box flex-box between">
                <p>희망 거래장소 |
                  부산</p>
                <p>조회수
                  40</p>
              </div>
            </div>
          
        </div>
      </div>
    </div>
     <%@ include file="footer.jsp" %>
</body>
</html>