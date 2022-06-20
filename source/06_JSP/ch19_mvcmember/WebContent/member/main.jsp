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
	<c:if test="${loginResult eq 0 }">
		<script>
			alert('아이디 또는 비밀번호를 확인하세요.');
			history.back();
		</script>
	</c:if>
	
	<c:if test="${modifyResult eq 4 }">
		<script>
			alert('새비밀번호를 확인해주세요');
			history.back();
		</script>
	</c:if>
	
	<c:if test="${modifyResult eq 5 }">
		<script>
			alert('현재비밀번호가 다릅니다.');
			history.back();
		</script>
	</c:if>
	
	<c:if test="${modifyResult eq 0 }">
		<script>
			alert('정보수정 실패! 다시 시도해주세요.');
			history.back();
		</script>
	</c:if>
	
	<c:if test="${modifyResult eq 1 }">
		<script>
			alert('정보수정 성공!');
		</script>
	</c:if>
	
	
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
				<button onclick="location.href='${conPath}/login_view.do'">로그인</button>
				<button onclick="location.href='${conPath}/join_view.do'">회원가입</button>
				<button onclick="location.href='${conPath}/list_view.do'">전체회원보기</button>
			</c:if>
			<c:if test="${member != null }">
				<button onclick="location.href='${conPath}/modify_view.do'">정보수정</button>
				<button onclick="location.href='${conPath}/logout.do'">로그아웃</button>
				<button onclick="location.href='${conPath}/list_view.do'">전체회원보기</button>
			</c:if>
		</div>
	</div>
</body>
</html>