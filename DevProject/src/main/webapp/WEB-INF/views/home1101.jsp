<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<!-- 서비스 영역  -->
<%
// 지역 객체 참조 변수
Date date = new Date();
DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.KOREA);
String serverTime = df.format(date);
%>


<!-- 화면 영역  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>☆★☆★ home0303.jsp HEADER 영역 ☆★☆★</h1>
	</header>
	<hr>

	<main>
		<H4>절대 URL</H4>
		<c:redirect url="http://localhost:8080/boardjstl/list" />
		<h4>redirect 이후의 코드는 실행되지 않는다.</h4>
	</main>

	<hr>
	<footer>
		<h1>☆★☆★ FOOTER 영역 ☆★☆★</h1>
	</footer>
</body>
</html>