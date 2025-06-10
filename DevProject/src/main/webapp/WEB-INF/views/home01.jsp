<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<main>
		<h2>현재 한국 시간은 ${serverTime}</h2>
		<p>boardNo ${board.boardNo}</p>
		<p>title ${board.title}</p>
		<p>content ${board.content}</p>
		<p>writer ${board.writer}</p>
		<p>regDate ${board.regDate}</p>
	</main>

</body>
</html>