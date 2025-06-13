<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/nationSelect" method="post">
		국적 : <select name="nationality" multiple>
			<option value="Korea" Selected>대한민국</option>
			<option value="UK">영국</option>
			<option value="USA">미국</option>
			<option value="Japan">일본</option>
		</select> <br> <input type="submit" name="nationSelect">
	</form>

</body>
</html>