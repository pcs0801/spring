<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링부트 연습</title>
</head>
<body>
<form action="/views/info" method="post">
	이름 : <input type="text" name="name" /><br>
	나이 : <input type="number" name="age" /><br>
	이메일 : <input type="email" name="email" /><br>
	<button type="submit">제출</button>
	</form>
</body>
</html>