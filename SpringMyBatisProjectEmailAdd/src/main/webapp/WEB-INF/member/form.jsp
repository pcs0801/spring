<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="./header.jsp"%>
<!-- 화면영역 -->
<main>
	<h2>유저 목록</h2>
	<a href="register">유저 입력</a>
	<table border="1">
		<tr>
			<th align="center" width="80">번호</th>
			<th align="center" width="150">아이디</th>
			<th align="center" width="150">비밀번호</th>
			<th align="center" width="150">이름</th>
			<th align="center" width="150">등록일자</th>
		</tr>

		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="4">List is empty.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="member">
					<tr>
						<td align="center">${member.no}</td>
						<td align="left"><a href="/member/read?no=${member.no}">${board.id}</a></td>
						<td align="right">${member.pw}</td>
						<td align="right">${member.name}</td>
						<td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${member.regDate}" /></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</table>
</main>
<%@ include file="./footer.jsp"%>
