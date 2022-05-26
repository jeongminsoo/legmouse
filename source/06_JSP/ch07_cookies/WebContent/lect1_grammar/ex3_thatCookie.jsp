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
	<h1>특정 cookie 찾기</h1>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			int idx = 0;
			for (idx = 0; idx < cookies.length; idx++) {
				String name = cookies[idx].getName();
				if (name.equals("cookieName")) {
					String value = cookies[idx].getValue();
					out.println("<h2>찾고자 하는 cookie 이름 : " + name + ", 값 : " + value + "</h2><br>");
					break;
				}
			}
			if (idx == cookies.length) {
				out.println("찾고자하는 쿠키가 없습니다");
			}
		} else {
			out.println("생성된 cookie가 없습니다");
		}
	%>
	<a href="ex1_cookieConstruct.jsp">cooke 생성</a><br>
	<a href="ex2_cookieList.jsp">cookie list 확인</a><br>
	<a href="ex3_thatCookie.jsp">특정 cookie 찾기</a><br>
	<a href="ex4_deleteCookie.jsp">cookie 삭제</a>
</body>
</html>