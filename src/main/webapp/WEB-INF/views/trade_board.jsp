<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<script src ="resources/js/trade_board.js"></script>
<style>
   .slider-container {
        position: relative;
        width: 100%;
        text-align: center;
    }

    .slider-image {
        display: none;
        width: 100%;
        height: auto;
    }

    .slider-image.active {
        display: block;
    }

    .slider-controls {
        position: absolute;
        top: 50%;
        width: 100%;
        display: flex;
        justify-content: space-between;
        transform: translateY(-50%);
    }

    .slider-info {
        position: absolute;
        bottom: 20px; /* 이미지 밑에 위치 */
        left: 50%;
        transform: translateX(-50%); /* 가로 중앙 정렬 */
        font-size: 18px;
        font-weight: bold;
        color: white;
        background: rgba(0, 0, 0, 0.5); /* 반투명 배경 */
        padding: 5px 10px;
        border-radius: 5px;
    }

    .prev-btn, .next-btn {
        background-color: rgba(0, 0, 0, 0.5);
        color: white;
        border: none;
        padding: 10px;
        cursor: pointer;
    }

    .prev-btn:hover, .next-btn:hover {
        background-color: rgba(0, 0, 0, 0.7);
    }
</style>
</head>
<body>
    <%@ include file="nav.jsp" %>
    <div class="content-box">
      <div class="container column">
        <div class="post-box">
			<div class="slider-container" id="slider">
			    <c:set var="images" value="${fn:split(boardVO.img, ',')}" />
			    <c:forEach var="image" items="${images}" varStatus="status">
			        <img src="${pageContext.request.contextPath}/resources/imgs/${image}" class="slider-image ${status.index == 0 ? 'active' : ''}" alt="상품이미지">
			    </c:forEach>
			
			    <!-- 이전/다음 버튼 -->
			    <div class="slider-controls">
			        <button class="prev-btn" onclick="prevSlide()">이전</button>
			        <button class="next-btn" onclick="nextSlide()">다음</button>
			    </div>
			
			    <!-- 이미지 개수 및 현재 이미지 순서 표시 -->
			    <div class="slider-info">
			        <span id="current-slide">1</span> / <span id="total-slides">${fn:length(images)}</span>
			    </div>
			</div>
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
                <h3>${boardVO.price}
                  원</h3>
              </div>
              <p>${boardVO.content}</p>
              <div class="location-views-box flex-box between">
                <p>희망 거래장소 |
                  ${boardVO.region}</p>
                <p>조회수
                  ${boardVO.viewcnt}</p>
              </div>
            </div>
          
        </div>
      </div>
    </div>
     <%@ include file="footer.jsp" %>

</body>
</html>