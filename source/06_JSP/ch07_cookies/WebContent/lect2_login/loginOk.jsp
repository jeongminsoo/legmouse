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
	<%! String id, pw; %>
	<%
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		if (id != null && id.equals("aaa") && pw != null && pw.equals("111")) {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(-1); // 유효시간은 브라우저 닫을 때까지
			response.addCookie(cookie);
			Cookie cookie2 = new Cookie("name", "홍길동");
			cookie2.setMaxAge(-1);
			response.addCookie(cookie2);
			response.sendRedirect("welcome.jsp");
		} else {
	%>
			<script>
				alert("아이디 또는 비밀번호를 확인하세요");
				location.href="login.html";
			</script>
	<%
		}
	%>
</body>
</html>