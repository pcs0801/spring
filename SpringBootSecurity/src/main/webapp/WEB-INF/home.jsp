<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 시큐리티</title>
</head>
<body>
	<h1>환영합니다!</h1>
	<P>서버의 시간은 ${serverTime} 입니다.</P>
	<a href="board/list">회원 게시판</a>
	<br>
	<a href="notice/list">공지사항</a>
	<br>
	<!-- 로그인을 하지 않은 경우 -->
	<sec:authorize access="isAnonymous()">
		<a href="/login">로그인</a>
	</sec:authorize>
	<br>
	<!-- 인증된 사용자인 경우 true -->
	<sec:authorize access="isAuthenticated()">
		<a href="/logout">로그아웃</a>
	</sec:authorize>
</body>
</html>