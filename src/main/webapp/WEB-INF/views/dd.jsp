<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>팔래요 등록하기</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: flex-start; /* 변경: flex-start로 변경하여 컨텐츠가 화면 상단에서 시작하도록 설정 */
            height: 100vh;
        }

        header {
            width: 100%;
            position: fixed;
            top: 0;
            left: 0;
            z-index: 1000; /* 헤더를 다른 요소들 위로 올리기 위해 z-index 추가 */
            background-color: #fff; /* 헤더 배경색 설정 */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* 헤더에 그림자 추가 */
        }

        #container {
            width: 720px;
            padding: 30px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 100px; /* 변경: 헤더 아래에 공간 확보를 위해 margin-top 추가 */
        }

        .editor-title {
            font-size: 26px;
            font-weight: bold;
            margin-bottom: 15px;
        }

        .editor-sub-title {
            font-size: 16px;
            color: #555;
            margin-bottom: 25px;
        }

        .image-upload-section {
            display: flex;
            align-items: center;
            margin-bottom: 25px;
        }

        .image-upload-btn {
            background-color: #eee;
            width: 900px;
            padding: 10px;
            border: none;
            cursor: pointer;
            font-weight: bold;
        }

        .file-selection-info {
            color: #555;
        }

        .input-group {
            margin-bottom: 20px;
        }

        .input-group-horizontal {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }

        .input-group-horizontal input[type="text"] {
            flex: 1; /* 입력창 크기를 줄입니다 */
            margin-right: 30px; /* 가격 입력창과 무료나눔 사이의 여백을 늘립니다 */
        }

        .input-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 7px;
        }

        .input-group input[type="text"], .input-group select, .input-group textarea {
            width: 98%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .input-group-horizontal select {
            margin-right: 7px;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .input-group textarea {
            height: 140px;
        }

        .button-container {
            display: flex;
            justify-content: space-between;
        }

        .submit-btn, .cancel-btn {
            width: 48%;
            padding: 14px;
            background-color: #fff;
            border: 1px solid #007BFF;
            border-radius: 4px;
            cursor: pointer;
            color: #007BFF;
            font-weight: bold;
        }

        .submit-btn:hover, .cancel-btn:hover {
            background-color: #007BFF;
            color: #fff;
        }

        .inline-label {
            display: flex;
            align-items: center;
            white-space: nowrap;
        }

        .inline-label input {
            margin-left: 10px; /* 체크박스를 글자 뒤로 조금 더 이동 */
        }
    </style>
    <link rel="stylesheet" type="text/css" href="resources/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/nav.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/global.css"/>
</head>
<body>
    <header><%@ include file="nav.jsp" %></header>
    <div id="container">
        <form action="write" method="post">
            <h2 class="editor-title">팔래요 등록하기</h2>
            <p class="editor-sub-title">썸네일을 포함한 이미지를 1장 이상 업로드 해주세요. (최대 5장)</p>

            <!-- 이미지 업로드 섹션 -->
            <div class="image-upload-section">
                <button type="button" class="image-upload-btn">이미지 등록</button>
                <input id="image-uploader" type="file" style="display: none;" />
            </div>

            <!-- 제목 입력 -->
            <div class="input-group">
                <label for="title">제목*</label>
                <input type="text" name="title" placeholder="글 제목" required="required" value="">
            </div>

            <!-- 가격 및 무료나눔 -->
            <label for="product-price" style="display: block; font-weight: bold; margin-bottom: 7px;">가격*</label>
            <div class="input-group input-group-horizontal">
                <input type="text" id="product-price" name="price" placeholder="원" />
                <label class="inline-label">
                    무료나눔
                    <input type="checkbox" id="free-check" name="freeCheck" />
                </label>
            </div>

            <!-- 카테고리 선택 -->
            <label for="product-price" style="font-weight: bold; margin-bottom: 7px;">카테고리*</label>
            <br/>
            <div class="input-group input-group-horizontal">
                <select id="large-category" name="category">
                    <option value="0">대분류</option>
                </select>
            </div>

            <!-- 내용 입력 -->
            <div class="input-group">
                <label for="product-content">내용*</label>
                <textarea id="product-content" name="content" placeholder="물품 상세 정보를 입력해주세요. (최대 500자)"></textarea>
            </div>

            <!-- 거래희망장소 -->
            <div class="input-group">
                <label for="hashtag-input">거래장소*</label>
                <input type="text" id="hashtag-input" name="region" placeholder="희망거래장소를적으세요" />
            </div>

            <!-- 버튼 섹션 -->
            <div class="button-container">
                <button type="submit" class="submit-btn">등록하기</button>
                <button type="button" class="cancel-btn">취소하기</button>
            </div>
        </form>
    </div>
</body>
</html>
