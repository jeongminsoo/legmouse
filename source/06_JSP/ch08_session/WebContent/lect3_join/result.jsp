<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		String msg = request.getParameter("msg");
	
		if (msg.equals("success")) {
			out.println("<h2>가입이 완료되었습니다</h2><hr><button onclick='login.jsp'>로그인</button></h2>");
		} else {
			out.println("<h2>가입되지 않습니다</h2><a href='join.jsp'>회원가입으로</a><hr><button onclick='login.jsp'>로그인</button></h2>");
		}
	%>
</body>
</html>