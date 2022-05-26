<%@page import="java.util.Enumeration"%>
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
		Enumeration<String> sNames = session.getAttributeNames();
		int cnt = 0;
		
		while (sNames.hasMoreElements()) {
			String sName = sNames.nextElement();
			String sValue = (String)session.getAttribute(sName);
			out.println("<h4>세선명 : " + sName + " / 세션값 : " + sValue + "</h4>");
			cnt++;
		}
		if (cnt == 0) {
			out.println("<h4>유효한 세션이 없습니다</h4>");
			out.println("<button onclick=\"location.href='login.jsp'\">로그인</button>");
		} else {
			out.println("<button onclick=\"location.href='logout.jsp'\">로그아웃</button>");
		}
	%>
	<button onclick="history.go(-1);">이전페이지</button>
	<button onclick="location.href='welcome.jsp'">welcome페이지</button>
</body>
</html>