<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 헤더영역 -->
<%@ include file="./header.jsp"%>

<!-- 화면영역 -->
<main>
	<h2>List</h2>
	<a href="register">멤버 입력</a>
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
					<td align="center" colspan="5">List is empty.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="member" items="${list}">
					<tr>
						<td align="center">${member.no}</td>
						<td align="center"><a href="/member/read?no=${member.no}">${member.id}</a></td>
						<td align="center">${member.pw}</td>
						<td align="center">${member.name}</td>
						<td align="center"><fmt:formatDate pattern="yyyy-MM-dd"
								value="${member.regDate}" /></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</main>

<!-- 푸터영역 -->
<%@ include file="./footer.jsp"%>