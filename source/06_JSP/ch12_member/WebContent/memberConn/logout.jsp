<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		session.invalidate();
	%>
	<script>
		setTimeout(function () {
			location.href='main.jsp';
		}, 5000);
	</script>
	<h2>로그아웃 되었습니다. 잠시후 페이지를 이동합니다</h2>
</body>
</html>