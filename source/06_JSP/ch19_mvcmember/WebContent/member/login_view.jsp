<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageConetext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="" method="post">
		<table>
			<caption>로그인</caption>
			<tr>
				<th>ID</th>
				<td><input type="text" name="mid"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="mpw"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="locaiton.href='${conPath}/join.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>