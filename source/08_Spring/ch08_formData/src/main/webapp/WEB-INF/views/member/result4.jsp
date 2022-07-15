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
	<h2>cnt, list 고정</h2>
	<h3>cnt : ${cnt }</h3>
	<h3>list : ${list }</h3>
	<hr color="black">
	<h2>result4.jsp 페이지</h2>
	<h4>ID : ${member.id }</h4>
	<h4>PW : ${member.pw }</h4>
	<h4>이름 : ${member.name }</h4>
	<h4>나이 : ${member.age }</h4>
	<h4>메일 : ${member.email }</h4>
	<h4>주소 : ${member.address }</h4>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath}/'">처음으로</button>
</body>
</html>