<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="shortcut icon" type="image/x-icon" href="https://blog.kakaocdn.net/dn/S0wSJ/btqDogzoUNX/kZBkpKPGjdGKJSvKKs35D0/img.png">
    <title>중고거래</title>
    <link rel="stylesheet" type="text/css" href="resources/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/global.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/trade.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/nav.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/footer.css"/>
</head>
<body>
   <%@ include file="nav.jsp" %>
     <div class="content-box">
      <a href="write">
        <div class="floating-button">
          거래글쓰기
        </div>
      </a>
      <div class="about-trade">
        <div class="container ">
          <div class="trade-text">
            <h3>믿을만한</br>이웃 간 중고거래</h3>
          <p>동네 주민들과 가깝고 따뜻한 거래를</br>지금 경험해보세요.</p>
      </div>
      <div class="thumbnail-img">
        <img src="resources/img/img1.png" alt=""/>
      </div>
    </div>
 	</div>

    <div class="post-box">
      <div class="container column center" id='popular'>
        <h1>중고거래 인기매물</h1>
      </div>
      <div class="container column center">
        <div class="full-box trade-box column">
          <div class="flex-box full-box card-container between infinite-container">
            
            <c:forEach var="item" items="${popularItems}">
              <div class="card-box infinite-item">
                <%--  로그인 된 유저라면 --%>
                <a href="trade_board?boardno=${item.boardno}" class="trade-text-link">
                    <div class="card-img">
						<c:set var="firstCommaIndex" value="${fn:indexOf(item.img, ',')}" />
						<c:choose>
							     <%-- 이미지가 하나만 있을 때 (쉼표가 없을 경우) --%>
							    <c:when test="${firstCommaIndex == -1}">
							        <img src="${pageContext.request.contextPath}/resources/imgs/${item.img}" alt="상품이미지">
							    </c:when>
							   <%-- 쉼표가 있는 경우 첫 번째 이미지 추출 ---%>
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
              <!--아래줄부터 상품들록  -->
          </div>
        </div>
      </div>
      
      <div class="link-container">
        <a class='more-link' href="?page=all#sec8" >더보기</a>
      </div>
      
    </div>
<script type="text/javascript">
  function showLoginAlert() {
      alert("로그인을 먼저 해주세요.");
      window.location.href = 'login.jsp';
  }
</script>
	
</body>
</html>
