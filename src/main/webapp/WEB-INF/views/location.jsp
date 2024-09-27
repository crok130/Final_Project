<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="resources/css/reset.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/footer.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/location.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/nav.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/global.css"/>
  <link rel="shortcut icon" type="image/x-icon" href="https://blog.kakaocdn.net/dn/S0wSJ/btqDogzoUNX/kZBkpKPGjdGKJSvKKs35D0/img.png">
  <title>동네인증</title>
</head>
<body class="back-ye">
  <header><%@ include file="nav.jsp" %></header>
    <div class="messages">
        <div class="" ></div>
    </div>


  <div class="content-box">
    <div class="container column center">
      <div class="region-setting-box full-box">
        <label for="region-setting">동네 설정</label>
        <form id="region-form">
          <div class="flex-box full-box between region-input">
            <input type="text" id="region-setting" class="region-setting" name="region-setting"
              placeholder="예) 서울 강서구 화곡동" value=""/>
            <button type="button" class="ghost-button orange region-setting" style="width=15%" id="set-region-button" onclick="userMap();">
               수정  저장 
            </button>
          </div>
        </form>
      </div>

      <div id="map" style="width:100%; height:468px; margin-top:44px;"></div>
      <h5 id="region-info">현재 위치</h5>
      <h5 id="region-judge"></h5>
      <form id="region-certification-form" action="/set_region_certification/" class="full-box">
        <button id="region-save-button" class="primary-button">동네인증하기</button>
      </form>
    </div>
  </div>
  <footer><%@ include file="footer.jsp" %></footer>

    <!--카카오 api key-->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3b519bd660eac99c3b8c17fc5975dff9&libraries=services"></script>
    <script>
      let regionSaveButton = document.getElementById("region-save-button");
      //지도 현재위치로 보여주기
      let mapContainer = document.getElementById("map"),
      mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 6, // 지도의 확대 레벨
      };

      let map = new kakao.maps.Map(mapContainer, mapOption); // 지도 생성
      // HTML5의 geolocation으로 사용할 수 있는지 확인


// 지도에 마커와 인포윈도우를 표시하는 함수
function displayMarker(locPosition, message) {
  // 마커 생성
  let marker = new kakao.maps.Marker({ map: map, position: locPosition });

  let iwContent = message, // 인포윈도우에 표시할 내용
    iwRemoveable = true;

  // 인포윈도우를 생성
  let infowindow = new kakao.maps.InfoWindow({
    content: iwContent,
    removable: iwRemoveable,
  });

  // 인포윈도우를 마커위에 표시
  infowindow.open(map, marker);

  // 지도 중심좌표를 접속위치로 변경
  map.setCenter(locPosition);
}


document.getElementById("region-form").addEventListener("submit", function (e) {
  e.preventDefault();

  let region = document.querySelector('input[name="region-setting"]').value;

  if (region.trim()) {
    this.submit();
  } else {
    alert("지역을 입력해주세요");
  }
});

regionSaveButton.addEventListener("click", function () {
  alert("인증이 완료되었습니다");
});

userMap();
function userMap() {
	  if (navigator.geolocation) {
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(
	      function (position) {
	        let lat = position.coords.latitude; // 위도
	        let lon = position.coords.longitude; // 경도

	        let locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	          message = '<div style="padding:5px;">현재 위치</div>'; // 인포윈도우에 표시될 내용입니다

	        // 마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition, message);

	        // 위치 정보를 주소로 변환하여 표시
	        GetAddr(lat, lon);
	      },
	      function (error) {
	        console.error("위치 정보를 가져오는 데 실패했습니다.", error);
	      },
	      {
	        enableHighAccuracy: true, // 위치 정보를 더 정확하게 가져옵니다
	        timeout: 5000, // 5초 이내에 위치 정보를 가져오지 못하면 오류 발생
	        maximumAge: 0, // 캐시된 위치 정보 사용 안함
	      }
	    );
	  } else {
	    // GeoLocation을 사용할 수 없을 때
	    let locPosition = new kakao.maps.LatLng(33.450701, 126.570667),
	      message = "사용자 환경문제로 위치정보를 사용할 수 없습니다";
	    displayMarker(locPosition, message);
	  }
	}

    </script>
  </body>
</html>