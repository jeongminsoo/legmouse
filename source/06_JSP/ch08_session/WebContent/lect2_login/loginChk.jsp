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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if (id == null || !id.equals("aaa")) {
	%>
			
		<script>
			alert('아이디를 확인하세요');
			location.href="login.jsp";
		</script>
	<% 
		} else if (pw == null || !pw.equals("111")) {
	%>
		<script>
			alert('패스워드를 확인하세요');
			location.href="login.jsp";
		</script>
	<%	} else {
			session.setAttribute("id", "aaa");
			session.setAttribute("name", "홍길동");
			response.sendRedirect("welcome.jsp");
		}
	%>
</body>
</html>