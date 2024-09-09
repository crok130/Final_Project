var currentSlideIndex = 0;
var slides = [];

function previewImages(event) {
    var files = event.target.files;
    var preview = document.getElementById('image-preview');
    var uploadButton = document.querySelector('.image-upload-btn');
    var slideControls = document.querySelector('.slide-controls'); // 슬라이드 제어 영역
    var pagination = document.getElementById('pagination'); // 페이지네이션

    slides = []; // 슬라이드 배열 초기화
    currentSlideIndex = 0; // 현재 슬라이드 인덱스 초기화

    preview.innerHTML = ""; // 기존 미리보기를 초기화

    if (files.length > 0) {
        preview.style.display = 'flex'; // 미리보기 영역을 표시
        slideControls.style.display = 'flex'; // 이미지가 있으면 슬라이드 버튼 표시
        pagination.style.display = 'block'; // 페이지네이션도 표시
    } else {
        preview.style.display = 'none'; // 파일이 없으면 미리보기 영역을 숨김
        slideControls.style.display = 'none'; // 슬라이드 버튼도 숨김
        pagination.style.display = 'none'; // 페이지네이션 숨김
    }

    for (var i = 0; i < files.length; i++) {
        var file = files[i];
        var reader = new FileReader();
        reader.onload = (function(index) {
            return function(e) {
                slides.push(e.target.result); // 슬라이드에 이미지 추가
                if (index === 0) {
                    showSlide(currentSlideIndex); // 첫 번째 이미지를 표시
                }
                updatePagination();
                updateButtons();
            }
        })(i);
        reader.readAsDataURL(file);
    }

    if (files.length > 0) {
        uploadButton.style.display = 'none'; // 이미지 등록 버튼 숨기기
    }
}

function showSlide(index) {
    var preview = document.getElementById('image-preview');
    preview.innerHTML = ""; // 기존 이미지를 제거
    var img = document.createElement('img');
    img.src = slides[index];
    
    // 이미지 스타일 크기 및 마진 설정
    img.style.width = "400px";
    img.style.height = "300px";
    img.style.margin = "10px";
    
    preview.appendChild(img);
}

function changeSlide(direction) {
    currentSlideIndex += direction;
    if (currentSlideIndex < 0) currentSlideIndex = slides.length - 1; // 처음으로 되돌아감
    if (currentSlideIndex >= slides.length) currentSlideIndex = 0; // 마지막에서 처음으로 돌아감
    showSlide(currentSlideIndex);
    updatePagination();
    updateButtons();
}

function updatePagination() {
    var pagination = document.getElementById('pagination');
    pagination.innerHTML = (currentSlideIndex + 1) + " / " + slides.length;
}

function updateButtons() {
    var prevBtn = document.querySelector('.prev-btn');
    var nextBtn = document.querySelector('.next-btn');
    prevBtn.disabled = currentSlideIndex === 0;
    nextBtn.disabled = currentSlideIndex === slides.length - 1;
}

function setStatus() {
    var freeCheck = document.getElementById("free-check");
    var statusInput = document.getElementById("status");
    if (freeCheck.checked) {
        statusInput.value = "나눔";
    } else {
        statusInput.value = "판매중";
    }
}

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