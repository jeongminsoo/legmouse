<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h1>GET방식</h1>
	<form action="${conPath }/student.do" method="get">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id"></td>
			</tr>
		</table>
		<div><input type="submit" value="GET방식으로 보내기"></div>
	</form>
	<hr>
	<h1>POST방식</h1>
	<form action="${conPath }/student.do" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id"></td>
			</tr>
		</table>
		<div><input type="submit" value="POST방식으로 보내기"></div>
	</form>
	<hr>
	<h1>redirect, forward 키워드 예제</h1>
	<form action="${conPath }/idConfirm.do" method="get">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id"></td>
			</tr>
		</table>
		<div><input type="submit" value="idConfirm"></div>
	</form>
	<hr>
	<a href="${conPath }/fullpath.do">Fullpath로 가기</a>
</body>
</html>