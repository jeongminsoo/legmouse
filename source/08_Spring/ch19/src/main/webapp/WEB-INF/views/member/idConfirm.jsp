<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<c:if test="${result  eq 1 }">
		중복된 아이디입니다
	</c:if>
	<c:if test="${result eq 0 }">
		사용가능한 아이디입니다
	</c:if>
</body>
</html>