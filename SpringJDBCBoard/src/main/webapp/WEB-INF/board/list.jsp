<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 헤더영역 -->
<%@ include file="./header.jsp"%>

<!-- 화면영역 -->
<main>
	<h2>List</h2>
	<a href="/board/registerForm">게시판입력</a>
	<table border="1">
		<tr>
			<th align="center" width="80">NO</th>
			<th align="center" width="320">TITLE</th>
			<th align="center" width="100">WRITER</th>
			<th align="center" width="180">REGDATE</th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="4">List is empty.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="board" items="${list}">
					<tr>
						<td align="center">${member.no}</td>
						<td align="left"><a
							href="/member/read?memberNo=${member.no}">${member.id}</a></td>
						<td align="right">${board.pwd}</td>
						<td align="right">${board.name}</td>
						<td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${member.regDate}" /></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</main>

<!-- 푸터영역 -->
<%@ include file="./footer.jsp"%>