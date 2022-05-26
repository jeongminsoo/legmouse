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
		boolean ok = false;
		Cookie[] cs = request.getCookies();
		if (cs != null) {
			for (Cookie c : cs) {
				String cName = c.getName();
				String cValue = c.getValue();
				if (cName.equals("id") || cName.equals("name")) {
					out.println("<h3>cookie 이름 : " + cName + ", 값 : " + cValue + "</h3><br>");
					ok = true;
				}
			}
		}
		if (!ok) {
			out.println("<h3>생성된 쿠키가 없습니다(단, 시스템 쿠키는 제외)</h2>");
		}
	%>
	<button onclick="history.go(-1);">뒤로가기</button>
	<button onclick="location.href='welcome.jsp'">welcome페이지</button>
</body>
</html>