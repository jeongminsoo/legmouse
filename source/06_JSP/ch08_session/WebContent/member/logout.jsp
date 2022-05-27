<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/logout.css" rel="stylesheet">
	<script>
		setTimeout(function () {
			location.href="main.jsp";
		}, 3000);
	</script>
</head>
<body>
	<%
		session.invalidate();
	%>
	<jsp:include page="header.jsp"/>
	<div id="logout_main">
		<h1>로그아웃되었습니다. 잠시후 페이지 이동이 있겠습니다</h1>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>