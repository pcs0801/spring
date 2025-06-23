<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="./header.jsp"%>

<main>
	<h3>회원 상세 정보</h3>
	<form:form modelAttribute="member">
		<form:hidden path="no" />
		<table>
			<tr>
				<td>아이디</td>
				<td><form:input path="id" readonly="true" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><form:input path="name" readonly="true" /></td>
			</tr>
			<tr>
				<td>권한(1)</td>
				<td><form:select path="authList[0].auth" disabled="true">
						<form:option value="" label="=== 선택해주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
			</tr>
			<tr>
				<td>권한(2)</td>
				<td><form:select path="authList[1].auth" disabled="true">
						<form:option value="" label="=== 미설정 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
			</tr>
			<tr>
				<td>권한(3)</td>
				<td><form:select path="authList[2].auth" disabled="true">
						<form:option value="" label="=== 미설정 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
			</tr>
			<tr>
				<td>이메일(1)</td>
				<td><form:input path="emailList[0].email" readOnly="true"/>
			</tr>
			<tr>
				<td>이메일(2)</td>
				<td><form:input path="emailList[1].email" readOnly="true"/>
			</tr>
			<tr>
				<td>이메일(3)</td>
				<td><form:input path="emailList[2].email" readOnly="true"/>
			</tr>
		</table>
	</form:form>
	<div>
		<button type="submit" id="btnModify">수정</button>
		<button type="submit" id="btnRemove">삭제</button>
		<button type="submit" id="btnList">유저 목록</button>
	</div>
</main>

<%@ include file="./footer.jsp"%>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		console.log(formObj);
		$("#btnModify").on("click", function() {
			formObj.attr("action", "/member/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});
		$("#btnRemove").on("click", function() {
			formObj.attr("action", "/member/remove");
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			self.location = "/member/list";
		});
	});
</script>
