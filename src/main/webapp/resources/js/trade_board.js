var currentIndex = 0;
var images = document.getElementsByClassName("slider-image");
var totalSlides = images.length;
var currentSlideElement = document.getElementById("current-slide");

function showSlide(index) {
    for (var i = 0; i < images.length; i++) {
        images[i].classList.remove("active");
    }
    images[index].classList.add("active");

    // 현재 이미지 번호 업데이트
    currentSlideElement.innerText = index + 1;
}

function nextSlide() {
    currentIndex = (currentIndex + 1) % images.length;
    showSlide(currentIndex);
}

function prevSlide() {
    currentIndex = (currentIndex - 1 + images.length) % images.length;
    showSlide(currentIndex);
}