<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./header.jsp"%>

<main>
	<h2>── 유저 신규 등록 ──</h2>
	<form:form modelAttribute="member" action="insert">
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
		<button type="submit" id="btnInsert">유저 등록</button>
		<button type="submit" id="btnList"> 유저 목록 전체 출력</button>
	</div>
</main>

<%@ include file="./footer.jsp"%>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		$("#btnInsert").on("click", function() {
			formObj.attr("action", "/member/insert");
			formObj.attr("method", "post");
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			self.location = "/member/list";
		});
	});
</script>
