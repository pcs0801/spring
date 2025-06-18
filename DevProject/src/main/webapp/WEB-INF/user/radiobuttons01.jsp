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
		<h1>user - radiobuttons01.jsp 입니다.</h1>
	</header>
	<main>
		<form:form modelAttribute="user" method="post" action="user/register">
			<table>
				<tr>
					<td>성별</td>
					<td><form:radiobuttons path="gender" items="${genderCodeMap}" />
					</td>
				</tr>
			</table>
			<form:button name="register">등록</form:button>
		</form:form>
	</main>
	<hr>
	<footer>
		<h1>footer</h1>
	</footer>
</body>
</html>