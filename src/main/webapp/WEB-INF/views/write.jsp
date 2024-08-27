<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="shortcut icon" type="image/x-icon" href="https://blog.kakaocdn.net/dn/S0wSJ/btqDogzoUNX/kZBkpKPGjdGKJSvKKs35D0/img.png">
    <title>거래 글쓰기</title>
    <link rel="stylesheet" type="text/css" href="resources/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/global.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/write.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/nav.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/footer.css"/>
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
<title>Insert title here</title>
</head>
<body>
    <div class="content-box">
      <div class="container">
          <div class="about-trade">
            <div class="container">
              <form class="write-box" method="POST" action="" enctype="multipart/form-data">
                <div class="flex-box">
                  <label class="img-upload">
                    <img src="" alt="이미지를 추가해주세요" id="imagePreview">
                    <input type="file" name="images" accept="image/*" style="display: none;" onchange="previewImage(event);">
                  </label>
                  <div>
                    <div class="flex-box column baseline title-box">
                      <label for="title">글 제목</label>
                      <input type="text" name="title" placeholder="글 제목" required="required" value="">
                      <label for=" price">가격</label>
                      <input type="text" name="price" placeholder="가격" required="required" value="">
                      <label for="category" class="block-box">카테고리</label>
						<select name="category" required="required">
						    <option value="" selected>카테고리 선택</option>
						    <option value="1">의류</option>
						    <option value="2">가구</option>
						    <option value="3">디지털기기</option>
						    <option value="4">기타</option>
						</select>
                    </div>
                  </div>
                </div>
                <div class="full-box">
                  <label for="content" class="block-box">물품 설명</label>
                  <textarea name="content" required="required">

                  </textarea>

                </div>
                <div class="full-box">
                  <label for="region" class="block-box">거래 희망 장소</label>
                  <input type="text" name="region" placeholder="거래를 희망하는 장소" required="required" value="">
                </div>
                <div class="submit-button-box">

                    <button type="submit">수정하기</button>
                    <button type="submit">전송</button>
                </div>
              </form>
            </div>
          </div>

        <script type="text/javascript" src="{% static 'js/write.js' %}"></script>
</body>
</html>