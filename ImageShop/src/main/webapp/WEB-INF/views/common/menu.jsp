<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div align="center">
	<table>
		<tr>
			<td width="80"><a href="/"><spring:message
						code="header.home" /></a></td>
			<sec:authorize access="!isAuthenticated()">
				<td width="120"><a href="/board/list"><spring:message
							code="menu.board.member" /></a></td>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td width="120"><a href="/codegroup/list"><spring:message
								code="menu.codegroup.list" /></a></td>
					<td width="120"><a href="/codedetail/list"><spring:message
								code="menu.codedetail.list" /></a></td>
					<td width="120"><a href="/user/list"><spring:message
								code="menu.user.admin" /></a></td>
					<td width="120"><a href="/board/list"><spring:message
								code="menu.board.member" /></a></td>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_MEMBER')">
					<td width="120"><a href="/board/list"><spring:message
								code="menu.board.member" /></a></td>
				</sec:authorize>
			</sec:authorize>
		</tr>
	</table>
</div>
<hr>