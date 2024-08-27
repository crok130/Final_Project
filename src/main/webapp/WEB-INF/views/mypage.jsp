<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="resources/css/reset.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/footer.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/mypage2.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/nav.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/global.css"/>
<title>Insert title here</title>
</head>
<body>
    <%@ include file="nav.jsp" %>
    <div id="gnb-root">
        <!-- 네비게이션 메뉴 코드 (생략) -->
    </div>
    <section id="content">
        <section id="user-profile">
            <h2 id="nickname">
                최수빈
                <span id="region_name">
                    부산수영구  
                </span>
            </h2>
            <ul id="profile-detail">
                <li class="profile-detail-title">매너온도 <span class="profile-detail-count">100 °C</span></li>
            </ul>
            <div id="profile-image">
                    <img alt="동동히" src="https://d1unjqcospf8gs.cloudfront.net/assets/users/default_profile_80-c649f052a34ebc4eee35048815d8e4f73061bf74552558bb70e07133f25524f9.png" />
            </div>
                <a href="#" >
                    <button id="edit-profile-button">프로필 수정하기</button>
                </a>
        </section>
        <div id="user-records-detail">
            <section id="user-filter">
                <ul>
                    <li><a class="active" href="#proceed-products-tab">판매중 </a></li>
                    <li><a href="#products-tab">판매완료 링크</a></li>
                    <li><a href="#reviews-tab">거래후기 링크</a></li>
                </ul>
            </section>
            <!-- 판매 물품 -->
            <div id="proceed-products-tab">
                <div class="container column center">
                  <div class="full-box trade-box column">
                    <div class="flex-box full-box card-container between">
                        <div class="card-box">
                          <a href="#" class="trade-text-link">
                              <div class="card-img">
                                      <img src="" alt="판매완료상품이미지">   
                              </div>
                              <div class="card-info-box">
                                  <h5>2000원팝니다</h5>
                                  <p class="bold">2500원</p>
                                  <p>부산광안리</p>
                                  <div class="flex-box">
                                      <p>조회 30</p>
                                      <p>·</p>
                                      <p>채팅 4</p>
                                  </div>
                              </div>
                          </a>
                        </div>
                      
            
                    </div>
                  </div>
                </div>
              </div>
             <!-- 판매완료 물품 -->
              <div id="products-tab" style="display: none;">
                <div class="container column center">
                  <div class="full-box trade-box column">
                    <div class="flex-box full-box card-container between">
                        <div class="card-box">
                          <a href="{% url 'trade_post' product.id %}" class="trade-text-link">
                              <div class="card-img">   
                                      <img src="" alt="상품이미지">
                              </div>
                              <div class="card-info-box">
                                  <h5>콘스탄틴 어베인팝니다</h5>
                                  <p class="bold">700000원</p>
                                  <p>부산수영구</p>
                                  <div class="flex-box">
                                      <p>조회 7</p>
                                      <p>·</p>
                                      <p>채팅 2</p>
                                  </div>
                              </div>
                          </a>
                        </div>
                    </div>
                  </div>
                </div>
              </div>

               <!-- 거래후기  -->
              <div id="reviews-tab" style="display: none;">
                <section id="user-records" class="user-reviews" data-total-page="1" data-current-page="1">
                    <ul id="reviews-list">
                        <li class="review">
                            <div class="review-profile-photo">
                                    <img alt="동동히" src="https://d1unjqcospf8gs.cloudfront.net/assets/users/default_profile_80-c649f052a34ebc4eee35048815d8e4f73061bf74552558bb70e07133f25524f9.png" />
                                
                            </div>

                            <div class="review-details">
                                <div class="review-writer-info">
                                    <div class="review-writer-nickname">
                                        <a href="#">리뷰남긴사람</a>
                                    </div>
                                    <div class="review-writer-region-name">
                                        리뷰자사는곳
                                    </div>
                                </div>
                                <div class="review-content">
                                    <p>
                                        리뷰내용
                                    </p>
                                </div>
                                <div class="review-time">
                                    {{review.created_at}}
                                </div>
                            </div>
                        </li>
                        <!-- 다른 리뷰들도 동일한 구조로 추가할 수 있습니다. -->
                    </ul>
                </section>
                <!-- 거래 후기 내용을 표시하는 코드 (생략) -->
             </div>
        </div>
    </section>
    <%@ include file="footer.jsp" %>
</body>
</html>