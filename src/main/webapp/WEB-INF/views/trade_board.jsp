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
</head>
<body>
    <%@ include file="nav.jsp" %>
    <div class="content-box">
      <div class="container column">
        <div class="post-box">
            	<c:set var="firstCommaIndex" value="${fn:indexOf(boardVO.img, ',')}" />
				<c:choose>
					<%-- 이미지가 하나만 있을 때 (쉼표가 없을 경우) --%>
					<c:when test="${firstCommaIndex == -1}">
						<img src="${pageContext.request.contextPath}/resources/imgs/${boardVO.img}" alt="상품이미지">
					</c:when>
					<%-- 쉼표가 있는 경우 첫 번째 이미지 추출 ---%>
					<c:otherwise>
						<img src="${pageContext.request.contextPath}/resources/imgs/${fn:substring(boardVO.img, 0, firstCommaIndex)}" alt="상품이미지">
					</c:otherwise>
				</c:choose>
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