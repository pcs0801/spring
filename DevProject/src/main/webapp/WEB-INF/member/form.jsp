<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<body>
	<header>
		<h1>form.jsp 입니다.</h1>
	</header>
	<main>
		<form action ="/member/submit" method = "POST">
			NAME : <input type = "text" name = "name">
			<button type = "submit"> 전송 </button>
		</form>
	</main>
	<hr>
	<footer>
		<h1>footer</h1>
	</footer>
</body>
</html>