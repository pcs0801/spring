<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 헤더영역 -->
<%@ include file="./header.jsp"%>

<!-- 화면영역 -->
<main>
	<h2>List</h2>
	<a href="register">게시판입력</a>
	<table border="1">
		<tr>
			<th align="center" width="80">번호</th>
			<th align="center" width="150">제목</th>
			<th align="center" width="150">작성자</th>
			<th align="center" width="300">내용</th>
			<th align="center" width="200">등록일자</th>
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
						<td align="center">${board.no}</td>
						<td align="center"><a href="/board/read?no=${board.no}">${board.title}</a></td>
						<td align="center">${board.writer}</td>
						<td align="center">${board.content}</td>
						<td align="center"><fmt:formatDate pattern="yyyy-MM-dd"
								value="${board.regDate}" /></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</main>

<!-- 푸터영역 -->
<%@ include file="./footer.jsp"%>