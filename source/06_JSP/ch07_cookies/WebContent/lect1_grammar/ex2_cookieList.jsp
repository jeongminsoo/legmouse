<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>cookie list</h1>
	<%
		Cookie[] cookies = request.getCookies();
		for(int idx = 0; idx < cookies.length; idx++) {
			String name = cookies[idx].getName();
			String value = cookies[idx].getValue();
			out.println("<h2>" + idx + "번째 cookie 이름 : " + name + ", 값 : " + value + "</h2><br>");
		}
	%>
	<a href="ex1_cookieConstruct.jsp">cooke 생성</a><br>
	<a href="ex2_cookieList.jsp">cookie list 확인</a><br>
	<a href="ex3_thatCookie.jsp">특정 cookie 찾기</a><br>
	<a href="ex4_deleteCookie.jsp">cookie 삭제</a>
</body>
</html>