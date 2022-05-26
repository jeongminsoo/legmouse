<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		div { text-align : center; width : 350px;
			  height : 250px; 	   margin : 30px auto;
			  border : 1px solid black;
			}
		p { font-weight : bold; }
		p:first-child { color : red; }
		button { width : 100px; height : 50px; }
	</style>
</head>
<body>
<%
	String numStr = request.getParameter("num");
	int num = Integer.parseInt(numStr); 
	int coinLocation = (int)(Math.random()*3+1);
	if (num != coinLocation) {
		String msg = "Wong! Try Again!<br>(" + num + "은(는) 아니고 정답은 " + coinLocation + ")";
		msg = URLEncoder.encode(msg, "utf-8");
		response.sendRedirect("ex.jsp?msg="+ msg);
	}
%>
	<div>
	<p>정답입니다</p>
	<p>동전이 있었던 곳은 <%=coinLocation %></p>
	<button onclick="location.href='ex.jsp';">다시 도전</button>
	</div>
</body>
</html>