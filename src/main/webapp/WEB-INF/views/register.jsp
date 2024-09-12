<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="resources/css/reset.css" />
<link rel="stylesheet" type="text/css" href="resources/css/global.css" />
<link rel="stylesheet" type="text/css" href="resources/css/nav.css" />
<link rel="stylesheet" type="text/css" href="resources/css/footer.css" />
<link rel="stylesheet" type="text/css" href="resources/css/login.css" />
<title>회원가입</title>
<script>
	function sendEmail() {
	    var email = document.getElementById("memberemail").value;
	    if (email) {
	        var xhr = new XMLHttpRequest();
	        xhr.open("POST", "sendEmail", true);
	        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	        xhr.onreadystatechange = function() {
	            if (xhr.readyState == 4 && xhr.status == 200) {
	                if (xhr.responseText.trim() === "success") {
	                    alert("인증 코드가 이메일로 전송되었습니다.");
	                    document.getElementById("authCodeDiv").classList.remove("hidden");
	                } else {
	                    alert("이메일 전송에 실패했습니다.");
	                }
	            }
	        };
	        xhr.send("memberemail=" + encodeURIComponent(email));
	    } else {
	        alert("이메일을 입력하세요.");
	    }
	}

    function verifyCode() {
        var authCode = document.getElementById("authCode").value;
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "verifyCode", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                if (xhr.responseText.trim() === "success") {
                    document.getElementById("verificationMessage").innerText = "이메일 인증 성공!";
                    document.getElementById("registerBtn").disabled = false;
                } else {
                    document.getElementById("verificationMessage").innerText = "인증 코드가 올바르지 않습니다.";
                }
            }
        };
        xhr.send("authCode=" + authCode);
    }

    function handleFormSubmit(event) {
        event.preventDefault();
        alert("회원가입이 완료되었습니다.\n고구마 마켓의 회원이 되신것을 진심으로 환영합니다.");
        window.location.href = "login";
    }
</script>
</head>
<body class="back-ye">
    <%@ include file="nav.jsp"%>
    <div class="container">
        <div class="login-container">
            <form action="reg" method="post" class="login-form" onsubmit="handleFormSubmit(event)">
                <div>
                    <label for="membername" class="login-label">이름</label>
                    <input type="text" id="membername" name="membername" class="login-input" required>
                </div>
                <div>
                    <label for="memberid" class="login-label">아이디</label>
                    <input type="text" id="memberid" name="memberid" class="login-input" required>
                </div>
                <div>
                    <label for="memberpass" class="login-label">비밀번호</label>
                    <input type="password" id="memberpass" name="memberpass" class="login-input" required>
                </div>
                <div>
                    <label for="memberpassConfirm" class="login-label">비밀번호 확인</label>
                    <input type="password" id="memberpassConfirm" name="memberpassConfirm" class="login-input" required>
                </div>
                <div>
                    <label for="memberbirth" class="login-label">생년월일</label>
                    <input type="date" id="memberbirth" name="memberbirth" class="login-input" required>
                </div>
                <div>
                    <label for="memberphone" class="login-label">휴대전화</label>
                    <input type="text" id="memberphone" name="memberphone" class="login-input" required>
                </div>
                <div>
                    <label for="memberaddr" class="login-label">주소</label>
                    <input type="text" id="memberaddr" name="memberaddr" class="login-input" required>
                </div>
                <div>
                    <label for="memberemail" class="login-label">이메일</label>
                    <input type="email" id="memberemail" name="memberemail" required>
                </div>
                <button type="button" onclick="sendEmail()">이메일 인증</button>
                <p id="emailMessage"></p>
                <div id="authCodeDiv" class="hidden">
                    <input type="text" id="authCode" placeholder="인증 코드 입력" required>
                    <button type="button" onclick="verifyCode()">인증코드 확인</button>
                    <p id="verificationMessage"></p>
                </div>
                <button type="submit" class="login-button" id="registerBtn">회원가입</button>
            </form>
            <p class="register-reco">
                이미 계정이 있으신가요? <a href="#" class="bold">로그인</a>
            </p>
        </div>
    </div>
    <%@ include file="footer.jsp"%>
</body>
</html>
