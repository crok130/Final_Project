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
    
    <script>
        // URL 파라미터에서 메시지를 추출하는 함수
        function getParameterByName(name) {
            const urlParams = new URLSearchParams(window.location.search);
            return urlParams.get(name);
        }

        // message 파라미터가 있는지 확인하고, 있으면 처리
        const message = getParameterByName('message');
        if (message) {
            if (message === 'success') {
                // 성공 메시지일 경우
                alert('비밀번호가 성공적으로 변경되었습니다.');
                window.location.href = 'main'; // '확인' 후 메인 페이지로 이동
            } else {
                // 실패 메시지일 경우
                alert('비밀번호 변경에 실패했습니다. 다시 시도해 주세요.');
                window.location.href = 'forgotPassword'; // '확인' 후 비밀번호 재설정 페이지로 이동
            }
        }
    </script>
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
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>
