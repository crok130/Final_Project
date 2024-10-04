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
<title>게시글 수정</title>
</head>
<body>
    <%@ include file="nav.jsp" %>

    <div class="content-box">
      <div class="container column">
        <div class="post-box">
            <form action="${pageContext.request.contextPath}/update" method="post" enctype="multipart/form-data">
                <input type="hidden" name="boardno" value="${boardVO.boardno}" />

                <div>
                    <label for="title">제목</label>
                    <input type="text" id="title" name="title" value="${boardVO.title}" required />
                </div>
                
                <div>
                    <label for="price">가격</label>
                    <input type="number" id="price" name="price" value="${boardVO.price}" required />
                </div>

                <div>
                    <label for="content">내용</label>
                    <textarea id="content" name="content" required>${boardVO.content}</textarea>
                </div>

                <div>
                    <label for="region">거래 지역</label>
                    <input type="text" id="region" name="region" value="${boardVO.region}" required />
                </div>

                <div>
                    <label for="imgs">이미지</label>
                    <input type="file" id="imgs" name="imgs" multiple />
                    <div>
                        <c:forEach var="image" items="${fn:split(boardVO.img, ',')}">
                            <img src="${pageContext.request.contextPath}/resources/imgs/${image}" alt="이미지" style="width: 100px; height: auto;" />
                        </c:forEach>
                    </div>
                </div>

                <button type="submit">수정하기</button>
            </form>
        </div>
      </div>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
