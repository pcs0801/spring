<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="./header.jsp"%>

<main>
	<h3>회원 정보 수정</h3>
	<form:form modelAttribute="member" action="modify">
		<form:hidden path="no" />
		<table>
			<tr>
				<td>아이디</td>
				<td><form:input path="id" readonly="true" /></td>
				<td><font color="red"><form:errors path="id" /></font></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><form:input path="name" /></td>
				<td><font color="red"><form:errors path="name" /></font></td>
			</tr>
			<tr>
				<td>권한 - 1</td>
				<td><form:select path="authList[0].auth">
						<form:option value="" label="=== 선택해주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
				<td><font color="red"><form:errors
							path="authList[0].auth" /></font></td>
			</tr>
			<tr>
				<td>권한 - 2</td>
				<td><form:select path="authList[1].auth">
						<form:option value="" label="=== 선택해주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
				<td><font color="red"><form:errors
							path="authList[1].auth" /></font></td>
			</tr>
			<tr>
				<td>권한 - 3</td>
				<td><form:select path="authList[2].auth">
						<form:option value="" label="=== 선택해주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
				<td><font color="red"><form:errors
							path="authList[2].auth" /></font></td>
			</tr>
			<tr>
				<td>이메일 - 1</td>
				<td><form:select path="emailList[0].email">
						<form:option value="" label="=== 입력해주세요 ===" />
						<form:option value="test1@test1.com" label="이메일테스트1" />
						<form:option value="test2@test2.com" label="이메일테스트2" />
						<form:option value="test3@test3.com" label="이메일테스트3" />
					</form:select></td>
				<td><font color="red"><form:errors
							path="emailList[0].email" /></font></td>
			</tr>
			<tr>
				<td>이메일 - 2</td>
				<td><form:select path="emailList[1].email">
						<form:option value="" label="=== 입력해주세요 ===" />
						<form:option value="test1@test1.com" label="이메일테스트1" />
						<form:option value="test2@test2.com" label="이메일테스트2" />
						<form:option value="test3@test3.com" label="이메일테스트3" />
					</form:select></td>
				<td><font color="red"><form:errors
							path="emailList[1].email" /></font></td>
			</tr>
			<tr>
				<td>이메일 - 3</td>
				<td><form:select path="emailList[2].email">
						<form:option value="" label="=== 입력해주세요 ===" />
						<form:option value="test1@test1.com" label="이메일테스트1" />
						<form:option value="test2@test2.com" label="이메일테스트2" />
						<form:option value="test3@test3.com" label="이메일테스트3" />
					</form:select></td>
				<td><font color="red"><form:errors
							path="emailList[2].email" /></font></td>
			</tr>

		</table>
	</form:form>
	<div>
		<button type="submit" id="btnModify">수정</button>
		<button type="submit" id="btnList">유저 목록</button>
	</div>
</main>

<%@ include file="./footer.jsp"%>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		$("#btnModify").on("click", function() {
			formObj.attr("action", "/member/modify");
			formObj.attr("method", "post");
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			self.location = "/member/list";
		});
	});
</script>