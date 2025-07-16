<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<jsp:include page="/WEB-INF/views/common/menu.jsp" />
<h2>
	<spring:message code="board.header.modify" />
</h2>
<form:form modelAttribute="board" action="modify">
	<form:hidden path="boardNo" />
	<input type="hidden" id="page" name="page" value="${pgrq.page}">
	<input type="hidden" id="sizePerPage" name="sizePerPage"
		value="${pgrq.sizePerPage}">
	<table>
		<tr>
			<td><spring:message code="board.title" /></td>
			<td><form:input path="title" /></td>
			<td><font color="red"><form:errors path="title" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="board.writer" /></td>
			<td><form:input path="writer" /></td>
			<td><font color="red"><form:errors path="writer" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="board.content" /></td>
			<td><form:textarea path="content" /></td>
			<td><font color="red"><form:errors path="content" /></font></td>
		</tr>
	</table>
</form:form>
<div>
	<sec:authentication property="principal" var="pinfo" />
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<button type="submit" id="btnModify">
			<spring:message code="action.modify" />
		</button>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_MEMBER')">
		<c:if test="${pinfo.username eq board.writer}">
			<button type="submit" id="btnModify">
				<spring:message code="action.modify" />
			</button>
		</c:if>
	</sec:authorize>
	<button type="submit" id="btnList">
		<spring:message code="action.list" />
	</button>
</div>
<script>
	$(document).ready(function() {
		var formObj = $("#board");
		$("#btnModify").on("click", function() {
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			// 페이징 관련 정보를 쿼리 파라미터로 전달한다.
			self.location = "list${pgrq.toUriString()}";
		});
	});
</script>
