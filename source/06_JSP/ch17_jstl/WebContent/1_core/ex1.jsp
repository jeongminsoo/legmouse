<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>core 라리브러리</h2>
	<c:forEach var="i" begin="1" end="3" step="1">
		<p>${i }번째 안녕하세요</p>
	</c:forEach>
	
	<h2>fmt(formatting) 라이브러리</h2>
	<fmt:formatNumber value="3333.141592" pattern="#,###.00"/>
	<h2>그외 라이브러리(function 라이브러리)</h2>
	ID파라미터를 대분자로 : ${fn:toUpperCase(param.id) }
</body>
</html>