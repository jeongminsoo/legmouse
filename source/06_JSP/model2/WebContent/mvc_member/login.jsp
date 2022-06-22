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
	<c:if test="${joinResult eq 0 }">
		<script>
			alert('회원가입 실패! 다시 시도하세요');
			history.back();
		</script>
	</c:if>
	<c:if test="${joinResult eq 1 }">
		<script>
			alert('회원가입 성공! 로그인 하세요');
		</script>
	</c:if>
	<jsp:include page="header.jsp"/>
	<div id="login_wrap">
		<form>
			<table>
				<caption>사용자 로그인</caption>
				<tr>
					<th>ID</th>
					<td>
						<input type="text" name="mid" required="required" value="${mid }">
					</td>
				</tr>
				<tr>
					<th>PW</th>
					<td>
						<input type="password" name="mpw" required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인" class="btn">
						<input type="button" value="회원가입" class="btn" onclick="location.href='${conPath}/join_view.do'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>