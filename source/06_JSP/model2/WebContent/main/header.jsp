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
				<c:if test="${(member eq null) && (admin eq null) }">
					<li><a href="${conPath }/fileboardList.do?pageNum=1">고객센터</a></li>
					<li><a href="${conPath }/join_view.do">회원가입</a></li>
					<li><a href="${conPath }/login_m_view.do">로그인</a></li>
				</c:if>
				<c:if test="${member != null }">
					<li><a href="${conPath }/fileboardList.do?pageNum=1">고객센터</a></li>
					<li><a href="${conPath }/logout.do">로그아웃</a></li>
					<li><a href="${conPath }/modify_view.do">정보수정</a></li>
					<li>${member.mname }님</li>
				</c:if>
				<c:if test="${admin != null }">
					<li><a href="${conPath }/fileboardList.do?pageNum=1">고객센터</a></li>
					<li><a href="${conPath }/alogout.do">관리자모드나가기</a></li>
					<li><a href="${conPath }/add_view.do">관리자추가</a></li>
					<li>${admin.aname }님</li>
				</c:if>
			</ul>
		</div>
		<div id="logo">LOGO</div>
		<div id="lnb">
			<ul>
				<c:if test="${(member eq null) && (admin eq null) }">
					<li><a href="">로그인전메뉴1</a></li>
					<li><a href="">로그인전메뉴2</a></li>
					<li><a href="">로그인전메뉴3</a></li>
					<li><a href="">로그인전메뉴4</a></li>
				</c:if>
				<c:if test="${member != null }">
					<li><a href="">로그인후메뉴1</a></li>
					<li><a href="">로그인후메뉴2</a></li>
					<li><a href="">로그인후메뉴3</a></li>
					<li><a href="">로그인후메뉴4</a></li>
				</c:if>
				<c:if test="${admin != null }">
					<li><a href="${conPath }/memberList_view.do?pageNum=1">전체회원리스트</a></li>
					<li><a href="">관리자메뉴2</a></li>
					<li><a href="">관리자메뉴3</a></li>
					<li><a href="">관리자메뉴4</a></li>
				</c:if>
			</ul>
		</div>
	</header>
</body>
</html>