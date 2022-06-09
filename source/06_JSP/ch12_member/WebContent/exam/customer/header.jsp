<%@page import="com.lec.customer.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath();
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/exam/css/header.css" rel="stylesheet">
</head>
<body>
	<header>
		<div id="logo">
			<img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F5090%2F2022%2F03%2F03%2F0002112061_001_20220303142801259.jpg&type=a340" alt="logo" height="100">
		</div>
		<ul>
		<%
			if (customer != null) {
		%>
			<li><a href='<%=conPath %>/exam/customer/logout.jsp'>로그아웃</a></li>
			<li><a href='<%=conPath %>/exam/customer/update.jsp'>정보수정</a></li>
			<li><a href=""><%=customer.getName() %>님</a></li>
			
			
		<%
			} else {
		%>
			<li><a href='<%=conPath %>/exam/customer/join.jsp'>회원가입</a></li>
			<li><a href='<%=conPath %>/exam/customer/login.jsp'>로그인</a></li>
			<li><a href='<%=conPath %>/exam/customer/main.jsp'>홈</a></li>
		<%
			}
		%>
			
		</ul>
	</header>
</body>
</html>