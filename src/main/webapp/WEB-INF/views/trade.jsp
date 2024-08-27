]<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <div class="post-box">
      <div class="container column center" id='popular'>
        <h1>중고거래 인기매물</h1>
      </div>
     
     </div>
      <c:if test="${pageObj.hasNext}">
        <div class="link-container">
          <a class='more-link' href="?page=all#sec8">더보기</a>
        </div>
      </c:if>
    </div>

<script type="text/javascript">
  function showLoginAlert() {
      alert("로그인을 먼저 해주세요.");
      window.location.href = 'login.jsp';
  }
</script>
	
</body>
</html>
