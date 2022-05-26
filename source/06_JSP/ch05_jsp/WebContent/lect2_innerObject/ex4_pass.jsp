<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	String str = request.getParameter("age");
	int age = Integer.parseInt(str);
%>
	<h2><%=age %>살 성인이니 주류 구매 가능</h2>
	<button onclick="history.go(-1);">뒤로가기</button>
</body>
</html>