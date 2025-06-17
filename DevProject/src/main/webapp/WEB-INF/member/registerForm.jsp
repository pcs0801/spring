<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 화면 영역 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<body>
	<header>
		<h1>registerForm.jsp 입니다.</h1>
	</header>
	<main>
		<h1>registerForm Home</h1>
		<form action="/member/register" method="post">
			userId: <input type="text" name="userId" value="hong"><br>
			password: <input type="text" name="password" value="1234"><br>
			dateOfBirth: <input type="text" name="dateOfBirth" value="20001020"><br>
			<input type="submit" value="register">
		</form>

		<hr>
		<form action="/registerBoard" method="post">
			userId: <input type="text" name="userId" value="hong"><br>
			password: <input type="text" name="password" value="1234"><br>
			dateOfBirth: <input type="text" name="dateOfBirth" value="20001020"><br>
			boardNo: <input type="text" name="board.boardNo" value="2000"><br>
			<input type="submit" value="register">
		</form>

		<hr>
		<form action="/member/registerFileUpload" method="post" enctype="multipart/form-data">
			userId: <input type="text" name="userId" value="hong"><br>
			password: <input type="text" name="password" value="1234"><br>
			file: <input type="file" name="image" multiple="multiple">
			<input type="submit" value="register">
		</form>
	</main>
	<hr>
	<footer>
		<h1>footer</h1>
	</footer>
</body>
</html>