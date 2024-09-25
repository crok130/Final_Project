<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sweetpotato.member.vo.*" %>
<%
	MemberVO userInfo = (MemberVO) session.getAttribute("userInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="resources/css/reset.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/footer.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/mypage2.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/nav.css"/>
  <link rel="stylesheet" type="text/css" href="resources/css/global.css"/>
<title>마이페이지</title>
</head>
<body>
    <%@ include file="nav.jsp" %>
    <div id="gnb-root">
        <!-- 네비게이션 메뉴 코드 (생략) -->
    </div>
    <section id="content">
        <section id="user-profile">
            <h2 id="nickname">
			    ${userInfo.membername} <!-- 사용자 이름 -->
			    <span id="region_name">
			        ${userInfo.memberaddr} <!-- 사용자 주소 -->
			    </span>
			</h2>
            <ul id="profile-detail">
                <li class="profile-detail-title">매너온도 <span class="profile-detail-count">100 °C</span></li>
            </ul>
            <div id="profile-image">
                    <img alt="프로필 이미지" src="https://d1unjqcospf8gs.cloudfront.net/assets/users/default_profile_80-c649f052a34ebc4eee35048815d8e4f73061bf74552558bb70e07133f25524f9.png" />
            </div>
            <div>
            	<!-- 프로필 수정하기 버튼 -->
                <a href="editProfile">
                    <button id="edit-profile-button">프로필 수정하기</button>
                </a>
                <!-- 비밀번호 수정하기 버튼 -->
                <a href="forgotPassword">
                	<button id="edit-profile-button">비밀번호 수정하기</button>
                </a>
			</div>
        </section>
        <div id="user-records-detail">
            <section id="user-filter">
                <ul>
                    <li><a class="active" href="#proceed-products-tab">판매중</a></li>
                    <li><a href="#products-tab">판매완료</a></li>
                    <li><a href="#reviews-tab">거래후기</a></li>
                </ul>
            </section>
            <!-- 판매 중인 상품 -->
            <div id="proceed-products-tab">
                <div class="container column center">
                  <div class="full-box trade-box column">
                    <div class="flex-box full-box card-container between">
                        <c:forEach var="product" items="${proceedProducts}">
                        <div class="card-box">
                          <a href="tradePost?id=${product.id}" class="trade-text-link">
                              <div class="card-img">
                                      <img src="${product.imageUrl}" alt="${product.name}">   
                              </div>
                              <div class="card-info-box">
                                  <h5>${product.name}</h5>
                                  <p class="bold">${product.price}원</p>
                                  <p>${product.location}</p>
                                  <div class="flex-box">
                                      <p>조회 ${product.views}</p>
                                      <p>·</p>
                                      <p>채팅 ${product.chats}</p>
                                  </div>
                              </div>
                          </a>
                        </div>
                        </c:forEach>
                    </div>
                  </div>
                </div>
              </div>
             <!-- 판매완료 상품 -->
              <div id="products-tab" style="display: none;">
                <div class="container column center">
                  <div class="full-box trade-box column">
                    <div class="flex-box full-box card-container between">
                        <c:forEach var="product" items="${completedProducts}">
                        <div class="card-box">
                          <a href="tradePost?id=${product.id}" class="trade-text-link">
                              <div class="card-img">   
                                      <img src="${product.imageUrl}" alt="${product.name}">
                              </div>
                              <div class="card-info-box">
                                  <h5>${product.name}</h5>
                                  <p class="bold">${product.price}원</p>
                                  <p>${product.location}</p>
                                  <div class="flex-box">
                                      <p>조회 ${product.views}</p>
                                      <p>·</p>
                                      <p>채팅 ${product.chats}</p>
                                  </div>
                              </div>
                          </a>
                        </div>
                        </c:forEach>
                    </div>
                  </div>
                </div>
              </div>

               <!-- 거래후기  -->
              <div id="reviews-tab" style="display: none;">
                <section id="user-records" class="user-reviews" data-total-page="1" data-current-page="1">
                    <ul id="reviews-list">
                        <c:forEach var="review" items="${userReviews}">
                        <li class="review">
                            <div class="review-profile-photo">
                                    <img alt="${review.writerName}" src="${review.writerImage}" />
                            </div>

                            <div class="review-details">
                                <div class="review-writer-info">
                                    <div class="review-writer-nickname">
                                        <a href="#">${review.writerName}</a>
                                    </div>
                                    <div class="review-writer-region-name">
                                        ${review.writerLocation}
                                    </div>
                                </div>
                                <div class="review-content">
                                    <p>
                                        ${review.content}
                                    </p>
                                </div>
                                <div class="review-time">
                                    ${review.createdAt}
                                </div>
                            </div>
                        </li>
                        </c:forEach>
                    </ul>
                </section>
             </div>
        </div>
    </section>
    <%@ include file="footer.jsp" %>
</body>
</html>
