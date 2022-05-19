<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%! String name, id, pw; %>
	<%
	request.setCharacterEncoding("utf-8"); // post방식으로 파라미터 전송시 사용
	name = request.getParameter("name");
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	%>
	<p>아이디는 <%=id %>이고</p>
	<p>패스워드는 <%=pw %> 입니다</p>
	<p><%=name %>님 반갑습니다</p>
</body>
</html>