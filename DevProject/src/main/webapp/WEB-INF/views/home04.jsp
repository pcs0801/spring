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
		<h1>☆★☆★ home04.jsp HEADER 영역 ☆★☆★</h1>
	</header>
	<hr>

	<main>
		<h1>NAME 문자열 배열 출력</h1>
		<%
		String[] nameArray = (String[]) request.getAttribute("name");
		for (String data : nameArray) {
		%>
		<p>
			<%=data%>
		</p>
		<%
		}
		%>

		<h1>NAME 문자열 배열 첨자 형식 출력</h1>
		<h2>${name[0]}</h2>
		<h2>${name[1]}</h2>
		<h2>${name[2]}</h2>

		<h1>NAME 문자열 배열 출력</h1>
		<c:forEach var="data" items="${name}">
			<h2>
				<c:out value="${data}" />
			</h2>
		</c:forEach>
		<h1>NAMELIST LIST 출력</h1>
		<c:forEach var="data" items="${nameList}">
			<h2>
				<c:out value="${data}" />
			</h2>
		</c:forEach>
		<h1>NAMELIST LIST 첨자 형식 출력</h1>
		<h2>${nameList[0]}</h2>
		<h2>${nameList[1]}</h2>
		<h2>${nameList[2]}</h2>
	</main>

	<hr>
	<footer>
		<h1>☆★☆★ FOOTER 영역 ☆★☆★</h1>
	</footer>
</body>
</html>