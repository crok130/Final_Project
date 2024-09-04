<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body>
	<div class="container">
		<h2>비밀번호 찾기</h2>
		<form action="sendResetLink" method="post">
			<div>
				<label for="email" class="login-label">이메일</label>
				<input type="email" id="email" name="email" class="login-input" required>
			</div>
			<button>비밀번호 재설정 링크 보내기</button>
		</form>
	</div>
</body>
</html>