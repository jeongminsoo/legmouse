<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="textMail">
		<p>이름 <input type="text" name="name" required="required"></p>
		<p>메일 <input type="email" name="email" required="required"></p>
		<input type="submit" value="회원가입">
	</form>
	<hr color="green">
	<form action="htmlMail">
		<p>이름 <input type="text" name="name" required="required"></p>
		<p>메일 <input type="email" name="email" required="required"></p>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>