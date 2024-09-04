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
		<div class="login-container">
			<h2>비밀번호 재설정</h2>
			<form action="resetPassword" method="post">
				<input type="hidden" name="token" value="<%= request.getParameter("token") %>>">
				<div>
					<label for="newPassword" class="login-label">새 비밀번호 입력</label>
					<input type="password" id="newPassword" name="newPassword" class="login-input" required>
				</div>
			</form>
		</div>
	</div>
</body>
</html>