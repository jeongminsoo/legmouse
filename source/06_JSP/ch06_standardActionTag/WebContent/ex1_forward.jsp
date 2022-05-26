<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- ex1_forward.jsp?n=1 로 요청/ sndRedirect에서 n값은 전달되지 않는다 -->
	<h2>ex1_forward.jsp 페이지입니다</h2>
	<% response.sendRedirect("ex2_forward.jsp"); %>
</body>
</html>