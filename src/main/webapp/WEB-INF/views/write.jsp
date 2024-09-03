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
            align-items: flex-start;
            height: 100vh;
        }

        header {
            width: 100%;
            position: fixed;
            top: 0;
            left: 0;
            z-index: 1000;
            background-color: #fff;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        #container {
            width: 720px;
            padding: 30px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 100px;
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
            flex: 1;
            margin-right: 30px;
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
            margin-left: 10px;
        }
        
        #product-price::placeholder{
        	text-align: right;
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
        <form id="boardForm" enctype="multipart/form-data">
            <h2 class="editor-title">팔래요 등록하기</h2>
            <p class="editor-sub-title">썸네일을 포함한 이미지를 1장 이상 업로드 해주세요. (최대 5장)</p>

            <!-- 이미지 업로드 섹션 -->
            <div class="image-upload-section">
            	<div id="image-preview"></div>
                <button type="button" class="image-upload-btn" onclick="document.getElementById('image-uploader').click()">이미지 등록</button>
                <input id="image-uploader" type="file" name="img" style="display: none;" multiple onchange="previewImages(event)" />
            </div>

    <script>
	    function previewImages(event) {
	        var files = event.target.files;
	        var preview = document.getElementById('image-preview');
	        preview.innerHTML = "";
	
	        for (var i = 0; i < files.length; i++) {
	            var file = files[i];
	            var reader = new FileReader();
	            reader.onload = function(e) {
	                var img = document.createElement('img');
	                img.src = e.target.result;
	                img.style.width = "100px";
	                img.style.height = "100px";
	                img.style.margin = "10px";
	                preview.appendChild(img);
	            }
	            reader.readAsDataURL(file);
	        }
	    }
	</script>
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
                    <input type="checkbox" id="free-check" name="freeCheck" onclick="setStatus()"/>
                </label>
            </div>
            <input type="hidden" id="status" name="status" value="판매중" />
            
            <script>
                function setStatus() {
                    var freeCheck = document.getElementById("free-check");
                    var statusInput = document.getElementById("status");
                    if (freeCheck.checked) {
                        statusInput.value = "나눔";
                    } else {
                        statusInput.value = "판매중";
                    }
                }
            </script>

            <!-- 카테고리 선택 -->
            <label for="product-price" style="font-weight: bold; margin-bottom: 7px;">카테고리*</label>
            <br/>
            <div class="input-group input-group-horizontal">
                <select id="main_category" name="main_category" onchange="updateSubCategory()">
                    <option value="" style="font-weight: bold;">메인분류</option>
                    <option value="신발">신발</option>
                    <option value="가전제풀">가전제품</option>
                    <option value="시계/쥬얼리">시계/쥬얼리</option>
                    <option value="스포츠/레저">스포츠/레저</option>
                    <option value="의류">의류</option>
                    <option value="가구">가구</option>
                </select>
                 <select id="sub_category" name="sub_category">
                    <option value="0">서브분류</option>
                </select>
            </div>

            <script>
            function updateSubCategory() {
                const subCategory = document.getElementById("sub_category");
                const mainCategory = document.getElementById("main_category").value;

                sub_category.innerHTML = '<option value="">서브분류</option>';

                let options = [];
                if (mainCategory == "신발") {
                    options = ["스니커즈", "운동화", "슬리퍼", "크록스", "구두"];
                } else if (mainCategory == "가전제풀") {
                    options = ["냉장고", "TV", "에어컨", "핸드폰"];
                } else if (mainCategory == "시계/쥬얼리") {
                    options = ["시계", "목걸이", "반지", "팔찌"];
                } else if (mainCategory == "스포츠/레저") {
                    options = ["캠핑", "등산", "자전거", "골프"];
                } else if (mainCategory == "의류") {
                    options = ["티셔츠", "바지", "자켓", "원피스"];
                } else if (mainCategory == "가구") {
                    options = ["침대", "소파", "책상", "의자"];
                }

                // 서브 카테고리 옵션 추가
                for (let i = 0; i < options.length; i++) {
                    const option = document.createElement("option");
                    option.value = options[i];
                    option.text = options[i];
                    subCategory.appendChild(option);
                }
            }
            </script>

            <!-- 내용 입력 -->
            <div class="input-group">
                <label for="product-content">내용*</label>
                <textarea id="product-content" name="content" placeholder="물품 상세 정보를 입력해주세요. (최대 500자)"></textarea>
            </div>

            <!-- 거래희망장소 -->
            <div class="input-group">
                <label for="hashtag-input">거래장소*</label>
                <input type="text" id="hashtag-input" name="region" placeholder="희망거래장소를 적으세요" />
            </div>

            <!-- 버튼 섹션 -->
            <div class="button-container">
                <button type="submit" class="submit-btn" onclick="submitForm(event)">등록하기</button>
                <button type="button" class="cancel-btn">취소하기</button>
            </div>
        </form>
    </div>
<script>
    function submitForm(event) {
        event.preventDefault();  // 폼의 기본 제출 동작을 막습니다.

        var form = document.getElementById('boardForm');
        var formData = new FormData(form);

        // AJAX 요청 생성
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "write", true);
        xhr.onload = function() {
            if (xhr.status === 200) {
                alert("등록 완료!");
                window.location.href = "trade";
            } else {
                alert("등록 실패");
            }
        };
        xhr.onerror = function() {
            alert("서버와의 통신 중 오류가 발생했습니다.");
        };
        xhr.send(formData);
    }
</script>
</body>
</html>
