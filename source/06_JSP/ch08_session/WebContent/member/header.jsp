<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/header.css" rel="stylesheet">
</head>
<body>
	<header>
		<div id="logo">
			<a href="main.jsp"><img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F5090%2F2022%2F03%2F03%2F0002112061_001_20220303142801259.jpg&type=a340" alt="logo" height="100"></a>
		</div>
		<ul>
			<%
				String name = (String)session.getAttribute("name");
				if (name == null) {
			%>
					<li><a href="join.jsp">회원가입</a>
					<li><a href="login.jsp">로그인</a>
					<li><a href="main.jsp">홈</a>
			<%
				} else {
			%>
					<li><a href="logout.jsp">로그아웃</a>
					<li><a href="">정보수정</a>
					<li><a href=""><%=name %>님</a></li>
			<%
				}
			%>
			
		</ul>
	</header>
</body>
</html>