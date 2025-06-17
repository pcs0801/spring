<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./header.jsp"%>

<main>
	<h2>── 유저 정보 수정 ──</h2>
	<form:form modelAttribute="member" action="update">
		<form:hidden path="no" />
		<table>
			<tr>
				<td>아이디</td>
				<td><form:input path="id" /></td>
				<td><font color="red"><form:errors path="id" /></font></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:input path="pwd" /></td>
				<td><font color="red"><form:errors path="pwd" /></font></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><form:input path="name" /></td>
				<td><font color="red"><form:errors path="name" /></font></td>
			</tr>
		</table>
	</form:form>

	<div>
		<button type="submit" id="btnUpdate">수정 완료</button>
		<button type="submit" id="btnList">유저 목록</button>
	</div>

</main>

<%@ include file="./footer.jsp"%>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		$("#btnUpdate").on("click", function() {
			formObj.attr("action", "/member/update");
			formObj.attr("method", "post");
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			self.location = "/member/list";
		});
	});
</script>