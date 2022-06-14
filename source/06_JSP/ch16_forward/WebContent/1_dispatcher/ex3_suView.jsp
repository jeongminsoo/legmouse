<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>ex3_suView.jsp 페이지입니다</h2>
	<h3>1부터 ${param.su }까지 누적합 : ${requestScope.sum }</h3>
	<button onclick="history.back()">이전</button>
	<button onclick="location.href='1_dispatcher/ex3_suInput.jsp'">다시</button>
</body>
</html>