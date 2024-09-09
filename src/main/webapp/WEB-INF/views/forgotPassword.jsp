<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 재설정</title>
    <link rel="stylesheet" type="text/css" href="resources/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/global.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/login.css"/>
</head>
<body class="back-ye">
    <%@ include file="nav.jsp" %>
    <div class="container">
        <div class="login-container">
            <form action="passwordReset" method="post" class="login-form">
                <div>
                    <label for="email" class="login-label">이메일 주소</label>
                    <input type="email" id="email" name="email" class="login-input" required>
                </div>
                <button type="submit" class="login-button">비밀번호 재설정 링크 보내기</button>
            </form>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>
