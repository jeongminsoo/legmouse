<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function() {
			
		});
	</script>
</head>
<body>
	<div align="center">
		<hr width="500" color="green">
		<h2>파일 UPLOAD</h2>
		<hr width="500" color="green">
		<form action="fileupload" method="post" enctype="multipart/form-data">
			<p>첨부파일1 <input type="file" name="file1"></p>
			<p>첨부파일2 <input type="file" name="file2"></p>
			<p>첨부파일3 <input type="file" name="file3"></p>
			<p><input type="submit" value="전송"></p>
		</form>
	</div>
</body>
</html>