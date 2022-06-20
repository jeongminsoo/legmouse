<%@page import="com.lec.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		MemberDao dao = MemberDao.getInstance();
	%>
	<c:if test="${joinResult eq MemberDao.SUCCESS }">
		<script>
			alert('회원가입 성공! 로그인해주세요');
		</script>
	</c:if>
	
	<c:if test="${joinResult eq MemberDao.ID_NONEXISTENT }">
		<script>
			alert('중복된 아이디입니다.);
			history.back();
		</script>
	</c:if>
	
	<c:if test="${joinResult eq MemberDao.FAIL }">
		<script>
			alert('회원가입 실패! 비밀번호 또는 정보입력을 확인하세요');
			history.back();
		</script>
	</c:if>
	
	<form action="login.do" method="post">
		<table>
			<caption>로그인</caption>
			<tr>
				<th>ID</th>
				<td><input type="text" name="mid"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="mpw"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location.href='${conPath }/join_view.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>