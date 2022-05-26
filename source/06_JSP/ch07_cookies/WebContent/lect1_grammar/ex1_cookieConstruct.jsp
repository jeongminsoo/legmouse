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
	<%
		Cookie cookie = new Cookie("cookieName", "cookieValue");
		cookie.setMaxAge(60*60); // 1시간동안 존재하는 cookie
		response.addCookie(cookie); // response객체에 탑재
	%>
	<h2>cookieConstruct 페이지에 생성된 쿠키 이름 : <%=cookie.getName() %></h2>
	<h2>cookieConstruct 페이지에 생성된 쿠키 값 : <%=cookie.getValue() %></h2>
	<hr>
	<a href="ex2_cookieList.jsp">cookie list 확인</a><br>
	<a href="ex3_thatCookie.jsp">특정 cookie 찾기</a><br>
	<a href="ex4_deleteCookie.jsp">cookie 삭제</a>
</body>
</html>