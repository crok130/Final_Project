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
  <link rel="stylesheet" type="text/css" href="resources/css/search.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/nav.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/global.css"/>
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<%@ include file="nav.jsp" %>
	 <c:if test="${fn:length(searchResults) == 0}">
      <script>
        alert('검색 결과가 없습니다.');
        history.back();  // 이전 페이지로 이동
      </script>
    </c:if>
	
    <div class="post-box">
      <div class="container column center">
        <div class="container column center">
          <div class="full-box trade-box column">
            <div class="flex-box full-box card-container between">

		         <c:forEach var="item" items="${searchResults}">
		          <div class="card-box infinite-item">
		            <a href="trade_board?boardno=${item.boardno}" class="trade-text-link">
		              <div class="card-img">
		                <c:set var="firstCommaIndex" value="${fn:indexOf(item.img, ',')}" />
		                <c:choose>
		                  <c:when test="${firstCommaIndex == -1}">
		                    <img src="${pageContext.request.contextPath}/resources/imgs/${item.img}" alt="상품이미지">
		                  </c:when>
		                  <c:otherwise>
		                    <img src="${pageContext.request.contextPath}/resources/imgs/${fn:substring(item.img, 0, firstCommaIndex)}" alt="상품이미지">
		                  </c:otherwise>
		                </c:choose>
		              </div>
		              <div class="card-info-box">
			                <h5>${item.title}</h5>
			                <p class="bold">${item.price}원</p>
			                <p>${item.region}</p>
			                <div class="flex-box">
			                  <p>조회 ${item.viewcnt}</p>
			                  <p>·</p>
			                  <p>채팅 2</p>
			                </div>
		              </div>
		            </a>
		          </div>
		        </c:forEach>
				<c:if test="${fn:length(searchResults) % 4 != 0}">
				  <c:forEach begin="1" end="${4 - (fn:length(searchResults) % 4)}">
				    <div class="card-box empty"></div>
				  </c:forEach>
				</c:if>
        	</div>
          </div>
        </div>
      </div>
     </div>
</body>
</html>