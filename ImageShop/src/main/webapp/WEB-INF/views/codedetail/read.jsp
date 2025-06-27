<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<h2>
	<spring:message code="codedetail.header.read" />
</h2>
<form:form modelAttribute="codeDetail" id="codeDetail" method="post">
	<table>
		<tr>
			<td><spring:message code="codedetail.groupCode" /></td>
			<td><form:select path="groupCode" items="${groupCodeList}"
					itemValue="value" itemLabel="label" readonly="true" /></td>
			<td><font color="red"><form:errors path="groupCode" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="codedetail.codeValue" /></td>
			<td><form:input path="codeValue" readonly="true" /></td>
			<td><font color="red"><form:errors path="codeValue" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="codedetail.codeName" /></td>
			<td><form:input path="codeName" readonly="true" /></td>
			<td><font color="red"><form:errors path="codeName" /></font></td>
		</tr>
	</table>
	<div>
		<button type="button" id="btnEdit">
			<spring:message code="action.edit" />
		</button>
		<button type="button" id="btnRemove">
			<spring:message code="action.remove" />
		</button>
		<button type="button" id="btnList">
			<spring:message code="action.list" />
		</button>
	</div>
</form:form>
<script>
	$(document).ready(
			function() {
				var formObj = $("#codeDetail");
				$("#btnEdit").on(
						"click",
						function() {
							formObj.attr("action", "/codedetail/modify");
							formObj.attr("method", "get");
							formObj.submit();
							var groupCode = $("#groupCode");
							var groupCodeVal = groupCode.val();
							var codeValue = $("#codeValue");
							var codeValueVal = codeValue.val();
							self.location = "modify?groupCode=" + groupCodeVal
									+ "&" + "codeValue=" + codeValueVal;
						});
				$("#btnRemove").on("click", function() {
					formObj.attr("action", "remove");
					formObj.submit();
				});
				$("#btnList").on("click", function() {
					self.location = "list";
				});
			});
</script>