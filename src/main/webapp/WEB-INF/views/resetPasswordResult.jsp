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
<title>비밀번호 재설정 결과</title>
</head>
<body class="back-ye">
	<%@ include file="nav.jsp"%>
	<div class="container">
		<div class="login-container">
			<div class="result-message">
				<p><%= request.getAttribute("message") %></p>
				<a href="forgotPassword" class="login-button">돌아가기</a>
			</div>
		</div>
	</div>
</body>
</html>