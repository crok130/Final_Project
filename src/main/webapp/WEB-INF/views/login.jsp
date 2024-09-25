<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>로그인</title>
</head>
<script>
	window.onload = function() {
		const cookies = document.cookie.split(';');
		let memberId = '';
		cookies.forEach(cookie => {
			const [name, value] = cookie.split('=');
			if(name.trim() === 'memberid'){
				memberId = value;
			}
		});
		if(memberId){
			document.getElementById('username').value = memberId;
            document.getElementById('rememberMe').checked = true; // 자동 로그인 체크
		}
	}
	<%
	    String alertMessage = (String) session.getAttribute("alertMessage");
	    if (alertMessage != null) {
	%>
	    alert("<%= alertMessage %>");
	<%
	    session.removeAttribute("alertMessage"); // 메시지를 사용한 후 세션에서 제거
	    }
	%>
</script>
<body class="back-ye">
	<%@ include file="nav.jsp"%>
	<div class="container">
		<div class="login-container">
			<form method="post" action="login" class="login-form">
				<div>
					<label for="username" class="login-label">아이디</label> <input
						type="text" id="username" name="memberid" class="login-input"
						required>
				</div>
				<div>
					<label for="password" class="login-label">비밀번호</label> <input
						type="password" id="password" name="memberpass"
						class="login-input" required>
				</div>
				<div class="login-options">
					<div class="remember-me">
						<input type="checkbox" id="rememberMe" name="rememberMe"
							class="login-checkbox"> <label for="rememberMe"
							class="login-checkbox-label">자동 로그인</label>
					</div>
				</div>
				<button type="submit" class="login-button">로그인</button>
			</form>
			<p class="register-reco">
				고구마마켓 회원이 아니신가요? <a href="register" class="bold">회원가입</a>
			</p>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
