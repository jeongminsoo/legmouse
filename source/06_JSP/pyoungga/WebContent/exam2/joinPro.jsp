<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="join.css" rel="stylesheet">
</head>
<body>
<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String birth = request.getParameter("birth");
	Timestamp birth2 = Timestamp.valueOf(request.getParameter("birth") + " 00:00:00");	
	String[] hobby = request.getParameterValues("hobby");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String[] mailSend = request.getParameterValues("mailSend");
	Date joinDate = new Date(System.currentTimeMillis());
	String joinIP = request.getRemoteAddr();
%>
	<div id="wrap">
		<div id="title">회원가입정보</div>
		<h2>name : <%=name %></h2>
		<h2>id : <%=id %></h2>
		<h2>pw : 
		<% 
			for (int i = 0; i < pw.length(); i++) {
				out.print("*");
			}
		%>
		</h2>
		<h2>birth : <%=birth %></h2>
		<h2>birth2 : <%=birth2 %></h2>
		<h2>hobby : 
		<%
			for(int i=0; i<hobby.length; i++) {
				out.print(hobby[i] + " ");
			}
		%>
		</h2>
		<h2>gender : <%=gender %></h2>
		<h2>email : <%=email %></h2>
		<h2>mailSend : 
			<% 
				if (mailSend == null) {
					out.print("모두 수신 거부");
				} else {
					out.print(Arrays.toString(mailSend));
				}
			%>
		</h2>
		<h2>가입일 : <%=joinDate %></h2>
		<h2>가입IP : <%=joinIP %></h2>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>