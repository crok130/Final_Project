<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="resources/css/reset.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/global.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/nav.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/footer.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/login.css" />
    <title>비밀번호 찾기</title>
</head>
<body class="back-ye">
    <%@ include file="nav.jsp" %>
    <div class="container">
        <div class="login-container">
            <form method="post" action="sendPasswordResetEmail" class="login-form">
                <div>
                    <label for="email" class="login-label">이메일 주소</label>
                    <input type="email" id="email" name="email" class="login-input" required>
                </div>
                <button type="submit" class="login-button">비밀번호 재설정 이메일 보내기</button>
            </form>
            <p class="login-info">비밀번호를 잊으셨나요? 가입한 이메일 주소를 입력하시면 비밀번호 재설정 링크를 보내드립니다.</p>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>
