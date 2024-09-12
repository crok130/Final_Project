<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<nav>
  <div class="container">
    <div class="full-box flex-box between">
      <div class="flex-box">
        <div class="logo">
          <a href="main">
            <img src="resources/img/lolo.png" alt=""/>
          </a>
        </div>
        <div class="nav-buttons">
          <a href="trade">
            <button id="trade-button">중고거래</button>
          </a>
            <a href="location">
              <button id="location-button">동네인증</button>
			</a>

        </div>
      </div>
      <div class="flex-box gap8">
        <form method="POST" action="search">
          <input type="text" id="search" name="search" class="search" placeholder="물품이나 동네를 검색해보세요"/>
        </form>
          <a href="chat" class="ghost-button orange">채팅하기</a>
          <a href="mypage" class="ghost-button">내 페이지</a>
          <a href="#" class="ghost-button">로그아웃</a>
          <a href="login" class="ghost-button" style="color: #1e1e1e">로그인</a>

      </div>
    </div>
  </div>
  <script src="#"></script>
</nav>
