<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<body>
	<header>
		<h1>registerAjaxFileUpForm.jsp 입니다.</h1>
		<hr>
	</header>
	<main>
		<div>
			<input type="file" id="inputFile">
		</div>
	</main>
	<hr>
	<footer>
		<h1>footer</h1>
	</footer>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputFile").on("change", function(event) {
				console.log("change");
				var files = event.target.files;
				var file = files[0];
				console.log(file);
				var formData = new FormData();
				formData.append("file", file);
				$.ajax({
					type : "post",
					url : "/member/uploadAjax",
					data : formData,
					dataType : 'text',
					processData : false,
					contentType : false,
					success : function(data) {
						alert(data);
					}
				});
			});
		});
	</script>
</body>
</html>