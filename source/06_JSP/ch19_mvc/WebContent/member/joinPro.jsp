<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<c:if test="${result eq 0 }">
		<script>
			alert('회원가입 실패! 아이디가 중복되었습니다');
			history.back()
		</script>
	</c:if>
	<c:if test="${result eq 1 }">
		<script>
			alert('회원가입 성공');
			location.href="index.jsp";
		</script>
	</c:if>
</body>
</html>