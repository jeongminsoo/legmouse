<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<c:set var="visitNum" value="${param.visitNum }"/>
	<c:if test="${visitNum eq 0 }">
		첫 방문이네
	</c:if>
	<c:if test="${visitNum > 0 && visitNum < 5 }">
		반가워 자주오네
	</c:if>
	<c:if test="${visitNum >= 5}">
		친구 안녕 또왔네
	</c:if>
</body>
</html>