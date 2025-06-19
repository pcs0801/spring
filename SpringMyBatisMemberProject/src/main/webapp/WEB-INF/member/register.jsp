<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./header.jsp"%>

<main>
	<h2>REGISTER</h2>
	<form:form modelAttribute="member" action="register">
		<table>
			<tr>
				<td>아이디</td>
				<td><form:input path="id" /></td>
				<td><font color="red"><form:errors path="id" /></font></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><form:input path="pw" /></td>
				<td><font color="red"><form:errors path="pw" /></font></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><form:textarea path="name" /></td>
				<td><font color="red"><form:errors path="name" /></font></td>
			</tr>
		</table>
	</form:form>
	<div>
		<button type="submit" id="btnRegister">멤버 입력</button>
		<button type="submit" id="btnList">멤버 전체 출력</button>
	</div>
</main>

<%@ include file="./footer.jsp"%>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		$("#btnRegister").on("click", function() {
			formObj.attr("action", "/member/register");
			formObj.attr("method", "post");
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			/*http://~:8080/member/list  */
			self.location = "/member/list";
		});
	});
</script>
