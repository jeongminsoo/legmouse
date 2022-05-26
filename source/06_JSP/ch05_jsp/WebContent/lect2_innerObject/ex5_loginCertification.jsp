<%@page import="java.net.URLEncoder"%>
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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if (id == null || !id.equals("aaa") || pw == null || !pw.equals("111")) {
			String msg = "아이디 또는 비밀번호를 확인하세요";
			msg = URLEncoder.encode(msg,"utf-8");
			response.sendRedirect("ex5_loginFrm.jsp?msg="+msg);
		}
	%>
	<p>아이디는 <%=id %>이고</p>
	<p>비밀번호는 <%=pw %>입니다</p>
	<p>반갑습니다</p>
</body>
</html>