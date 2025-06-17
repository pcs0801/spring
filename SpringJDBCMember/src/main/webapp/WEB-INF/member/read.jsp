<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./header.jsp"%>

<main>
	<h2>── 유저 정보 ──</h2>
	<form:form modelAttribute="member">
		<form:hidden path="no" />
		<table>
			<tr>
				<td>번호</td>
				<td><form:input path="no" readonly="true" style='border-radius:5px;'/></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><form:input path="id" readonly="true" style='border-radius:5px;'/></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:input path="pwd" readonly="true" style='border-radius:5px;'/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><form:input path="name" readonly="true" style='border-radius:5px;'/></td>
			</tr>
			<tr>
				<td>등록일자</td>
				<td><form:input path="regDate" readonly="true" style='border-radius:5px;'/></td>
			</tr>
		</table>
	</form:form>
	<div style='margin-top:10px;'>
		<button style='border-radius:10px; border:1px solid black; background-color:lightyellow; padding:3px; margin-left:10px; width:50px;' type="button" id="btnUpdate">수정</button>
		<button style='border-radius:10px; border:1px solid black; background-color:lightyellow; padding:3px; margin-left:10px; width:50px;' type="button" id="btnDelete">삭제</button>
		<button style='border-radius:10px; border:1px solid black; background-color:lightyellow; padding:3px; margin-left:10px; width:100px;' type="button" id="btnList">유저 전체 목록</button>
	</div>
</main>

<%@ include file="./footer.jsp"%>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		console.log(formObj);
		$("#btnUpdate").on("click", function() {
			var no = $("#no");
			var noVal = no.val();
			self.location = "/member/update?no=" + noVal;
		});
		$("#btnDelete").on("click", function() {
			formObj.attr("action", "/member/delete");
			formObj.attr("method", "post");
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			self.location = "/member/list";
		});
	});
</script>
