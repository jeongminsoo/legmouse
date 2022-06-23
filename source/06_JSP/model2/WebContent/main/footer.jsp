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
	<link href="${conPath}/css/footer.css" rel="stylesheet">
</head>
<body>
	<footer>
		<div id="info_wrap">
			<ul>
				<li>(주)메가IT아카데미</li>
				<li>서울특별시 강남구 강남대로77길 77 칠칠빌딩 | <span><a href="${conPath }/login_a_view.do">관리자모드</a></span></li>
				<li>Copyrightⓒ 2022 mg. All rights reserved.</li>
			</ul>
		</div>
	</footer>
</body>
</html>