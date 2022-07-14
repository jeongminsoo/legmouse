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
	<h2>board의 list.jsp페이지입니다</h2>
	<c:if test="${list.size() eq 0 }">
		<h3>입력된 member가 없습니다</h3>
	</c:if>
	<c:if test="${list.size() != 0 }">
		<c:forEach items="${list}" var="member">
			<h3>ID : ${member.id}</h3>
			<h3>PW : ${member.pw}</h3>
		</c:forEach>
		<h3>이상 ${list.size() }명</h3>
	</c:if>
	<h2 onclick="location.href='${conPath}/'">메인 페이지로 가기</h2>
</body>
</html>