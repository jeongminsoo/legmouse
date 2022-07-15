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
	<h2>검증이 완료된 결과 페이지</h2>
	<h4>아이디 : ${student.id }</h4>
	<h4>이름 : ${student.name }</h4>
	<button onclick="location.href='${conPath}/inputForm.do'">다시하기</button>
</body>
</html>