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
	<link href="${conPath}/css/header.css" rel="stylesheet">
</head>
<body>
	<header>
		<div id="gnb">
			<ul>
				<li><a href="">고객센터</a></li>
				<li><a href="${conPath }/join_view.do">회원가입</a></li>
				<li><a href="${conpath }/login_view.do">로그인</a></li>
			</ul>
		</div>
		<div id="logo">LOGO</div>
		<div id="lnb">
			<ul>
				<li><a href="">로그인전메뉴1</a></li>
				<li><a href="">로그인전메뉴2</a></li>
				<li><a href="">로그인전메뉴3</a></li>
				<li><a href="">로그인전메뉴4</a></li>
			</ul>
		</div>
	</header>
</body>
</html>