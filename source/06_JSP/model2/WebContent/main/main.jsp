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
	<link href="${conPath}/css/main.css" rel="stylesheet">
</head>
<body>
	<c:if test="${modifyResult eq 1 }">
		<script>
			alert('수정 성공!');
		</script>
	</c:if>
	<c:if test="${modifyResult eq 0 }">
		<script>
			alert('수정 실패! 다시 시도하세요');
			history.back();
		</script>
	</c:if>
	
	<c:if test="${memberLoginResult eq 0 }">
		<script>
			alert('아이디 또는 비밀번호를 확인하세요');
			history.back();
		</script>
	</c:if>
	<c:if test="${aloginResult eq 0 }">
		<script>
			alert('아이디 또는 비밀번호를 확인하세요');
			history.back();
		</script>
	</c:if>
	<c:if test="${addResult eq 0 }">
		<script>
			alert('관리자 추가 실패! 다시 시도하세요');
			history.back();
		</script>
	</c:if>
	<c:if test="${addResult eq 1 }">
		<script>
			alert('관리자 추가 성공!');
		</script>
	</c:if>
	
	<jsp:include page="header.jsp"/>
	<div id="main_wrap">
		<c:if test="${member eq null && admin eq null}">
			<h1>MAIN</h1>
		</c:if>
		<c:if test="${member != null }">
			<h2>${member.mname }(${member.mid })님 반갑습니다</h2>
		</c:if>
		<c:if test="${admin != null }">
			<h2>관리자 모드입니다</h2>
		</c:if>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>