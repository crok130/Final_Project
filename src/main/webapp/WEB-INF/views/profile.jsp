<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="resources/css/reset.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/footer.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/write.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/nav.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/global.css"/>
    <style>
      select {
        width: 200px;
        padding: .8em 1em;
        border: 1px solid #999;
        border: none;
        font-size: 16px;
        -webkit-appearance: none;
        -moz-appearance: none;    
        appearance: none;
        background: url('https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F99761B495C84AA8716') no-repeat 95% 50%;
        background-color: #f3f3f3;
      }
    </style>
<title>insert title here</title>
</head>
<script>
	let msg = '';
	
</script>
<body>
    <div class="content-box">
      <div class="container">
          <div class="about-trade">
            <div class="container">
              <form class="write-box" method="POST" action="profileupdate" enctype="multipart/form-data">
                <div class="flex-box">
                  <label class="img-upload">
                    <img src="" alt="프로필이미지" id="imagePreview">
                    <input type="file" name="profile_img" accept="image/*" style="display: none;" onchange="previewImage(event);">
                  </label>
                  <div>
                    <div class="flex-box column baseline title-box">
                      <label for="nickname">닉네임</label>
                      <input type="text" name="membername" class="login-input" placeholder="닉네임 입력">
                  </div>
                <div class="submit-button-box">
                    <button type="submit" style = "margin-left:20px;";>수정완료</button>
                </div>
              </form>
            </div>
          </div>
</body>
</html>