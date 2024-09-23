<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" type="text/css" href="resources/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/global.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/nav.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/login.css"/>
    <title>비밀번호 재설정</title>
</head>
<body class="back-ye">
    <%@ include file="nav.jsp" %>
    <div class="container">
        <div class="login-container">
            <form method="post" action="resetPassword" class="login-form">
                <div>
                    <label for="memberid" class="login-label">아이디</label>
                    <input type="text" id="memberid" name="memberid" class="login-input" required>
                </div>
                <div>
                    <label for="memberemail" class="login-label">이메일</label>
                    <input type="email" id="memberemail" name="memberemail" class="login-input" required>
                </div>
                <div>
                    <label for="newPassword" class="login-label">새 비밀번호</label>
                    <input type="password" id="newPassword" name="memberpass" class="login-input" required>
                </div>
                <button type="submit" class="login-button">비밀번호 재설정</button>
            </form>
            <!-- 비밀번호 재설정 결과 메시지 표시 -->
            <div>
                <c:if test="${not empty message}">
                    <p>${message}</p>
                </c:if>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>