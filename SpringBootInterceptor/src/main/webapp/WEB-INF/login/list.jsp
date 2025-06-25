<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- 헤더영역 -->
<%@ include file="./header.jsp"%>

<!-- 화면영역 -->
<main>
	<h3>회원 목록</h3>
	<a href="register">신규 등록</a>
	<table border="1">
		<tr>
			<th align="center" width="60">번호</th>
			<th align="center" width="80">아이디</th>
			<th align="center" width="50">비밀번호</th>
			<th align="center" width="50">이름</th>
			<th align="center" width="180">등록일자</th>
		</tr>
		<c:forEach items="${list}" var="member">
			<tr>
				<td align="center">${member.no}</td>
				<td align="center"><a href='/member/read?no=${member.no}'>${member.id}</a></td>
				<td align="center">${member.pw}</td>
				<td align="center">${member.name}</td>
				<td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
						value="${member.regDate}" /></td>
			</tr>
		</c:forEach>
	</table>
</main>

<!-- 푸터영역 -->
<%@ include file="./footer.jsp"%>