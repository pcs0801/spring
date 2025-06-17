<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./header.jsp"%>


<main>
	<h2>── 유저 신규 등록 ──</h2>
	<form:form modelAttribute="member" action="insert">
		<table>
			<tr>
				<td>아이디</td>
				<td><form:input path="id" style='border-radius:5px;'/></td>
				<td><font color="red"><form:errors path="id" /></font></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:input path="pwd" style='border-radius:5px;'/></td>
				<td><font color="red"><form:errors path="pwd" /></font></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><form:input path="name" style='border-radius:5px;'/></td>
				<td><font color="red"><form:errors path="name" /></font></td>
			</tr>
		</table>
	</form:form>
	<div style='padding-top:10px'>
		<button style='border-radius:15px; border:1px solid black; background-color:lightyellow; padding:5px; margin-left:10px;' type="submit" id="btnInsert">유저 등록</button>
		<button style='border-radius:15px; border:1px solid black; background-color:lightyellow; padding:5px; margin-left:30px;' type="submit" id="btnList">유저 목록 전체 출력</button>
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
