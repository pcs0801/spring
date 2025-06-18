<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<body>
	<header>
		<h1>user - resultForm.jsp 입니다.</h1>
	</header>
	<main>
		<h3>Spring Form Result</h3>
		<table border="1">
			<tr>
				<td>유저ID</td>
				<td>${user.userId}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${user.userName}</td>
			</tr>
			<tr>
				<td>유저PW</td>
				<td>${user.userPassword}</td>
			</tr>
			<tr>
				<td>소개</td>
				<td>${user.introduction}</td>
			</tr>
			<tr>
				<td>취미</td>
				<td><c:forEach var="hobby" items="${user.cbList}">
						<c:out value="${hobby}" />
						<br>
					</c:forEach></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>${user.gender}</td>
			</tr>
		</table>
	</main>
	<hr>
	<footer>
		<h1>footer</h1>
	</footer>
</body>
</html>