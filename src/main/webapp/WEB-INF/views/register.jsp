<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" type="text/css" href="resources/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/global.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/nav.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/login.css"/>
<title>회원가입</title>
</head>
<body>
  <body class="back-ye">
    <%@ include file="nav.jsp" %>
    <div class="container">
      <div class="login-container">
        <form method="post" class="login-form">
          <div>
            <label for="username" class="login-label">아이디</label>
            <input type="text" id="username" name="username" class="login-input" required>
          </div>
          <div>
            <label for="password" class="login-label">비밀번호</label>
            <input type="password" id="password" name="password" class="login-input" required>
          </div>
          <div>
            <label for="password" class="login-label">비밀번호 확인</label>
            <input type="password" id="password" name="password" class="login-input" required>
          </div>
          <button type="submit" class="login-button">회원가입</button>
        </form>
       	<p class="register-reco">
  			이미 계정이 있으신가요?
            <a href="{% url 'login' %}" class="bold">로그인</a>
      	</p>
</body>
</html>