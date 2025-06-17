<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 헤더영역 -->
<%@ include file="./header.jsp"%>

<!-- 화면영역 -->
<main>
	<h2>── 유저 전체 목록 ──</h2>
	<a href="/member/registerForm">▶ 유저 신규등록</a>
	<table border="1">
		<tr>
			<th align="center" width="60">NO</th>
			<th align="center" width="120">ID</th>
			<th align="center" width="120">PW</th>
			<th align="center" width="120">이름</th>
			<th align="center" width="150">등록일자</th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="4">List is empty.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="member" items="${list}">
					<tr>
						<td align="center">${member.no}</td>
						<td align="center"><a
							href="/member/read?memberNo=${member.no}">${member.id}</a></td>
						<td align="center">${member.pwd}</td>
						<td align="center">${member.name}</td>
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