<%@page import="com.lec.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<c:if test="${joinResult eq 2 }">
		<script>
			alert('중복된 아이디입니다. 다시 시도해주세요');
			history.back();
		</script>
	</c:if>
	
	<c:if test="${joinResult eq 1}">
		<script>
			alert('회원가입 성공! 로그인해주세요');
		</script>
	</c:if>
	
	<c:if test="${joinResult eq 0 }">
		<script>
			alert('회원가입 실패! 정보를 너무 많이 입력했거나 잘못입력하였습니다. 다시 시도해주세요');
			history.back();
		</script>	
	</c:if>
	
	<c:if test="${joinResult eq 4 }">
		<script>
			alert('비밀번호를 확인해주세요');
			history.back();
		</script>
	</c:if>
	
	<form action="${conPath }/login.do" method="post">
		<table>
			<caption>로그인</caption>
			<tr>
				<th>ID</th>
				<td><input type="text" name="mid" value='${id eq null ? "" : id }'></td>
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