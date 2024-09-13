<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="resources/css/reset.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/global.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/nav.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/footer.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/login.css" />
    <title>비밀번호 재설정 결과</title>
</head>
<body class="back-ye">
    <%@ include file="nav.jsp"%>
    <div class="container">
        <div class="login-container">
            <div class="result-message">
                <!-- JSTL을 사용하여 메시지를 출력 -->
                <c:if test="${not empty message}">
                    <p>${message}</p>
                </c:if>
                <!-- 메시지가 없을 때도 사용자에게 알림을 줄 수 있음 -->
                <c:if test="${empty message}">
                    <p>비밀번호 재설정 결과를 확인할 수 없습니다.</p>
                </c:if>
                <a href="forgotPassword" class="login-button">돌아가기</a>
            </div>
        </div>
    </div>
</body>
</html>
