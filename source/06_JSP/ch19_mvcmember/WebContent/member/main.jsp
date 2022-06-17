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
	<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<div id="status">
			<c:if test="${member eq null }">
				<p>로그인 상태가 아닙니다</p>
			</c:if>
			<c:if test="${member != null }">
				<p>${member.mname }(${member.mid })님 어서오세요</p>
			</c:if>
		</div>
		<div id="btn_wrap">
			<c:if test="${member eq null }">
				<button onclick="location.href='${conPath}/login.do'">로그인</button>
				<button onclick="location.href='${conPath}/join.do'">회원가입</button>
				<button onclick="location.href='${conPath}/list.do'">전체회원보기</button>
			</c:if>
			<c:if test="${member != null }">
				<button onclick="location.href='${conPath}/modify_view.do'">정보수정</button>
				<button onclick="location.href='${conPath}/logout.do'">로그아웃</button>
				<button onclick="location.href='${conPath}/list.do'">전체회원보기</button>
			</c:if>
		</div>
	</div>
</body>
</html>