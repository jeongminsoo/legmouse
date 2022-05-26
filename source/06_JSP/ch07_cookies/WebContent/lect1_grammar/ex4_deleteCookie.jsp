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
	<h1>cookie 삭제</h1>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				String name = c.getName();
				if (name.equals("cookieName")) {
					// cookie 삭제 : 유효기간 0초인 같은이름의 cookie를 만들어 덮어 씀
					Cookie cookie = new Cookie("cookieName", "cookieValue");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					out.println("<h3>cookie 삭제 성공</h3>");
					break;
				}
			}
		} else {
			out.println("삭제할 쿠키가 없습니다");
		}
	%>
	<a href="ex1_cookieConstruct.jsp">cooke 생성</a><br>
	<a href="ex2_cookieList.jsp">cookie list 확인</a><br>
	<a href="ex3_thatCookie.jsp">특정 cookie 찾기</a><br>
	<a href="ex4_deleteCookie.jsp">cookie 삭제</a>
</body>
</html>