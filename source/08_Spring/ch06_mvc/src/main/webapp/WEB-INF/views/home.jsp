<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	<link href="css/style.css" rel="stylesheet">
</head>
<body>
<h1>
	${greeting }
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>2022년 7월 14일</p>
<p><img src="img/gucci1.jpg"></p>
</body>
</html>