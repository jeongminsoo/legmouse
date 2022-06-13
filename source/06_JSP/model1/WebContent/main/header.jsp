<%@page import="com.lec.dto.CustomerDto"%>
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
	<link href="<%=conPath%>/css/header.css" rel="stylesheet">
</head>
<body>
	<header>
		<div class="gnb">
			<ul>
		<%
			if (customer != null) {
		%>
				<li><a href='<%=conPath %>/fileboard/fboardList.jsp'>고객센터</a></li>
				<li><a href='<%=conPath %>/customer/logout.jsp'>로그아웃</a></li>
				<li><a href='<%=conPath %>/customer/updateForm.jsp'>정보수정</a></li>
				<li><a href=""><%=customer.getCname() %></a></li>
			
			
		<%
			} else {
		%>
				<li><a href='<%=conPath %>/fileboard/fboardList.jsp'>고객센터</a></li>
				<li><a href='<%=conPath %>/customer/joinForm.jsp'>회원가입</a></li>
				<li><a href='<%=conPath %>/customer/loginForm.jsp'>로그인</a></li>
		<%
			}
		%>
			
			</ul>
		</div>
		<div class="logo">
			<img src="https://www.moel.go.kr/images/layout/img_footer_logo.png" alt="logo" onclick="location.href='<%=conPath%>/main/main.jsp'">
		</div>
		<div class="lnb">
			<ul>
				<%
					if (customer != null) {
				%>
						<li><a href='<%=conPath %>/book/bookRegister.jsp'>도서등록</a></li>
						<li><a href='<%=conPath %>/book/bookList.jsp'>도서보기</a></li>
				<%
					} else {
				%>
						<li><a href='<%=conPath %>/book/bookList.jsp'>도서보기</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</header>
</body>
</html>