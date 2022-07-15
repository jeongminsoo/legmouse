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
	<form action="${conPath }/input.do">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="number" name="id" placeholder="자연수 입력" value='${student.id eq 0 ? "" : student.id}'></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${student.name }"></td>
			</tr>
		</table>
		<div><input type="submit" value="input"></div>
	</form>
	<h4>${nameError }</h4>
	<h4>${idError }</h4>
</body>
</html>